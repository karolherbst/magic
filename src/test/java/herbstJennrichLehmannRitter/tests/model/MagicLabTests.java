package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.MagicLabImpl;
import org.junit.Before;
import org.junit.Test;

public class MagicLabTests {

	private ResourceBuilding magicLab;
	
	@Before
	public void before() {
		try {
			this.magicLab = new MagicLabImpl();
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
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
	public void testLevel30() {
		this.magicLab.setLevel(30);
		assertEquals(this.magicLab.getLevel(), 30);
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
}
