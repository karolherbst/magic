package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Deck;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.DeckImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class DeckTests {

	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	
//	@Test
	public void testGetAllCards() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDiscardCard() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDiscardAllCards() {
		fail("Not yet implemented");
	}

//	@Test
	public void testDiscardAllCardsByType() {
		fail("Not yet implemented");
	}

//	@Test
	public void testPickCard() {
		fail("Not yet implemented");
	}

//	@Test
	public void testPickCards() {
		fail("Not yet implemented");
	}

//	@Test
	public void testPickNumberOfCardsWithType() {
		fail("Not yet implemented");
	}

	@Test
	public void testPickCardFromDeckStackOrCemeteryDeckWithCostAbout() {
		Collection<Card> cards = this.gameCardFactory.createDefaultDeck();
		Deck deck = new DeckImpl(cards);
		Player player = this.playerFactory.createPlayer("Player", deck, 0, 0, 0, 0);
		
		player.getDeck().discardAllCards();
		player.getDeck().pickCardFromDeckStackOrCemeteryDeckWithCostAbout(14);
		
		Card card = player.getDeck().getAllCards().iterator().next();
		if( card.getCostBrick() > 14) {
			assertTrue(card.getCostBrick() > 14);
		} else if (card.getCostCrystal() > 14) {
			assertTrue(card.getCostCrystal() > 14);
		} else if (card.getCostMonsters() > 14) {
			assertTrue(card.getCostMonsters() > 14);
		} else {
			assertFalse(true);
		}
	}

	@Test
	public void testExchangeCardsWithHandDeck() {
		Collection<Card> cardsPlayerOne = this.gameCardFactory.createDefaultDeck();
		Collection<Card> cardsPlayerTwo = this.gameCardFactory.createDefaultDeck();
		
		Deck deckPlayerOne = new DeckImpl(cardsPlayerOne);
		Deck deckPlayerTwo = new DeckImpl(cardsPlayerTwo);
		
		Player playerOne = this.playerFactory.createPlayer("Player One", deckPlayerOne, 0, 0, 0, 0);
		Player playerTwo = this.playerFactory.createPlayer("Player Two", deckPlayerTwo, 0, 0, 0, 0);
		
		List<Card> orginalCardsPlayerOne = new ArrayList<Card>(playerOne.getDeck().getAllCards());
		List<Card> orginalCardsPlayerTwo = new ArrayList<Card>(playerTwo.getDeck().getAllCards());
		
		playerOne.getDeck().exchangeCardsWithHandDeck(playerTwo.getDeck());
		
		List<Card> changedCardsPlayerOne = new ArrayList<Card>(playerOne.getDeck().getAllCards());
		List<Card> changedCardsPlayerTwo = new ArrayList<Card>(playerTwo.getDeck().getAllCards());

		assertEquals(orginalCardsPlayerOne, changedCardsPlayerTwo);
		assertEquals(orginalCardsPlayerTwo,  changedCardsPlayerOne);
	}
}
