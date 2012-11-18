package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.exception.GameCardFactoryException;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.CardAction;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;
import herbstJennrichLehmannRitter.engine.model.action.impl.CardActionImpl;
import herbstJennrichLehmannRitter.engine.model.action.impl.ResourceActionImpl;
import herbstJennrichLehmannRitter.engine.model.impl.CardImpl;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCard;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCardAction;
import herbstJennrichLehmannRitter.engine.model.xml.XmlCards;
import herbstJennrichLehmannRitter.engine.model.xml.XmlResourceAction;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

/** Description of CardTests Class
 *  This class implements tests for the simple card actions.
 */

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
	
	@Test (expected=GameCardFactoryException.class)
	public void testCardIsNullException() throws GameEngineException {
		new CardImpl(null);
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
					"<CostMonster>6</CostMonster><CanBeDiscarded>false</CanBeDiscarded><CardEffect>" +
					"<DrawCard>3</DrawCard><OwnDiscardCard>2</OwnDiscardCard><EnemyDiscardCard>4</EnemyDiscardCard>" +
					"<PlayAnotherCard>true</PlayAnotherCard></CardEffect></Card>";
			StringReader stringReader = new StringReader(xmlTree);
			XmlCard card2 = (XmlCard)unmarshaller.unmarshal(stringReader);
			
			assertEquals(card2.getName(), "dahsjdhaks");
			assertEquals(card2.getCostBrick(), 2);
			assertEquals(card2.getCostCrystal(), 4);
			assertEquals(card2.getCostMonsters(), 6);
			assertEquals(card2.getCardType(), CardType.MINE);
			assertEquals(card2.getCanBeDiscarded(), false);
			assertEquals(card2.getCardAction().getAmountCardDraw(), 3);
			assertEquals(card2.getCardAction().getOwnAmountCardDiscard(), 2);
			assertEquals(card2.getCardAction().getEnemyAmountCardDiscard(), 4);
			assertEquals(card2.getCardAction().getPlayCards(), true);
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
	
	@Test
	public void testEffectDescription() {
		XmlCardAction xmlCard = new XmlCardAction();
		assertEquals(xmlCard.getOwnEffectDescription(), "");
		assertEquals(xmlCard.getEnemyEffectDescription(), "");
	}
	
	@Test
	public void testRessourceActionWithoutACard() {
		ResourceAction resourceAction = new ResourceActionImpl(null);
		assertEquals(resourceAction.getBrickEffect(), 0);
		assertEquals(resourceAction.getCrystalEffect(), 0);
		assertEquals(resourceAction.getMonsterEffect(), 0);
		assertEquals(resourceAction.getDungeonLvlEffect(), 0);
		assertEquals(resourceAction.getMagicLabLvlEffect(), 0);
		assertEquals(resourceAction.getMineLvlEffect(), 0);
		assertEquals(resourceAction.getTowerEffect(), 0);
		assertEquals(resourceAction.getWallEffect(), 0);
		assertEquals(resourceAction.getDamage(), 0);
		
	}
	
	@Test
	public void testCardActionWithoutACard() {
		CardAction cardAction = new CardActionImpl(null);
		assertEquals(cardAction.getAmountCardDraw(), 0);
		assertEquals(cardAction.getOwnAmountCardDiscard(), 0);
		assertEquals(cardAction.getEnemyAmountCardDiscard(), 0);
		assertEquals(cardAction.getPlayCards(), false);
	}
	
	@Test
	public void testMagicUtilsAddNullToStringBuider() {
		StringBuilder stringBuilder = new StringBuilder();

		MagicUtils.addValueToStringBuilder(null, stringBuilder);
		MagicUtils.addValueToStringBuilder("", null, stringBuilder, false);
		assertEquals(stringBuilder.length(), 0);
	}
	
	@Test
	public void testCanPlayerEffortCard() {
		PlayerFactory playerFactory = new PlayerFactoryImpl();
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		
		Player player = playerFactory.createPlayer("Spieler", Globals.getGameCardFactory().createDefaultDeck(),
				25, 25, 1, 15);
		Card cardArchitektur = gameCardFactory.createCard("Architektur");
		Card cardKatapult = gameCardFactory.createCard("Katapult");
		Card cardDisput = gameCardFactory.createCard("Disput");
		Card cardDiamant = gameCardFactory.createCard("Diamant");
		Card cardEinhorn = gameCardFactory.createCard("Einhorn");
		Card cardKoloss = gameCardFactory.createCard("Koloss");
		
		assertTrue(MagicUtils.canPlayerEffortCard(player, cardArchitektur));
		assertFalse(MagicUtils.canPlayerEffortCard(player, cardKatapult));
		assertTrue(MagicUtils.canPlayerEffortCard(player, cardDisput));
		assertFalse(MagicUtils.canPlayerEffortCard(player, cardDiamant));
		assertTrue(MagicUtils.canPlayerEffortCard(player, cardEinhorn));
		assertFalse(MagicUtils.canPlayerEffortCard(player, cardKoloss));
	}
	
	@Test
	public void testCanPlayerPlayAnotherRound() {
		PlayerFactory playerFactory = new PlayerFactoryImpl();
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		
		Player player = playerFactory.createPlayer("Spieler", Globals.getGameCardFactory().createDefaultDeck(),
				25, 25, 1, 15);
		Card cardFreundlicheUmgebung = gameCardFactory.createCard("Freundliche Umgebung");
		Card cardGrundstein = gameCardFactory.createCard("Grundstein");
		
		assertTrue(MagicUtils.canPlayerPlayAnotherRound(cardFreundlicheUmgebung, player));
		assertFalse(MagicUtils.canPlayerPlayAnotherRound(cardGrundstein, player));
		
		player.getDeck().discardAllCards();
		assertEquals(player.getDeck().getHandDeckSize(), 0);
		assertFalse(MagicUtils.canPlayerPlayAnotherRound(cardFreundlicheUmgebung, player));
	}
	
	@Test
	public void testCardEquals() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card architektur = gameCardFactory.createCard("Architektur");
		Integer zwoelf = new Integer(12);
		
		assertFalse(architektur.equals(zwoelf));
	}
	
}
