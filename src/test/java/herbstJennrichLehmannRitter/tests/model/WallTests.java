package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
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
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testName() {
		assertEquals(this.wall.getName(), "Mauer");
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
