package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.enums.BuildingType;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.TowerImpl;

import org.junit.Before;
import org.junit.Test;

/** Description of TowerTests Class
 *  This class tests the tower level and all methods.
 */

public class TowerTests {

	private DefenceBuilding tower;
	
	@Before
	public void before() {
		this.tower = new TowerImpl();
	}
	
	@Test
	public void testName() {
		assertEquals(this.tower.getName(), BuildingType.TOWER.name());
	}

	@Test
	public void testActualPointsTo4() {
		this.tower.setActualPoints(4);
		assertEquals(this.tower.getActualPoints(), 4);
	}	
	
	@Test
	public void testActualPointsTo30() {
		this.tower.setActualPoints(30);
		assertEquals(this.tower.getActualPoints(), 30);
	}
	
	@Test
	public void testSetAndAddPoints20() {
		this.tower.setActualPoints(10);
		this.tower.addPoints(10);
		assertEquals(this.tower.getActualPoints(), 20);
	}
	
	@Test
	public void testApplyNegativeDamageTo30() {
		this.tower.setActualPoints(20);
		this.tower.applyDamage(-10);
		assertEquals(this.tower.getActualPoints(), 30);
	}
		
	@Test
	public void testSetAndAddNegativePointsWithDamageLowerThanActualPointsTo5() {
		this.tower.setActualPoints(10);
		this.tower.addPoints(-5);
		assertEquals(this.tower.getActualPoints(), 5);
	}
	
	@Test
	public void testApplyDamageWithDamageLowerThenActualPoints() {
		this.tower.setActualPoints(20);
		this.tower.applyDamage(10);
		assertEquals(this.tower.getActualPoints(), 10);
	}
	
	@Test
	public void testAddNegativePointsWithDamageHigherThenActualPoints() {
		this.tower.setActualPoints(15);
		this.tower.addPoints(-30);
		assertEquals(this.tower.getActualPoints(), 0);
	}
	
	@Test
	public void testApplyDamageWithDamageHigherThenActualPoints() {
		this.tower.setActualPoints(15);
		this.tower.applyDamage(30);
		assertEquals(this.tower.getActualPoints(), 0);
	}
	
	@Test
	public void testApplyDamageWithDamageEqualToActualPoints(){
		this.tower.setActualPoints(20);
		this.tower.applyDamage(20);
		assertEquals(this.tower.getActualPoints(), 0);
	}
	
	@Test
	public void testAddNegativePointsWithDamageEqualToActualPoints() {
		this.tower.setActualPoints(15);
		this.tower.addPoints(-15);
		assertEquals(this.tower.getActualPoints(), 0);
	}
}
