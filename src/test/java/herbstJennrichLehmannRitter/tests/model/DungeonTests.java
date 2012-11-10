package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
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
		} catch (GameEngineException e) {
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
	public void testSetLevelAndRaiseLevel() {
		this.dungeon.setLevel(5);
		this.dungeon.addLevel(5);
		assertEquals(this.dungeon.getLevel(), 10);
	}
	
	@Test
	public void testSetLevelAndReduceLevel() {
		this.dungeon.setLevel(5);
		this.dungeon.reduceLevel(4);
		assertEquals(this.dungeon.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionHigherThanActualLevel() {
		this.dungeon.setLevel(5);
		this.dungeon.reduceLevel(6);
		assertEquals(this.dungeon.getLevel(), 1);
		
		//TODO Der Test hier wars
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
	
	@Test
	public void testSetStockAndReduceStockWithNeededStockLowerThanActualStock() {
		this.dungeon.setStock(20);
		this.dungeon.reduceStock(10);
		assertEquals(this.dungeon.getStock(), 10);
	}

	@Test
	public void testSetStockandReduceStockWithNeededStockHigherThanActualStock() {
		this.dungeon.setStock(15);
		this.dungeon.reduceStock(30);
		assertEquals(this.dungeon.getStock(), 0);
	}
	
	@Test
	public void testSetStockandReduceStockWithNeededStockEqualToActualStock(){
		this.dungeon.setStock(20);
		this.dungeon.reduceStock(20);
		assertEquals(this.dungeon.getStock(), 0);
	}
}
