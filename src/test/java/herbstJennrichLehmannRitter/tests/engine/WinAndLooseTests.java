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
	private Player player;

	@Before
	public void setUp() throws Exception {
		this.player = this.playerFactory.createPlayer("Player", Globals.getGameCardFactory().createDefaultDeck(),
				0, 0, 0, 0);

	}

	@Test
	public void testHasPlayerLostWithPointsUnder0() {
		this.player.getTower().applyDamage(30);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player));
	}

	@Test
	public void testHasPlayerLostWithPointsEquals0() {
		this.player.getTower().applyDamage(25);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerLost(this.player));
	}
	
	@Test
	public void testHasPlayerWonWithTowerPointsEqual100() {
		this.player.getTower().addPoints(100);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player));
	}
	
	@Test
	public void testHasPlayerWonWithTowerPointsAbove100() {
		this.player.getTower().addPoints(105);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player));
	}	
	
	@Test
	public void testHasPlayerWonWithCrystalAbove400() {
		this.player.getMagicLab().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player));
	}
	
	@Test
	public void testHasPlayerWonWithBrickAbove400() {
		this.player.getMine().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player));
	}
	
	@Test
	public void testHasPlayerWonWithMonstersAbove400() {
		this.player.getDungeon().addStock(400);
		WinAndLoseChecker winAndLoseChecker = new WinAndLoseResourceRageChecker();
		assertTrue(winAndLoseChecker.hasPlayerWon(this.player));
	}
}
