package herbstJennrichLehmannRitter.tests.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.enums.CardType;
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
	public void testArchitektur() {
		Card card = this.gameCardFactory.createCard("Architektur");
		assertNotNull(card);
		assertEquals(card.getName(), "Architektur");
		assertEquals(card.getCardType(), CardType.CARD_TYPE_MINE);
		assertEquals(card.getSimpleCardAction().getOwnWallEffect(), 8);
		assertEquals(card.getSimpleCardAction().getOwnTowerEffect(), 5);
		assertEquals(card.getCostBrick(), 15);
	}

}
