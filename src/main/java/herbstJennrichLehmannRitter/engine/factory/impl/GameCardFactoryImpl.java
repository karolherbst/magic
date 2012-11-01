package herbstJennrichLehmannRitter.engine.factory.impl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.exception.CardFactoryFileException;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.impl.CardImpl;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCard;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCards;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class GameCardFactoryImpl implements GameCardFactory {

	private Unmarshaller unmarshaller;
	private Marshaller marshaller;
	private Map<String, Card> cards;
	private Map<String, Class<?>> complexCardActions;
	
	private static void assertCard(Card card) {
		final String DEFAULT_ERROR_STRING = "Card with name " + card.getName() + ' ';
		
		if (card.getCardType() == null) {
			throw new EngineCouldNotStartException(DEFAULT_ERROR_STRING + "has no CardType");
		}
		
		if (card.getCostBrick() < 0) {
			throw new EngineCouldNotStartException(DEFAULT_ERROR_STRING + "has brick costs < 0");
		}
		
		if (card.getCostCrystal() < 0) {
			throw new EngineCouldNotStartException(DEFAULT_ERROR_STRING + "has brick crystal < 0");
		}

		if (card.getCostMonsters() < 0) {
			throw new EngineCouldNotStartException(DEFAULT_ERROR_STRING + "has brick monster < 0");
		}
	}
	
	private static Map<String, Class<?>> getComplexCardActions(String packageName) throws IOException, ClassNotFoundException {
		Map<String, Class<?>> classes = new HashMap<String, Class<?>>();
		
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL resource = classLoader.getResource(packageName.replace('.', '/'));
		File directory = new File(URLDecoder.decode(resource.getFile(), "UTF-8"));
		
		if (!directory.exists()) {
			throw new EngineCouldNotStartException("could not find ComplexCard Actions");
		}
		File[] files = directory.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");
			}
		});
		
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String className = file.getName().substring(0, file.getName().length() - 6);
			Class<?> currentClass = Class.forName(packageName + '.' + className);
			ComplexCard complexCard = currentClass.getAnnotation(ComplexCard.class);
			classes.put(complexCard.value(), currentClass);
		}
		
		return classes;
	}
	
	public GameCardFactoryImpl() {
		try {
			this.complexCardActions = getComplexCardActions("herbstJennrichLehmannRitter.engine.model.action.complexImpl");
		} catch (IOException e) {
			throw new EngineCouldNotStartException(e);
		} catch (ClassNotFoundException e) {
			throw new EngineCouldNotStartException(e);
		}
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("herbstJennrichLehmannRitter.engine.model");
			this.unmarshaller = jaxbContext.createUnmarshaller();
			this.marshaller = jaxbContext.createMarshaller();
			
			InputStream is = this.getClass().getResourceAsStream("/herbstJennrichLehmannRitter/engine/model/cards.xml");
			XmlCards xmlCards = (XmlCards)this.unmarshaller.unmarshal(is);
			is.close();
			
			if (xmlCards.getCards() == null || xmlCards.getCards().isEmpty()) {
				throw new EngineCouldNotStartException("the cards.xml provides no cards");
			}
			
			// store all cards in a map to improve performance (getting a card from a HashMap is less expensive than from
			// a list even if the list is sorted
			this.cards = new HashMap<String, Card>(xmlCards.getCards().size(), 1);
			for (XmlCard card : xmlCards.getCards()) {
				assertCard(card);
				Class<?> complexActionClass = this.complexCardActions.get(card.getName());
				
				if (complexActionClass != null) {
					try {
						card.setComplexCardAction((ComplexCardAction)complexActionClass.newInstance());
						
					} catch (InstantiationException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
				
				this.cards.put(card.getName(), card);
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new EngineCouldNotStartException(e);
		} catch (IOException e) {
			// this can be ignored
		}
	}
	
	@Override
	public Card createCard(String cardName) {
		// we have to create a complete new instance
		Card card = this.cards.get(cardName);
		return new CardImpl(card);
	}

	@Override
	public Collection<Card> createDefaultDeck() {
		return getAllPossibleCards();
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		Collection<Card> allPossibleCards = new ArrayList<Card>();
		
		for (String cardName : getAllPossibleCardNames()) {
			allPossibleCards.add(createCard(cardName));
		}
		
		return allPossibleCards;	
	}
	
	@Override
	public Collection<String> getAllPossibleCardNames() {
		return this.cards.keySet();
	}

	@Override
	public void saveToXml(Collection<String> cardNames, Writer destination) {
		try {
			this.marshaller.marshal(cardNames, destination);
		} catch (JAXBException e) {
			throw new CardFactoryFileException("couldn't write objects to file", e);
		}
	}

	@Override
	public Collection<Card> loadFromXml(Reader source) {
		try {
			return (Collection<Card>)this.unmarshaller.unmarshal(source);
		} catch (JAXBException e) {
			throw new CardFactoryFileException("couldn't read objects from file", e);
		}
	}

}
