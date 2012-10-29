package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DeckTests {

	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	private Collection<Card> cardsOnHand = new ArrayList<Card>();
	private Player globalPlayer = null;
	
	@Before
	public void before() {
		try {
			this.cardsOnHand.add(this.gameCardFactory.createCard("Architektur"));
			this.cardsOnHand.add(this.gameCardFactory.createCard("Auge des Koloss"));
			this.cardsOnHand.add(this.gameCardFactory.createCard("Diamant"));
			this.cardsOnHand.add(this.gameCardFactory.createCard("Drachenauge"));
			this.cardsOnHand.add(this.gameCardFactory.createCard("Oger"));
			this.cardsOnHand.add(this.gameCardFactory.createCard("Rinderwahnsinn"));
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testGetAllCards() {
		this.globalPlayer = this.playerFactory.createPlayer("Player", this.cardsOnHand,
				0, 0, 0, 0);
		
		assertTrue(this.cardsOnHand.containsAll(this.globalPlayer.getDeck().getAllCards()));
	}

	@Test
	public void testDiscardCard() {
		Collection<Card> cards = new ArrayList<Card>();
		Card cardOne = this.gameCardFactory.createCard("Architektur");
		
		cards.add(cardOne);
		cards.add(this.gameCardFactory.createCard("Auge des Koloss"));
		cards.add(this.gameCardFactory.createCard("Diamant"));
		cards.add(this.gameCardFactory.createCard("Drachenauge"));
		cards.add(this.gameCardFactory.createCard("Oger"));
		cards.add(this.gameCardFactory.createCard("Rinderwahnsinn"));

		Player player = this.playerFactory.createPlayer("Player", cards, 0, 0, 0, 0);
		
		player.getDeck().discardCard(cardOne);
		
		assertFalse(player.getDeck().getAllCards().containsAll(cards));
		assertEquals(5, player.getDeck().getAllCards().size());
	}

	@Test
	public void testDiscardAllCards() {
		this.globalPlayer = this.playerFactory.createPlayer("Player", this.cardsOnHand, 0, 0, 0, 0);
		
		this.globalPlayer.getDeck().discardAllCards();
		
		assertTrue(this.globalPlayer.getDeck().getAllCards().isEmpty());
		assertEquals(0, this.globalPlayer.getDeck().getAllCards().size());
	}

	@Test
	public void testDiscardAllCardsByType() {
		Collection<Card> cards = new ArrayList<Card>();
		Card cardArchitektur = this.gameCardFactory.createCard("Architektur");
		Card cardAugeDesKoloss = this.gameCardFactory.createCard("Auge des Koloss");
		Card cardDiamant = this.gameCardFactory.createCard("Diamant");
		Card cardDrachenauge = this.gameCardFactory.createCard("Drachenauge");
		Card cardOger = this.gameCardFactory.createCard("Oger");
		Card cardRinderwahnsinn = this.gameCardFactory.createCard("Rinderwahnsinn");
		
		cards.add(cardArchitektur);
		cards.add(cardAugeDesKoloss);
		cards.add(cardDiamant);
		cards.add(cardDrachenauge);
		cards.add(cardOger);
		cards.add(cardRinderwahnsinn);

		Player player = this.playerFactory.createPlayer("Player", cards, 0, 0, 0, 0);

		player.getDeck().discardAllCardsByType(CardType.CARD_TYPE_MAGIC_LAB);
		assertTrue(player.getDeck().getAllCards().contains(cardArchitektur));
		assertTrue(player.getDeck().getAllCards().contains(cardAugeDesKoloss));
		assertFalse(player.getDeck().getAllCards().contains(cardDiamant));
		assertFalse(player.getDeck().getAllCards().contains(cardDrachenauge));
		assertTrue(player.getDeck().getAllCards().contains(cardOger));
		assertTrue(player.getDeck().getAllCards().contains(cardRinderwahnsinn));
	}

	@Test
	public void testPickCard() {
		this.cardsOnHand.add(this.gameCardFactory.createCard("Schäfchen"));
		
		this.globalPlayer = this.playerFactory.createPlayer("Player", this.cardsOnHand, 0, 0, 0, 0);

		this.globalPlayer.getDeck().discardAllCards();
		
		assertTrue(this.globalPlayer.getDeck().pickCard());
		assertEquals(this.globalPlayer.getDeck().getAllCards().size(),1);
	}

	@Test
	public void testPickCardsWith3Cards() {
		this.cardsOnHand.add(this.gameCardFactory.createCard("Schäfchen"));
		this.cardsOnHand.add(this.gameCardFactory.createCard("Prisma"));
		this.cardsOnHand.add(this.gameCardFactory.createCard("Rauchquarz"));
		this.cardsOnHand.add(this.gameCardFactory.createCard("Zaubersprüche"));
		
		this.globalPlayer = this.playerFactory.createPlayer("Player", this.cardsOnHand, 0, 0, 0, 0);

		this.globalPlayer.getDeck().discardAllCards();
		
		assertTrue(this.globalPlayer.getDeck().pickCards(3));
		assertEquals(this.globalPlayer.getDeck().getAllCards().size(),3);
	}

	@Test
	public void testPickNumberOfCardsWithType() {
		Collection<Card> cards = new ArrayList<Card>();
		
		Card cardKaravane = this.gameCardFactory.createCard("Karavane");
		Card cardEisdrache = this.gameCardFactory.createCard("Eisdrache");
		Card cardVulkanausbruch = this.gameCardFactory.createCard("Vulkanausbruch");
		
		this.cardsOnHand.add(this.gameCardFactory.createCard("Schäfchen"));
		this.cardsOnHand.add(this.gameCardFactory.createCard("Prisma"));
		this.cardsOnHand.add(this.gameCardFactory.createCard("Rauchquarz"));
		this.cardsOnHand.add(cardKaravane);
		this.cardsOnHand.add(cardEisdrache);
		this.cardsOnHand.add(cardVulkanausbruch);
		
		cards.add(cardKaravane);
		cards.add(cardEisdrache);
		cards.add(cardVulkanausbruch);
		
		this.globalPlayer = this.playerFactory.createPlayer("Player", this.cardsOnHand, 0, 0, 0, 0);

		this.globalPlayer.getDeck().discardAllCards();
		
		assertTrue(this.globalPlayer.getDeck().pickNumberOfCardsWithType(3, CardType.CARD_TYPE_SPECIAL));
		assertEquals(this.globalPlayer.getDeck().getAllCards().size(), 3);
		assertTrue(this.globalPlayer.getDeck().getAllCards().containsAll(cards));
	}

	@Test
	public void testPickCardFromDeckStackOrCemeteryDeckWithCostAbout() {
		Collection<Card> cards = this.gameCardFactory.createDefaultDeck();
		Player player = this.playerFactory.createPlayer("Player", cards, 0, 0, 0, 0);
		
		player.getDeck().discardAllCards();
		assertTrue(player.getDeck().pickCardFromDeckStackOrCemeteryDeckWithCostAbout(14));
	}

	@Test
	public void testExchangeCardsWithHandDeck() {
		Collection<Card> cardsPlayerOne = this.gameCardFactory.createDefaultDeck();
		Collection<Card> cardsPlayerTwo = this.gameCardFactory.createDefaultDeck();
		
		Player playerOne = this.playerFactory.createPlayer("Player One", cardsPlayerOne, 0, 0, 0, 0);
		Player playerTwo = this.playerFactory.createPlayer("Player Two", cardsPlayerTwo, 0, 0, 0, 0);
		
		List<Card> orginalCardsPlayerOne = new ArrayList<Card>(playerOne.getDeck().getAllCards());
		List<Card> orginalCardsPlayerTwo = new ArrayList<Card>(playerTwo.getDeck().getAllCards());
		
		playerOne.getDeck().exchangeCardsWithHandDeck(playerTwo.getDeck());
		
		List<Card> changedCardsPlayerOne = new ArrayList<Card>(playerOne.getDeck().getAllCards());
		List<Card> changedCardsPlayerTwo = new ArrayList<Card>(playerTwo.getDeck().getAllCards());

		assertEquals(orginalCardsPlayerOne, changedCardsPlayerTwo);
		assertEquals(orginalCardsPlayerTwo,  changedCardsPlayerOne);
	}
}
