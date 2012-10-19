package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Card.CardType;
import herbstJennrichLehmannRitter.engine.model.impl.CardImpl;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

public class CardTests {

	private JAXBContext jaxbContext;
	
	@Before
	public void before() {
		try {
			this.jaxbContext = JAXBContext.newInstance("herbstJennrichLehmannRitter.engine.model");
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
	
	@Test
	public void testCardTypeEnum() {
		assertEquals(CardType.CARD_TYPE_MINE.toString(), "Steinbruch");getClass();
	}
	
	@Test
	public void testJaxBCard() {
		Card card = new CardImpl();
		card.setName("Karte");
		
		try {
			Marshaller marshaller = this.jaxbContext.createMarshaller();
			marshaller.marshal(card, System.out);
			
			Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
			String xmlTree = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><card>" +
					"<name>dahsjdhaks</name><costBrick>2</costBrick><costCrystal>4</costCrystal>" +
					"<costMonsters>6</costMonsters></card>";
			StringReader stringReader = new StringReader(xmlTree);
			Card card2 = (Card)unmarshaller.unmarshal(stringReader);
			
			assertEquals(card2.getName(), "dahsjdhaks");
			assertEquals(card2.getCostBrick(), 2);
			assertEquals(card2.getCostCrystal(), 4);
			assertEquals(card2.getCostMonsters(), 6);
		} catch (JAXBException e) {
			fail(e.getLocalizedMessage());
		}
		
	}

}
