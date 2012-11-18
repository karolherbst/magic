package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.MineImpl;

import org.junit.Before;
import org.junit.Test;

/** Description of MineTests Class
 *  This class tests the mine level, stock and all methods.
 */

public class MineTests {

	private ResourceBuilding mine;
	
	@Before
	public void before() {
		this.mine = new MineImpl();
	}
	
	@Test
	public void testName() {
		assertEquals(this.mine.getName(), "Steinbruch");
	}
	
	@Test
	public void testLevel2() {
		this.mine.setLevel(2);
		assertEquals(this.mine.getLevel(), 2);
	}
	
	@Test
	public void testLevelSetAndAddLevelTo30() {
		this.mine.setLevel(25);
		this.mine.addLevel(5);
		assertEquals(this.mine.getLevel(), 30);
	}
	
	@Test
	public void testLevelSetAndAddNegativeLevelTo10() {
		this.mine.setLevel(15);
		this.mine.addLevel(-5);
		assertEquals(this.mine.getLevel(), 10);
	}
	
	@Test
	public void testLevelSetAndReduceLevelWithReductionLowerThanActualLevelTo10() {
		this.mine.setLevel(15);
		this.mine.reduceLevel(5);
		assertEquals(this.mine.getLevel(), 10);
	}
	
	@Test
	public void testLevelSetAndReduceNegativeLevelTo20() {
		this.mine.setLevel(15);
		this.mine.reduceLevel(-5);
		assertEquals(this.mine.getLevel(), 20);
	}
	
	@Test
	public void testSetLevelAndAddNegativeLevelWithReductionHigherThanActualLevelTo1() {
		this.mine.setLevel(10);
		this.mine.addLevel(-15);
		assertEquals(this.mine.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionHigherThanActualLevelTo1() {
		this.mine.setLevel(5);
		this.mine.reduceLevel(6);
		assertEquals(this.mine.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndAddNegativeLevelWithReductionEqualToActualLevelTo1() {
		this.mine.setLevel(10);
		this.mine.addLevel(-10);
		assertEquals(this.mine.getLevel(), 1);
	}
	
	@Test
	public void testSetLevelAndReduceLevelWithReductionEqualToActualLevelTo1() {
		this.mine.setLevel(5);
		this.mine.reduceLevel(5);
		assertEquals(this.mine.getLevel(), 1);
	}
	
	
	@Test
	public void testStock8() {
		this.mine.setStock(8);
		assertEquals(this.mine.getStock(), 8);
	}
	
	@Test
	public void testStock25() {
		this.mine.setStock(25);
		assertEquals(this.mine.getStock(), 25);
	}
	
	@Test
	public void testStockSetAndAddStockTo25() {
		this.mine.setStock(10);
		this.mine.addStock(15);
		assertEquals(this.mine.getStock(), 25);
	}

	@Test
	public void testStockSetAndAddNegativeStockTo5() {
		this.mine.setStock(10);
		this.mine.addStock(-5);
		assertEquals(this.mine.getStock(), 5);
	}
	
	@Test
	public void testSetStockAndReduceStockWithReductionLowerThanActualStockTo10() {
		this.mine.setStock(20);
		this.mine.reduceStock(10);
		assertEquals(this.mine.getStock(), 10);
	}
	
	@Test
	public void testAddNegativeStockWithReductionHigherThanActualStockTo0() {
		this.mine.setStock(10);
		this.mine.addStock(-15);
		assertEquals(this.mine.getStock(), 0);
	}

	@Test
	public void testSetStockandReduceStockWithReductionHigherThanActualStockTo0() {
		this.mine.setStock(15);
		this.mine.reduceStock(30);
		assertEquals(this.mine.getStock(), 0);
	}
	
	@Test
	public void testAddNegativeStockWithReductionEqualToActualStockTo0() {
		this.mine.setStock(10);
		this.mine.addStock(-10);
		assertEquals(this.mine.getStock(), 0);
	}
	
	@Test
	public void testSetStockandReduceStockWithReductionEqualToActualStockTo0(){
		this.mine.setStock(20);
		this.mine.reduceStock(20);
		assertEquals(this.mine.getStock(), 0);
	}
}
