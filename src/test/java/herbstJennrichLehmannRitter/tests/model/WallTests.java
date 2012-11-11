package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.enums.BuildingType;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.WallImpl;

import org.junit.Before;
import org.junit.Test;

public class WallTests {

	private DefenceBuilding wall;
	
	@Before
	public void before() {
		try {
			this.wall = new WallImpl();
		} catch (GameEngineException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testName() {
		assertEquals(this.wall.getName(), BuildingType.WALL.name());
	}

	@Test
	public void testActualPointsTo4() {
		this.wall.setActualPoints(4);
		assertEquals(this.wall.getActualPoints(), 4);
	}	
	
	@Test
	public void testActualPointsTo30() {
		this.wall.setActualPoints(30);
		assertEquals(this.wall.getActualPoints(), 30);
	}
	
	@Test
	public void testSetAndAddPoints20() {
		this.wall.setActualPoints(10);
		this.wall.addPoints(10);
		assertEquals(this.wall.getActualPoints(), 20);
	}
	
	@Test
	public void testApplyNegativeDamageTo30() {
		this.wall.setActualPoints(20);
		this.wall.applyDamage(-10);
		assertEquals(this.wall.getActualPoints(), 30);
	}
		
	@Test
	public void testSetAndAddNegativePointsWithDamageLowerThanActualPointsTo5() {
		this.wall.setActualPoints(10);
		this.wall.addPoints(-5);
		assertEquals(this.wall.getActualPoints(), 5);
	}
	
	@Test
	public void testApplyDamageWithDamageLowerThenActualPoints() {
		this.wall.setActualPoints(20);
		this.wall.applyDamage(10);
		assertEquals(this.wall.getActualPoints(), 10);
	}
	
	@Test
	public void testAddNegativePointsWithDamageHigherThenActualPoints() {
		this.wall.setActualPoints(15);
		this.wall.addPoints(-30);
		assertEquals(this.wall.getActualPoints(), 0);
	}
	
	@Test
	public void testApplyDamageWithDamageHigherThenActualPoints() {
		this.wall.setActualPoints(15);
		this.wall.applyDamage(30);
		assertEquals(this.wall.getActualPoints(), 0);
	}
	
	@Test
	public void testApplyDamageWithDamageEqualToActualPoints(){
		this.wall.setActualPoints(20);
		this.wall.applyDamage(20);
		assertEquals(this.wall.getActualPoints(), 0);
	}
	
	@Test
	public void testAddNegativePointsWithDamageEqualToActualPoints() {
		this.wall.setActualPoints(15);
		this.wall.addPoints(-15);
		assertEquals(this.wall.getActualPoints(), 0);
	}

}
