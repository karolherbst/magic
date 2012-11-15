package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;
import org.junit.Before;
import org.junit.Test;

public class ComplexCardTests {
	
	private GameCardFactory gameCardFactory;
	
	@Before
	public void before() {
		this.gameCardFactory = new GameCardFactoryImpl();
	}

	@Test
	public void testAuferstehung() {
		Card auferstehung = this.gameCardFactory.createCard("Auferstehung");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		
		auferstehung.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(32, player1.getTower().getActualPoints());
	}
	
	@Test
	public void testBarracke() {
		Card barracke = this.gameCardFactory.createCard("Barracke");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		player1.getDungeon().addLevel(0);
		player2.getDungeon().addLevel(3);
		
		barracke.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(2, player1.getDungeon().getLevel());
	}
	
	@Test
	public void testBaumgeist() {
		Card baumgeist = this.gameCardFactory.createCard("Baumgeist");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		player1.getDungeon().setLevel(20);
		player2.getWall().setActualPoints(15);
		
		baumgeist.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(14, player2.getTower().getActualPoints());
	}
	
	@Test
	public void testBlitzUndDonner() {
		Card blitzUndDonner = this.gameCardFactory.createCard("Blitz und Donner");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		player1.getTower().setActualPoints(15);
		player2.getTower().setActualPoints(10);
		
		blitzUndDonner.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(2, player2.getTower().getActualPoints());
	}
	
	@Test
	public void testBlitzUndDonnerTwo() {
		Card blitzUndDonnerTwo = this.gameCardFactory.createCard("Blitz und Donner");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		player1.getTower().setActualPoints(10);
		player2.getTower().setActualPoints(10);
		player2.getWall().setActualPoints(10);
		
		blitzUndDonnerTwo.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(2, player2.getWall().getActualPoints());
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
}
