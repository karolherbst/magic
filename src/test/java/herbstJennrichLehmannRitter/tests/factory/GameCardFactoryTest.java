package herbstJennrichLehmannRitter.tests.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;

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
		assertTrue(card.getCanBeDiscarded());
	}
	
	@Test
	public void testDieb() {
		Card dieb = this.gameCardFactory.createCard("Dieb");
		Player player1 = new PlayerImpl();
		Player player2 = new PlayerImpl();
		
		dieb.getComplexCardAction().applyActionOnPlayer(player1, player2);
		
		assertEquals(20, player1.getMagicLab().getStock());
		assertEquals(18, player1.getMine().getStock());
		assertEquals(5, player2.getMagicLab().getStock());
		assertEquals(10, player2.getMine().getStock());
	}
	
	@Test
	public void testBaukoloss() {
		Card baukoloss = this.gameCardFactory.createCard("Baukoloss");
		assertFalse(baukoloss.getCanBeDiscarded());
	}
}
