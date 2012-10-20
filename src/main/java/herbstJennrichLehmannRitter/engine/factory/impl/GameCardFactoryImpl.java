package herbstJennrichLehmannRitter.engine.factory.impl;

import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Cards;
import herbstJennrichLehmannRitter.engine.model.SimpleCardAction;
import herbstJennrichLehmannRitter.engine.model.impl.CardImpl;
import herbstJennrichLehmannRitter.engine.model.impl.SimpleCardActionImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
			Cards xmlCards = (Cards)this.unmarshaller.unmarshal(is);
			is.close();
			
			if (xmlCards.getCards() == null || xmlCards.getCards().isEmpty())
				throw new EngineCouldNotStartException("the cards.xml provides no cards");
			
			// store all cards in a map to improve performance (getting a card from a HashMap is less expensive than from
			// a list even if the list is sorted
			this.cards = new HashMap<String, Card>(xmlCards.getCards().size(), 1);
			for (Card card : xmlCards.getCards()) {
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
		SimpleCardAction simpleCardAction = card.getSimpleCardAction();
		
		SimpleCardAction newSimpleCardAction = new SimpleCardActionImpl(
				simpleCardAction.getEnemyTowerEffect(),
				simpleCardAction.getOwnTowerEffect(), 
				simpleCardAction.getEnemyWallEffect(),
				simpleCardAction.getOwnWallEffect(),
				simpleCardAction.getEnemyMineLvlEffect(),
				simpleCardAction.getOwnMineLvlEffect(),
				simpleCardAction.getEnemyDungeonLvlEffect(),
				simpleCardAction.getOwnDungeonLvlEffect(),
				simpleCardAction.getEnemyMagicLabLvlEffect(),
				simpleCardAction.getOwnMagicLabLvlEffect(),
				simpleCardAction.getEnemyMonsterEffect(),
				simpleCardAction.getOwnMonsterEffect(),
				simpleCardAction.getEnemyCrystalEffect(),
				simpleCardAction.getOwnCrystalEffect(),
				simpleCardAction.getEnemyBrickEffect(),
				simpleCardAction.getOwnBrickEffect(),
				simpleCardAction.getAmountCardDraw(),
				simpleCardAction.getAmountCardDiscard(),
				simpleCardAction.getPlayCards(),
				simpleCardAction.getDamage());
		return new CardImpl(card.getName(), card.getCardType(), card.getCostBrick(), card.getCostMonsters(),
				card.getCostCrystal(), newSimpleCardAction, card.getComplexCardAction());
	}

	@Override
	public Collection<Card> createDefaultDeck() {
		Collection<Card> defaultDeck = new ArrayList<Card>();
		
		for (String cardName : this.cards.keySet()) {
			defaultDeck.add(createCard(cardName));
		}
		
		return defaultDeck;
	}

}
