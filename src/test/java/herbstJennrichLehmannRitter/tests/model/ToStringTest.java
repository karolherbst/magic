package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;

import org.junit.Test;

public class ToStringTest {

	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	
	@Test
	public void test() {
		Card architektur = this.gameCardFactory.createCard("Architektur");
		assertNotNull(architektur);
		System.out.println("Architektur[Kosten: 15 Ziegel; Selbst: +8 Mauer, +5 Turm]");
		System.out.println(architektur.toString());
		assertEquals("Architektur[Kosten: 15 Ziegel; Selbst: +8 Mauer, +5 Turm]", architektur.toString());
	}

}
