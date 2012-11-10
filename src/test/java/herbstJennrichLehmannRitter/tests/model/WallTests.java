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

}
