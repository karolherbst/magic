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
	public void testBlitzUndDonnerComplexAction() {
		Card blitzUndDonner = this.gameCardFactory.createCard("Blitz und Donner");
		assertNotNull(blitzUndDonner);
		System.out.println(blitzUndDonner);
		assertEquals("Blitz und Donner[Kosten: 11 Kristall; Gegner: Wenn der eigene Turm größer als der des Gegners ist, " +
				"werden 8 Turmschaden und sonst 8 Schaden zugefügt]", blitzUndDonner.toString());
	}
}
