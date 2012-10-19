package herbstJennrichLehmannRitter.tests.factory;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;

import org.junit.Before;
import org.junit.Test;

public class GameCardFactoryTest {

	private GameCardFactory gameCardFactory;
	
	@Before
	public void before() {
		try {
			this.gameCardFactory = new GameCardFactoryImpl();
		} catch (EngineCouldNotStartException e) {
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void test() {
		Card card = this.gameCardFactory.createCard("testCard");
		assertNotNull(card);
	}

}
