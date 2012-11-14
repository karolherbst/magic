package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;

import org.junit.Test;

public class ToStringTest {

	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	
	@Test
	public void testArchitektur() {
		Card architektur = this.gameCardFactory.createCard("Architektur");
		assertNotNull(architektur);
		System.out.println(architektur);
		assertEquals("Architektur[Kosten: 15 Ziegel; Selbst: +8 Mauer, +5 Turm]", architektur.toString());
	}
	
	@Test
	public void testAuferstehungComplexAction() {
		Card auferstehung = this.gameCardFactory.createCard("Auferstehung");
		assertNotNull(auferstehung);
		System.out.println(auferstehung);
		assertEquals("Auferstehung[Kosten: 6 Monster, 6 Kristall, 6 Ziegel; Selbst: +30% Turm]", auferstehung.toString());
	}
	
	@Test
	public void testBarrackeComplexAction() {
		Card barracke = this.gameCardFactory.createCard("Barracke");
		assertNotNull(barracke);
		System.out.println(barracke);
		assertEquals("Barracke[Kosten: 10 Ziegel; Selbst: +6 Mauer, +6 Monster, Wenn das eigene Verlies " +
				"kleiner als das des Gegners ist, wird es um 1 erhöht]", barracke.toString());
	}
	
	@Test
	public void testBaumgeistComplexAction() {
		Card baumgeist = this.gameCardFactory.createCard("Baumgeist");
		assertNotNull(baumgeist);
		System.out.println(baumgeist);
		assertEquals("Baumgeist[Kosten: 9 Monster, 7 Ziegel; Gegner: Wenn das eigene Verlies größer als die" +
				" gegnerische Mauer ist, bekommt der Gegner 11 Turmschaden]", baumgeist.toString());
	}
	
	@Test
	public void testBlitzUndDonnerComplexAction() {
		Card blitzUndDonner = this.gameCardFactory.createCard("Blitz und Donner");
		assertNotNull(blitzUndDonner);
		System.out.println(blitzUndDonner);
		assertEquals("Blitz und Donner[Kosten: 11 Kristall; Gegner: Wenn der eigene Turm größer als der des Gegners ist, " +
				"werden 8 Turmschaden und sonst 8 Schaden zugefügt]", blitzUndDonner.toString());
	}
	
	@Test
	public void testBlutmondComplexAction() {
		Card blutmond = this.gameCardFactory.createCard("Blutmond");
		assertNotNull(blutmond);
		System.out.println(blutmond);
		assertEquals("Blutmond[Kosten: 8 Monster; Selbst: -1 Zauberlabor, Es werden alle Karten auf der Hand verworfen " +
				"und 6 zufällige Verlieskarten gezogen]", blutmond.toString());
	}
	
	@Test
	public void testDemolierenComplexAction() {
		Card demolieren = this.gameCardFactory.createCard("Demolieren");
		assertNotNull(demolieren);
		System.out.println(demolieren);
		assertEquals("Demolieren[Kosten: 16 Ziegel; Gegner: Die Mauer wird zerstört]", demolieren.toString());
	}
}
