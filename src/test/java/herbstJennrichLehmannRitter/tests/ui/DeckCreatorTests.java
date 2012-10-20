package herbstJennrichLehmannRitter.tests.ui;

import static org.junit.Assert.*;

import java.util.ArrayList;

import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.impl.DeckCreatorImpl;

import org.junit.Before;
import org.junit.Test;

public class DeckCreatorTests {
	
	private GameCardFactory gameCardFactory;
	
	@Before
	public void before() {
		try {
			this.gameCardFactory = new GameCardFactoryImpl();
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
	}
	@Test
	public void testDeckExists() {
		this.gameCardFactory.createCard("Architektur");
		assertNotNull(gameCardFactory);
	}
	
	@Test
	public void testCardsInDeckAreSame() {
		Card card = this.gameCardFactory.createCard("Architektur");
		
		DeckCreatorImpl deckCreator =  new DeckCreatorImpl();
		deckCreator.addCard(card);
		ArrayList<Card> deckCreatorArray = (ArrayList<Card>) deckCreator.getCards();		
		
		ArrayList<Card> cardArray = new ArrayList<Card>();
		cardArray.add(card);

		assertEquals(deckCreatorArray, cardArray);		
	}
	
	@Test
	public void testFirstCardInDeck() {
		Card card = this.gameCardFactory.createCard("Architektur");
		
		DeckCreatorImpl deckCreator = new DeckCreatorImpl();
		deckCreator.addCard(card);
		Card firstCard = deckCreator.getCards().iterator().next();
		
		assertEquals(firstCard.getName(),"Architektur");
	}
}
