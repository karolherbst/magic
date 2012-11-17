package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ComplexCardTests {
	
	private GameCardFactory gameCardFactory;
	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	
	@Before
	public void before() {
		this.gameCardFactory = new GameCardFactoryImpl();
	}

	@Test
	public void testAuferstehung() {
		Card auferstehung = this.gameCardFactory.createCard("Auferstehung");
		Player player1 = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				25, 10, 1, 15);
		Player player2 = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				25, 10, 1, 15);
		
		auferstehung.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(32, player1.getTower().getActualPoints());
	}
	
	@Test
	public void testBarracke() {
		Card barracke = this.gameCardFactory.createCard("Barracke");
		Player player1 = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				5, 5, 4, 5);
		Player player2 = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		
		barracke.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(5, player1.getDungeon().getLevel());
	}
	
	@Test
	public void testBaumgeist() {
		Card baumgeist = this.gameCardFactory.createCard("Baumgeist");
		Player player1 = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				25, 10, 6, 20);
		Player player2 = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				25, 5, 5, 20);
		
		baumgeist.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(14, player2.getTower().getActualPoints());
	}
	
	@Test
	public void testBlitzUndDonner() {
		Card blitzUndDonner = this.gameCardFactory.createCard("Blitz und Donner");
		Player player1 = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		Player player2 = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		player1.getTower().setActualPoints(15);
		player2.getTower().setActualPoints(10);
		
		blitzUndDonner.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(2, player2.getTower().getActualPoints());
	}
	
	@Test
	public void testBlitzUndDonnerTwo() {
		Card blitzUndDonnerTwo = this.gameCardFactory.createCard("Blitz und Donner");
		Player player1 = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		Player player2 = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		player1.getTower().setActualPoints(10);
		player2.getTower().setActualPoints(10);
		player2.getWall().setActualPoints(10);
		
		blitzUndDonnerTwo.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(2, player2.getWall().getActualPoints());
	}
	
	@Test
	public void testBlutmond() {
		Card blutmond = this.gameCardFactory.createCard("Blutmond");
		Player player1 = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		Player player2 = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		
		blutmond.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		Collection<Card> newCards = player1.getDeck().getAllCards();
		for (Card card : newCards) {
			assertEquals(card.getCardType(), CardType.DUNGEON);
		}
	}
	
	@Test
	public void testDemolieren() {
		Card demolieren = this.gameCardFactory.createCard("Demolieren");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		
		demolieren.getComplexCardAction().applyActionOnPlayer(playerTwo, playerOne);
		assertEquals(0, playerOne.getWall().getActualPoints());
		assertEquals(5, playerTwo.getWall().getActualPoints());
	}
	
	@Test
	public void testDieb() {
		Card dieb = this.gameCardFactory.createCard("Dieb");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		
		dieb.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(20, player1.getMagicLab().getStock());
		assertEquals(18, player1.getMine().getStock());
		assertEquals(5, player2.getMagicLab().getStock());
		assertEquals(10, player2.getMine().getStock());
	}
	
	@Test
	public void testDiebTwo() {
		Card diebTwo = this.gameCardFactory.createCard("Dieb");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		player2.getMagicLab().setStock(8);
		player2.getMine().setStock(4);
		
		diebTwo.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(19, player1.getMagicLab().getStock());
		assertEquals(17, player1.getMine().getStock());
		assertEquals(0, player2.getMagicLab().getStock());
		assertEquals(0, player2.getMine().getStock());
	}
	
	@Test
	public void testEinhornOne() {
		Card einhornOne = this.gameCardFactory.createCard("Einhorn");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				14, 14, 14, 14);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		einhornOne.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(0, playerTwo.getWall().getActualPoints());		
	}
	@Test
	public void testEinhornTwo() {
		Card einhornTwo = this.gameCardFactory.createCard("Einhorn");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				10, 10, 10, 10);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		einhornTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(4, playerTwo.getWall().getActualPoints());		
	}
	
	@Test
	public void testElfischeBogenschuetzen() {
		Card elfischeBogenschuetzen = this.gameCardFactory.createCard("Elfische Bogenschützen");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				10, 14, 10, 10);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		elfischeBogenschuetzen.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(6, playerTwo.getTower().getActualPoints());	
	}
	
	@Test
	public void testElfischeBogenschuetzenTwo() {
		Card elfischeBogenschuetzenTwo = this.gameCardFactory.createCard("Elfische Bogenschützen");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				10, 10, 10, 10);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		elfischeBogenschuetzenTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(6, playerTwo.getWall().getActualPoints());	
	}
	
	@Test
	public void testGlasperlen() {
		Card glasperlen = this.gameCardFactory.createCard("Glasperlen");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				10, 10, 10, 10);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		glasperlen.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(12, playerOne.getTower().getActualPoints());	
	}
	
	@Test
	public void testGlasperlenTwo() {
		Card glasperlenTwo = this.gameCardFactory.createCard("Glasperlen");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		glasperlenTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(14, playerOne.getTower().getActualPoints());	
	}
	
	@Test
	public void testGrundstein() {
		Card grundstein = this.gameCardFactory.createCard("Grundstein");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 0, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		grundstein.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(6, playerOne.getWall().getActualPoints());	
	}
	
	@Test
	public void testGrundsteinTwo() {
		Card grundsteinTwo = this.gameCardFactory.createCard("Grundstein");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		grundsteinTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(16, playerOne.getWall().getActualPoints());	
	}
	
	@Test
	public void testHauptader() {
		Card hauptader = this.gameCardFactory.createCard("Hauptader");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 1, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		hauptader.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(3, playerOne.getMine().getLevel());	
	}
	
	@Test
	public void testHauptaderTwo() {
		Card hauptaderTwo = this.gameCardFactory.createCard("Hauptader");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		hauptaderTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(14, playerOne.getMine().getLevel());	
	}
	
	@Test
	public void testParadoxon() {
		Card paradoxon = this.gameCardFactory.createCard("Paradoxon");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 1, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				2, 2, 2, 2);
		Collection<Card> playerOneCardsOld = playerOne.getDeck().getAllCards();
		Collection<Card> playerTwoCardsOld = playerTwo.getDeck().getAllCards();
		paradoxon.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		Collection<Card> playerOneCardsNew = playerOne.getDeck().getAllCards();
		Collection<Card> playerTwoCardsNew = playerTwo.getDeck().getAllCards();
		List<Card> playerOneOldlist = new ArrayList<Card>(playerOneCardsOld);
		List<Card> playerTwoOldlist = new ArrayList<Card>(playerTwoCardsOld);
		assertTrue(playerOneOldlist.containsAll(playerTwoCardsNew));
		assertTrue(playerTwoOldlist.containsAll(playerOneCardsNew));
	}
	
	@Test
	public void testParitaet() {
		Card paritaet = this.gameCardFactory.createCard("Parität");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 1, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		paritaet.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(12, playerOne.getMagicLab().getLevel());	
	}
	
	@Test
	public void testParitaetTwo() {
		Card paritaetTwo = this.gameCardFactory.createCard("Parität");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 9, 12);
		paritaetTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(13, playerTwo.getMagicLab().getLevel());	
	}
	
	@Test

	public void testPfuschenderSchmied() {
		Card pfuschenderSchmied = this.gameCardFactory.createCard("Pfuschender Schmied");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				11, 11, 11, 11);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		
		pfuschenderSchmied.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		Collection<Card> handCards = playerTwo.getDeck().getAllCards();
		for (Card card : handCards) {
			if (card.getCardType() ==  CardType.MAGIC_LAB){
				assertEquals(card.getCardType(), CardType.MAGIC_LAB);
			}
			if (card.getCardType() ==  CardType.DUNGEON){
				assertEquals(card.getCardType(), CardType.DUNGEON);
			}
		}
	}

	@Test
	public void testPureMagie() {
		Card pureMagie = this.gameCardFactory.createCard("Pure Magie");
		Player playerOne = this.playerFactory.createPlayer("1", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		Player playerTwo = this.playerFactory.createPlayer("2", this.gameCardFactory.createDefaultDeck(),
				5, 5, 5, 5);
		
		pureMagie.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		
		Collection<Card> newCards = playerOne.getDeck().getAllCards();
		for (Card card : newCards) {
			assertEquals(card.getCardType(), CardType.MAGIC_LAB);
		}
	}
	
	@Test
	public void testSpeertraeger() {
		Card speertraeger = this.gameCardFactory.createCard("Speerträger");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				20, 10, 12, 12);
		speertraeger.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(7, playerTwo.getWall().getActualPoints());
	}
	
	@Test
	public void testSpeertraegerTwo() {
		Card speertraegerTwo = this.gameCardFactory.createCard("Speerträger");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				20, 14, 9, 12);
		speertraegerTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(12, playerTwo.getWall().getActualPoints());	
	}
	
	@Test
	public void testSpeikaefer() {
		Card speikaefer = this.gameCardFactory.createCard("Speikäfer");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 1, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				20, 0, 12, 12);
		speikaefer.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(10, playerTwo.getTower().getActualPoints());
	}
	
	@Test
	public void testSpeikaeferTwo() {
		Card speikaeferTwo = this.gameCardFactory.createCard("Speikäfer");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 9, 12);
		speikaeferTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(6, playerTwo.getWall().getActualPoints());	
	}
	
	@Test
	public void testSpionage() {
		Card spionage = this.gameCardFactory.createCard("Spionage");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 1, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		spionage.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(12, playerOne.getMine().getLevel());	
	}
	
	@Test
	public void testSpionageTwo() {
		Card spionageTwo = this.gameCardFactory.createCard("Spionage");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 9, 12);
		spionageTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(13, playerOne.getMine().getLevel());	
	}
	
	@Test
	public void testUeberflutung() {
		Card ueberflutung = this.gameCardFactory.createCard("Überflutung");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				10, 10, 10, 10);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		ueberflutung.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(9, playerOne.getDungeon().getLevel());
		assertEquals(8, playerOne.getTower().getActualPoints());
	}
	
	@Test
	public void testUeberflutungTwo() {
		Card ueberflutungTwo = this.gameCardFactory.createCard("Überflutung");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 9, 12);
		ueberflutungTwo.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(8, playerTwo.getDungeon().getLevel());
		assertEquals(10, playerTwo.getTower().getActualPoints());
	}
	
	@Test
	public void testUeberflutungThree() {
		Card ueberflutungThree = this.gameCardFactory.createCard("Überflutung");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				13, 13, 13, 13);
		ueberflutungThree.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(13, playerOne.getDungeon().getLevel());
		assertEquals(13, playerOne.getTower().getActualPoints());
		assertEquals(13, playerTwo.getDungeon().getLevel());
		assertEquals(13, playerTwo.getTower().getActualPoints());
	}
	
	@Test
	public void testVerschiebung() {
		Card verschiebung = this.gameCardFactory.createCard("Verschiebung");
		Player playerOne = this.playerFactory.createPlayer("Spieler 1", this.gameCardFactory.createDefaultDeck(),
				1, 1, 1, 1);
		Player playerTwo = this.playerFactory.createPlayer("Spieler 2", this.gameCardFactory.createDefaultDeck(),
				12, 12, 12, 12);
		verschiebung.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		assertEquals(12, playerOne.getWall().getActualPoints());
		assertEquals(1, playerTwo.getWall().getActualPoints());
	}
	
	@Test
	public void testWeihnachtsmann() {
		Card weihnachtsmann = this.gameCardFactory.createCard("Weihnachtsmann");
		
		Collection<Card> cards = new ArrayList<Card>();
		cards.add(this.gameCardFactory.createCard("Architektur"));
		cards.add(this.gameCardFactory.createCard("Barracke"));
		cards.add(this.gameCardFactory.createCard("Kristallsteine"));
		cards.add(this.gameCardFactory.createCard("Feuerrubin"));
		cards.add(this.gameCardFactory.createCard("Lavajuwel"));
		cards.add(this.gameCardFactory.createCard("Prisma"));
		cards.add(this.gameCardFactory.createCard("Drache"));
		cards.add(this.gameCardFactory.createCard("Ork"));
		cards.add(this.gameCardFactory.createCard("Pfuschender Schmied"));
		cards.add(weihnachtsmann);
		
		Player playerOne = this.playerFactory.createPlayer("Spieler", cards, 1, 1, 1, 1);
		Player playerTwo = new PlayerImpl();
		
		do {
			playerOne.getDeck().discardAllCards();
			playerOne.getDeck().pickCard();
			if (playerOne.getDeck().getAllCards().contains(weihnachtsmann)) {
				break;
			}
		} while (true);
		
		weihnachtsmann.getComplexCardAction().applyActionOnPlayer(playerOne, playerTwo);
		playerOne.getDeck().discardCard(weihnachtsmann);
		assertEquals(playerOne.getDeck().getHandDeckSize(), 1);
		
		List<Card> listOfCards = new ArrayList<Card>(playerOne.getDeck().getAllCards());
		Card handCard = listOfCards.get(0);
		int sumOfCosts = handCard.getCostBrick() + handCard.getCostCrystal() + handCard.getCostMonsters();
		assertTrue(sumOfCosts > 14);
	}
	
	
}
