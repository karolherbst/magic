package herbstJennrichLehmannRitter.tests.engine;

import static org.junit.Assert.assertFalse;
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
	private Player playerOne;
	private Player playerTwo;

	@Before
	public void setUp() {
		this.playerOne = this.playerFactory.createPlayer("Player1", Globals.getGameCardFactory().createDefaultDeck(),
				10, 10, 10, 10);
		this.playerTwo = this.playerFactory.createPlayer("Player2", Globals.getGameCardFactory().createDefaultDeck(),
				0, 0, 0, 0);
	}

	@Test
	public void testHasPlayerLostWithPointsUnder0() {
		this.playerOne.getTower().applyDamage(30);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerOne));
	}
	
	@Test
	public void testHasPlayerLostWithPointsEquals0() {
		this.playerOne.getTower().applyDamage(10);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerOne));
	}
	
	@Test
	public void testHasPlayerLostWithPointsAbove0() {
		this.playerOne.getTower().applyDamage(5);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertFalse(winAndLoseChecker.hasPlayerLost(this.playerOne));
	}
	
	@Test
	public void testHasPlayerWonWithTowerPointsEqual100() {
		this.playerOne.getTower().addPoints(90);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
	}
	
	@Test
	public void testHasPlayerWonWithTowerPointsAbove100() {
		this.playerOne.getTower().addPoints(95);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
	}
	
	@Test
	public void testHasPlayerWonWithTowerPointsUnder100() {
		this.playerOne.getTower().addPoints(5);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertFalse(winAndLoseChecker.hasPlayerWon(this.playerOne));
	}
	
	@Test
	public void testHasPlayerWonWithCrystalEquals400() {
		this.playerOne.getMagicLab().addStock(390);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerTwo));
	}
	
	@Test
	public void testHasPlayerWonWithBrickEquals400() {
		this.playerOne.getMine().addStock(390);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerTwo));
	}
	
	@Test
	public void testHasPlayerWonWithMonstersEquals400() {
		this.playerOne.getDungeon().addStock(390);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerTwo));
	}
	
	@Test
	public void testHasPlayerWonWithCrystalAbove400() {
		this.playerOne.getMagicLab().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerTwo));
	}
	
	@Test
	public void testHasPlayerWonWithBrickAbove400() {
		this.playerOne.getMine().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerTwo));
	}
	
	@Test
	public void testHasPlayerWonWithMonstersAbove400() {
		this.playerOne.getDungeon().addStock(444);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.playerOne));
		assertTrue(winAndLoseChecker.hasPlayerLost(this.playerTwo));
	}
}
