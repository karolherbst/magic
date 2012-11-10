package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.enums.BuildingType;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.TowerImpl;

import org.junit.Before;
import org.junit.Test;

public class TowerTests {

	private DefenceBuilding tower;
	
	@Before
	public void before() {
		try {
			this.tower = new TowerImpl();
		} catch (GameEngineException e) {
			fail(e.getLocalizedMessage());
		}
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
	public void testApplyDamageWithDamageLowerThenActualPoints() {
		this.tower.setActualPoints(20);
		this.tower.applyDamage(10);
		assertEquals(this.tower.getActualPoints(), 10);
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

}
