package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.MagicLabImpl;

import org.junit.Before;
import org.junit.Test;

public class MagicLabTests {

	private ResourceBuilding magicLab;
	
	@Before
	public void before() {
		this.magicLab = new MagicLabImpl();
	}
	
	@Test
	public void testName() {
		assertEquals(this.magicLab.getName(), "Zauberlabor");
	}
	
	@Test
	public void testLevel2() {
		this.magicLab.setLevel(2);
		assertEquals(this.magicLab.getLevel(), 2);
	}
	
	@Test
	public void testLevelSetAndAddLevelTo30() {
		this.magicLab.setLevel(25);
		this.magicLab.addLevel(5);
		assertEquals(this.magicLab.getLevel(), 30);
	}
	
	@Test
	public void testLevelSetAndAddNegativeLevelTo10() {
		this.magicLab.setLevel(15);
		this.magicLab.addLevel(-5);
		assertEquals(this.magicLab.getLevel(), 10);
	}
	
	@Test
	public void testLevelSetAndReduceLevelWithReductionLowerThanActualLevelTo10() {
		this.magicLab.setLevel(15);
		this.magicLab.reduceLevel(5);
		assertEquals(this.magicLab.getLevel(), 10);
	}
	
	@Test
	public void testLevelSetAndReduceNegativeLevelTo20() {
		this.magicLab.setLevel(15);
		this.magicLab.reduceLevel(-5);
		assertEquals(this.magicLab.getLevel(), 20);
	}
	
	@Test
	public void testSetLevelAndAddNegativeLevelWithReductionHigherThanActualLevelTo1() {
		this.magicLab.setLevel(10);
		this.magicLab.addLevel(-15);
		assertEquals(this.magicLab.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionHigherThanActualLevelTo1() {
		this.magicLab.setLevel(5);
		this.magicLab.reduceLevel(6);
		assertEquals(this.magicLab.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndAddNegativeLevelWithReductionEqualToActualLevelTo1() {
		this.magicLab.setLevel(10);
		this.magicLab.addLevel(-10);
		assertEquals(this.magicLab.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionEqualToActualLevelTo1() {
		this.magicLab.setLevel(5);
		this.magicLab.reduceLevel(5);
		assertEquals(this.magicLab.getLevel(), 1);
	}
	
	
	@Test
	public void testStock8() {
		this.magicLab.setStock(8);
		assertEquals(this.magicLab.getStock(), 8);
	}
	
	@Test
	public void testStock25() {
		this.magicLab.setStock(25);
		assertEquals(this.magicLab.getStock(), 25);
	}
	
	@Test
	public void testStockSetAndAddStockTo25() {
		this.magicLab.setStock(10);
		this.magicLab.addStock(15);
		assertEquals(this.magicLab.getStock(), 25);
	}

	@Test
	public void testStockSetAndAddNegativeStockTo5() {
		this.magicLab.setStock(10);
		this.magicLab.addStock(-5);
		assertEquals(this.magicLab.getStock(), 5);
	}
	
	@Test
	public void testSetStockAndReduceStockWithReductionLowerThanActualStockTo10() {
		this.magicLab.setStock(20);
		this.magicLab.reduceStock(10);
		assertEquals(this.magicLab.getStock(), 10);
	}
	
	@Test
	public void testAddNegativeStockWithReductionHigherThanActualStockTo0() {
		this.magicLab.setStock(10);
		this.magicLab.addStock(-15);
		assertEquals(this.magicLab.getStock(), 0);
	}

	@Test
	public void testSetStockandReduceStockWithReductionHigherThanActualStockTo0() {
		this.magicLab.setStock(15);
		this.magicLab.reduceStock(30);
		assertEquals(this.magicLab.getStock(), 0);
	}
	
	@Test
	public void testAddNegativeStockWithReductionEqualToActualStockTo0() {
		this.magicLab.setStock(10);
		this.magicLab.addStock(-10);
		assertEquals(this.magicLab.getStock(), 0);
	}
	
	@Test
	public void testSetStockandReduceStockWithReductionEqualToActualStockTo0(){
		this.magicLab.setStock(20);
		this.magicLab.reduceStock(20);
		assertEquals(this.magicLab.getStock(), 0);
	}
}
