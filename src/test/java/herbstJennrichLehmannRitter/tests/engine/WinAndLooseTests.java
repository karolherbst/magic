package herbstJennrichLehmannRitter.tests.engine;

import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.controller.WinAndLoseChecker;
import herbstJennrichLehmannRitter.engine.controller.impl.WinAndLoseResourceRageChecker;
import herbstJennrichLehmannRitter.engine.controller.impl.WinAndLoseTowerBuildingChecker;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Player;

import org.junit.Before;
import org.junit.Test;

public class WinAndLooseTests {
	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	private Player player1;
	private Player player2;

	@Before
	public void setUp() {

		this.player1 = this.playerFactory.createPlayer("Player1", Globals.getGameCardFactory().createDefaultDeck(),
				0, 0, 0, 0);
		this.player2 = this.playerFactory.createPlayer("Player2", Globals.getGameCardFactory().createDefaultDeck(),
				0, 0, 0, 0);

	}

	@Test
	public void testHasPlayer1LostWithPointsUnder0() {
		this.player1.getTower().applyDamage(30);
		this.player2.getTower().addPoints(10);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer2LostWithPointsUnder0() {
		this.player2.getTower().applyDamage(30);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}

	@Test
	public void testHasPlayer1LostWithPointsEquals0() {
		this.player1.getTower().applyDamage(25);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer2LostWithPointsEquals0() {
		this.player2.getTower().applyDamage(25);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer1LostWithPointsAbove0() {
		this.player1.getTower().applyDamage(20);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer2LostWithPointsAbove0() {
		this.player2.getTower().applyDamage(20);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer1WonWithTowerPointsEqual100() {
		this.player1.getTower().addPoints(100);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithTowerPointsEqual100() {
		this.player2.getTower().addPoints(100);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithTowerPointsAbove100() {
		this.player1.getTower().addPoints(105);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithTowerPointsAbove100() {
		this.player2.getTower().addPoints(105);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithCrystalEquals400() {
		this.player1.getMagicLab().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithCrystalEquals400() {
		this.player2.getMagicLab().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithBrickEquals400() {
		this.player1.getMine().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithBrickEquals400() {
		this.player2.getMine().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithMonstersEquals400() {
		this.player1.getDungeon().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithMonstersEquals400() {
		this.player2.getDungeon().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithCrystalAbove400() {
		this.player1.getMagicLab().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithCrystalAbove400() {
		this.player2.getMagicLab().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithBrickAbove400() {
		this.player1.getMine().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithBrickAbove400() {
		this.player2.getMine().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	@Test
	public void testHasPlayer1WonWithMonstersAbove400() {
		this.player1.getDungeon().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player1));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player2));
	}
	
	@Test
	public void testHasPlayer2WonWithMonstersAbove400() {
		this.player2.getDungeon().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player2));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player1));
	}
	
	
}
