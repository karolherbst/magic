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
			String xmlTree = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><cardImpl>" +
					"<name>dahsjdhaks</name><costBrick>0</costBrick><costCrystal>0</costCrystal>" +
					"<costMonsters>0</costMonsters></cardImpl>";
			StringReader stringReader = new StringReader(xmlTree);
			Card card2 = (Card)unmarshaller.unmarshal(stringReader);
			System.out.println(card2.toString());
		} catch (JAXBException e) {
			fail(e.getLocalizedMessage());
		}
		
	}

}
