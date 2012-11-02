package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.impl.CardImpl;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCard;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCards;
import herbstJennrichLehmannRitter.engine.model.xml.XmlResourceAction;

import java.io.IOException;
import java.io.InputStream;
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
		assertEquals(CardType.DUNGEON.toString(), "Verlieskarte");
		assertEquals(CardType.MAGIC_LAB.toString(), "Zauberlaborkarte");
		assertEquals(CardType.MINE.toString(), "Steinbruchkarte");
		assertEquals(CardType.SPECIAL.toString(), "Spezialkarte");
	}
	
	@Test
	public void testJaxBCard() {
		XmlCard card = new XmlCard();
		card.setOwnResourceAction(new XmlResourceAction());
		card.setEnemyResourceAction(new XmlResourceAction());
		card.setCardType(CardType.DUNGEON);
		card.setName("Karte");
		
		try {
			Marshaller marshaller = this.jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(card, System.out);
			
			Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
			String xmlTree = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Card name=\"dahsjdhaks\">" +
					"<CardType>Steinbruch</CardType><CostBrick>2</CostBrick><CostCrystal>4</CostCrystal>" +
					"<CostMonster>6</CostMonster></Card>";
			StringReader stringReader = new StringReader(xmlTree);
			XmlCard card2 = (XmlCard)unmarshaller.unmarshal(stringReader);
			
			assertEquals(card2.getName(), "dahsjdhaks");
			assertEquals(card2.getCostBrick(), 2);
			assertEquals(card2.getCostCrystal(), 4);
			assertEquals(card2.getCostMonsters(), 6);
			assertEquals(card2.getCardType(), CardType.MINE);
		} catch (JAXBException e) {
			fail(e.getLocalizedMessage());
		}
		
	}
	
	@Test
	public void testCardXml() {
		XmlCard xmlCard = new XmlCard();
		xmlCard.setName("changeableCard");
		
		Card card = new CardImpl(xmlCard);
		
		assertEquals(xmlCard.getName(), card.getName());
		assertFalse(card == xmlCard);
	}
	
	@Test
	public void testAllCards() {
		try {
			Unmarshaller unmarshaller = this.jaxbContext.createUnmarshaller();
			InputStream is = this.getClass().getResourceAsStream("/herbstJennrichLehmannRitter/engine/model/cards.xml");
			XmlCards xmlCards = (XmlCards)unmarshaller.unmarshal(is);
			is.close();
			
			Marshaller marshaller = this.jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal(xmlCards, System.out);
			
		} catch (JAXBException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.getLocalizedMessage());
		}
	}
}
