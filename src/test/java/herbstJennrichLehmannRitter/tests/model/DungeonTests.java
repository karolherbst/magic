package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.DungeonImpl;

import org.junit.Before;
import org.junit.Test;

public class DungeonTests {

	private ResourceBuilding dungeon;
	
	@Before
	public void before() {
		this.dungeon = new DungeonImpl();
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
	public void testSetLevelAndAddLevelTo30() {
		this.dungeon.setLevel(25);
		this.dungeon.addLevel(5);
		assertEquals(this.dungeon.getLevel(), 30);
	}
		
	@Test
	public void testSetLevelAndAddNegativeLevelTo5() {
		this.dungeon.setLevel(10);
		this.dungeon.addLevel(-5);
		assertEquals(this.dungeon.getLevel(), 5);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionLowerThanActualLevelTo5() {
		this.dungeon.setLevel(10);
		this.dungeon.reduceLevel(5);
		assertEquals(this.dungeon.getLevel(), 5);
	}
	
	@Test
	public void testSetLevelAndReduceNegativeLevelTo20() {
		this.dungeon.setLevel(5);
		this.dungeon.reduceLevel(-15);
		assertEquals(this.dungeon.getLevel(), 20);
	}
	
	@Test
	public void testSetLevelAndAddNegativeLevelWithReductionHigherThanActualLevelTo1() {
		this.dungeon.setLevel(10);
		this.dungeon.addLevel(-15);
		assertEquals(this.dungeon.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionHigherThanActualLevelTo1() {
		this.dungeon.setLevel(5);
		this.dungeon.reduceLevel(6);
		assertEquals(this.dungeon.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndAddNegativeLevelWithReductionEqualToActualLevelTo1() {
		this.dungeon.setLevel(10);
		this.dungeon.addLevel(-10);
		assertEquals(this.dungeon.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionEqualToActualLevelTo1() {
		this.dungeon.setLevel(5);
		this.dungeon.reduceLevel(5);
		assertEquals(this.dungeon.getLevel(), 1);
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
	public void testAddStockTo10() {
		this.dungeon.setStock(5);
		this.dungeon.addStock(5);
		assertEquals(this.dungeon.getStock(), 10);
	}
	
	@Test
	public void testAddNegativeStockTo5() {
		this.dungeon.setStock(10);
		this.dungeon.addStock(-5);
		assertEquals(this.dungeon.getStock(), 5);
	}
	
	@Test
	public void testSetStockAndReduceStockWithReductionLowerThanActualStockTo10() {
		this.dungeon.setStock(20);
		this.dungeon.reduceStock(10);
		assertEquals(this.dungeon.getStock(), 10);
	}
	
	@Test
	public void testAddNegativeStockWithReductionHigherThanActualStockTo0() {
		this.dungeon.setStock(10);
		this.dungeon.addStock(-15);
		assertEquals(this.dungeon.getStock(), 0);
	}

	@Test
	public void testSetStockandReduceStockWithReductionHigherThanActualStockTo0() {
		this.dungeon.setStock(15);
		this.dungeon.reduceStock(30);
		assertEquals(this.dungeon.getStock(), 0);
	}
	
	@Test
	public void testAddNegativeStockWithReductionEqualToActualStockTo0() {
		this.dungeon.setStock(10);
		this.dungeon.addStock(-10);
		assertEquals(this.dungeon.getStock(), 0);
	}
	
	@Test
	public void testSetStockandReduceStockWithReductionEqualToActualStockTo0(){
		this.dungeon.setStock(20);
		this.dungeon.reduceStock(20);
		assertEquals(this.dungeon.getStock(), 0);
	}
}
