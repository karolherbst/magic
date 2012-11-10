package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Deck;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.DeckImpl;
import herbstJennrichLehmannRitter.engine.model.impl.DungeonImpl;
import herbstJennrichLehmannRitter.engine.model.impl.MagicLabImpl;
import herbstJennrichLehmannRitter.engine.model.impl.MineImpl;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;
import herbstJennrichLehmannRitter.engine.model.impl.TowerImpl;
import herbstJennrichLehmannRitter.engine.model.impl.WallImpl;

import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
	
	private PlayerImpl player;
	
	@Before
	public void before() {
		try {
			this.player = new PlayerImpl();
		} catch (GameEngineException e) {
			fail(e.getLocalizedMessage());
		}
	}
	@Test
	public void testName() {
		this.player.setName("Player One");
		assertEquals(this.player.getName(),"Player One");
	}

	@Test
	public void testDeck() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Deck deck = new DeckImpl(gameCardFactory.createDefaultDeck());
		
		this.player.setDeck(deck);
		assertEquals(deck, this.player.getDeck());
	}

	@Test
	public void testDungeon() {
		ResourceBuilding dungeon = new DungeonImpl();
		this.player.setDungeon(dungeon);
		
		assertEquals(dungeon, this.player.getDungeon());
	}

	@Test
	public void testMagicLab() {
		ResourceBuilding magicLab = new MagicLabImpl();
		this.player.setMagiclab(magicLab);
		
		assertEquals(magicLab, this.player.getMagicLab());
	}

	@Test
	public void testMine() {
		ResourceBuilding mine = new MineImpl();
		this.player.setMine(mine);
		
		assertEquals(mine, this.player.getMine());

	}

	@Test
	public void testTower() {
		DefenceBuilding tower = new TowerImpl();
		this.player.setTower(tower);
		
		assertEquals(tower, this.player.getTower());
	}

	@Test
	public void testWall() {
		DefenceBuilding wall = new WallImpl();
		this.player.setWall(wall);
		
		assertEquals(wall, this.player.getWall());
	}
}
