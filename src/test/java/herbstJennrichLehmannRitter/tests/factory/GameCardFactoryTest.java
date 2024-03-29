package herbstJennrichLehmannRitter.tests.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;

import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

/** Description of GameCardFactoryTests Class
 *  This test implements tests for the creation of cards from the .xml-file and the saving of new Decks to .xml.
 */

public class GameCardFactoryTest {

	private GameCardFactory gameCardFactory;
	
	@Before
	public void before() {
		this.gameCardFactory = new GameCardFactoryImpl();
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
		
		assertEquals(cards.toString(), "[Architektur[Kosten: 15 Ziegel; Selbst: +8 Mauer, +5 Turm], " + 
		                "Geheimraum[Kosten: 8 Ziegel; Selbst: +1 Zauberlabor, noch eine Karte spielen]]");
	}
}
