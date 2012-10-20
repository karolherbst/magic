package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.DungeonImpl;
import org.junit.Before;
import org.junit.Test;

public class DungeonTests {

	private ResourceBuilding dungeon;
	
	@Before
	public void before() {
		try {
			this.dungeon = new DungeonImpl();
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testName() {
		assertEquals(this.dungeon.getName(), "Verlies");
	}
	
	@Test
	public void testLevel2() {
		this.dungeon.setLevel(2);
		assertEquals(this.dungeon.getLevel(), 2);
	}
	
	@Test
	public void testLevel30() {
		this.dungeon.setLevel(30);
		assertEquals(this.dungeon.getLevel(), 30);
	}
	
	@Test
	public void testStock8() {
		this.dungeon.setStock(8);
		assertEquals(this.dungeon.getStock(), 8);
	}

	@Test
	public void testStock25() {
		this.dungeon.setStock(25);
		assertEquals(this.dungeon.getStock(), 25);
	}
}
