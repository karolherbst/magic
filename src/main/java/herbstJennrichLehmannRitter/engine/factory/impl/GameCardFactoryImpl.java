package herbstJennrichLehmannRitter.engine.factory.impl;

import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Cards;

import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class GameCardFactoryImpl implements GameCardFactory {

	private Unmarshaller unmarshaller;
	private Map<String, Card> cards;
	
	public GameCardFactoryImpl() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("herbstJennrichLehmannRitter.engine.model");
			this.unmarshaller = jaxbContext.createUnmarshaller();
			
			InputStream is = this.getClass().getResourceAsStream("/herbstJennrichLehmannRitter/engine/model/cards.xml");
			Cards cards = (Cards)this.unmarshaller.unmarshal(is);
			
			if (cards.getCards() == null || cards.getCards().isEmpty())
				throw new EngineCouldNotStartException("the cards.xml provides no cards");
			
			// store all cards in a map to improve performance (getting a card from a HashMap is less expensive than from
			// a list even if the list is sorted
			this.cards = new HashMap<String, Card>(cards.getCards().size(), 1);
			for (Card card : cards.getCards()) {
				this.cards.put(card.getName(), card);
			}
			
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new EngineCouldNotStartException(e);
		}
	}
	
	public Card createCard(String card) {
		return this.cards.get(card);
	}

	public Collection<Card> createDefaultDeck() {
		return null;
	}

}
