package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
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
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testName() {
		assertEquals(this.tower.getName(), "Turm");
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

}
