package herbstJennrichLehmannRitter.tests.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCards;

import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

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
		assertEquals(card.getOwnResourceAction().getWallEffect(), 8);
		assertEquals(card.getOwnResourceAction().getTowerEffect(), 5);
		assertEquals(card.getCostBrick(), 15);
	}
}
