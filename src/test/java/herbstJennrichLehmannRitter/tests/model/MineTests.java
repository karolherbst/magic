package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.MineImpl;

import org.junit.Before;
import org.junit.Test;

public class MineTests {

	private ResourceBuilding mine;
	
	@Before
	public void before() {
		try {
			this.mine = new MineImpl();
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
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
	public void testLevel30() {
		this.mine.setLevel(30);
		assertEquals(this.mine.getLevel(), 30);
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
}
