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

import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

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
		assertEquals(card.getCardType(), CardType.MINE);
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
	
	@Test
	public void testSaveToXml() {
		Writer writer = new OutputStreamWriter(System.out);
		Collection<String> cardNames = new ArrayList<String>();
		
		cardNames.add("Architektur");
		cardNames.add("Ausbeutung");
		cardNames.add("Barracke");
		
		this.gameCardFactory.saveToXml(cardNames, writer);
	}
	
	@Test
	public void testLoadFromXml() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
		             "<CardNames>" +
		             	"<Card>Architektur</Card>" +
		             	"<Card>Geheimraum</Card>" +
		             "</CardNames>";
		Reader reader = new StringReader(xml);
		Collection<Card> cards = this.gameCardFactory.loadFromXml(reader);
		
		for (Card card : cards) {
			System.out.println(card);
		}
	}
}
