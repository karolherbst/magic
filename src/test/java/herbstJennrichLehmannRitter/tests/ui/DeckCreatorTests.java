package herbstJennrichLehmannRitter.tests.ui;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
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
		assertNotNull(this.gameCardFactory);
	}
	
	@Test
	public void testAddCardToDeck() {
		Card card = this.gameCardFactory.createCard("Architektur");
		
		DeckCreatorImpl deckCreator =  new DeckCreatorImpl();
		deckCreator.addCard(card);
		ArrayList<Card> deckArray = (ArrayList<Card>) deckCreator.getCards();		
		
		ArrayList<Card> localArray = new ArrayList<Card>();
		localArray.add(card);

		assertEquals(deckArray, localArray);		
	}
	
	@Test
	public void testAddCardsToDeck() {
		Card firstCard = this.gameCardFactory.createCard("Architektur");
		// TODO Add a second Card and edit the Name here to make this test green
		Card secondCard = new GameCardFactoryImpl().createCard("Karte");
		
		Collection<Card> cardArray = new ArrayList<Card>();
		cardArray.add(firstCard);
		cardArray.add(secondCard);
		
		ArrayList<Card> localArray = new ArrayList<Card>();
		localArray.add(firstCard);
		localArray.add(secondCard);
		
		DeckCreatorImpl deckCreator = new DeckCreatorImpl();
		deckCreator.addCards(cardArray);
		ArrayList<Card> deckArray = (ArrayList<Card>) deckCreator.getCards();		
		
		assertFalse(deckCreator.getCards().isEmpty());
		assertEquals(deckArray, localArray);
	}
	
	@Test
	public void testRemoveCardFromDeck() {
		Card card = this.gameCardFactory.createCard("Architektur");
		
		DeckCreatorImpl deckCreator = new DeckCreatorImpl();
		deckCreator.addCard(card);
		deckCreator.removeCard(card);
		
		assertTrue(deckCreator.getCards().isEmpty());
	}
	
	@Test
	public void testRemoveCardsFromDeck() {
		Card firstCard = this.gameCardFactory.createCard("Architektur");
		// TODO Add a second Card and edit the Name here to make this test green
		Card secondCard = new GameCardFactoryImpl().createCard("Karte");
		
		Collection<Card> cardArray = new ArrayList<Card>();
		cardArray.add(firstCard);
		cardArray.add(secondCard);
		
		DeckCreatorImpl deckCreator = new DeckCreatorImpl();
		deckCreator.addCards(cardArray);
		deckCreator.removeCards(cardArray);
		
		assertTrue(deckCreator.getCards().isEmpty());
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
