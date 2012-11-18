package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;

import org.junit.Test;

/** Description of ToStringTest Class
 *  This class tests the text of all complex cards and of some simple cards.
 */

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
	public void testAmethyst() {
		Card amethyst = this.gameCardFactory.createCard("Amethyst");
		assertNotNull(amethyst);
		System.out.println(amethyst);
		assertEquals("Amethyst[Kosten: 2 Kristall; Selbst: +3 Turm]", amethyst.toString());
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
	public void testBruechigerStein() {
		Card bruechigerStein = this.gameCardFactory.createCard("Brüchiger Stein");
		assertNotNull(bruechigerStein);
		System.out.println(bruechigerStein);
		assertEquals("Brüchiger Stein[Kosten: 7 Kristall; Selbst: +5 Turm; Gegner: -6 Ziegel]", 
			bruechigerStein.toString());
	}
	
	@Test
	public void testDemolierenComplexAction() {
		Card demolieren = this.gameCardFactory.createCard("Demolieren");
		assertNotNull(demolieren);
		System.out.println(demolieren);
		assertEquals("Demolieren[Kosten: 16 Ziegel; Gegner: Die Mauer wird zerstört]", demolieren.toString());
	}
	
	@Test
	public void testDiebComplexAction() {
		Card dieb = this.gameCardFactory.createCard("Dieb");
		assertNotNull(dieb);
		System.out.println(dieb);
		assertEquals("Dieb[Kosten: 12 Monster; Selbst: Man erhält die Hälfte des gegnerischen Verlustes; " +
			"Gegner: Es werden maximal 10 Kristall und 5 Ziegel abgezogen]", dieb.toString());
	}
	
	@Test
	public void testEinhornComplexAction() {
		Card einhorn = this.gameCardFactory.createCard("Einhorn");
		assertNotNull(einhorn);
		System.out.println(einhorn);
		assertEquals("Einhorn[Kosten: 9 Monster; Gegner: Wenn das eigene Zauberlabor größer als das des " +
			"Gegners ist, wird 12 Schaden zugefügt, sonst nur 8]", einhorn.toString());
	}
	
	@Test
	public void testElfischeBogenschuetzenComplexAction() {
		Card elfischeBogenschuetzen = this.gameCardFactory.createCard("Elfische Bogenschützen");
		assertNotNull(elfischeBogenschuetzen);
		System.out.println(elfischeBogenschuetzen);
		assertEquals("Elfische Bogenschützen[Kosten: 10 Monster; Gegner: Wenn die eigene Mauer mehr " +
			"Leben hat, als die gegnerische Mauer, dann werden dem Gegner 6 Turmschaden zugefügt, " +
				"sonst nur 6 Schaden.]", elfischeBogenschuetzen.toString());
	}
	
	@Test
	public void testGlasperlenComplexAction() {
		Card glasperlen = this.gameCardFactory.createCard("Glasperlen");
		assertNotNull(glasperlen);
		System.out.println(glasperlen);
		assertEquals("Glasperlen[Selbst: Wenn der eigene Turm kleiner als der des Gegner ist, " +
			"wird er um 2 erhöht, sonst um 1]", glasperlen.toString());
	}
	
	@Test
	public void testGrundsteinComplexAction() {
		Card grundstein = this.gameCardFactory.createCard("Grundstein");
		assertNotNull(grundstein);
		System.out.println(grundstein);
		assertEquals("Grundstein[Kosten: 3 Ziegel; Selbst: Wenn die eigene Mauer zerstört wurde, " +
			"wird die Mauer um 6 erhöht, sonst nur um 3]", grundstein.toString());
	}
	
	@Test
	public void testHauptaderComplexAction() {
		Card hauptader = this.gameCardFactory.createCard("Hauptader");
		assertNotNull(hauptader);
		System.out.println(hauptader);
		assertEquals("Hauptader[Kosten: 4 Ziegel; Selbst: Wenn der eigene Steinbruch kleiner als der " +
			"des Gegners ist, wird er um 2 erhöht, sonst nur um 1]", hauptader.toString());
	}
	
	@Test
	public void testKorrosionComplexAction() {
		Card korrosion = this.gameCardFactory.createCard("Korrosion");
		assertNotNull(korrosion);
		System.out.println(korrosion);
		assertEquals("Korrosion[Kosten: 11 Monster; Gegner: Wenn gegnerische Mauer>0 dann 10 Schaden sonst 7 Schaden]",
				korrosion.toString());
	}
	
	@Test
	public void testParadoxonComplexAction() {
		Card paradoxon = this.gameCardFactory.createCard("Paradoxon");
		assertNotNull(paradoxon);
		System.out.println(paradoxon);
		assertEquals("Paradoxon[Kosten: 5 Monster, 5 Kristall, 5 Ziegel; Selbst: Tausche Kartenhand mit dem Gegner; " +
			"Gegner: Tausche Kartenhand mit dem Gegner]", paradoxon.toString());
	}
	
	@Test
	public void testParitaetComplexAction() {
		Card paritaet = this.gameCardFactory.createCard("Parität");
		assertNotNull(paritaet);
		System.out.println(paritaet);
		assertEquals("Parität[Kosten: 7 Kristall; Selbst: Zauberlabor auf höchste " +
			"Zauberlaborstufe im Spiel setzen; Gegner: Zauberlabor auf höchste Zauberlaborstufe im " +
			"Spiel setzen]", paritaet.toString());
	}
	
	@Test
	public void testPfuschenderSchmiedComplexAction() {
		Card pfuschenderSchmied = this.gameCardFactory.createCard("Pfuschender Schmied");
		assertNotNull(pfuschenderSchmied);
		assertEquals("Pfuschender Schmied[Kosten: 2 Kristall, 2 Ziegel; Selbst: 1 Karte ziehen" +
			", noch eine Karte spielen; Gegner: Alle Steinbruchkarten aus der Hand ablegen]", 
			pfuschenderSchmied.toString());
	}
	
	@Test
	public void testPureMagieComplexAction() {
		Card pureMagie = this.gameCardFactory.createCard("Pure Magie");
		assertNotNull(pureMagie);
		System.out.println(pureMagie);
		assertEquals("Pure Magie[Kosten: 15 Kristall; Selbst: Verwirf alle Karten und ziehe 6 " +
			"zufällige Zauberlaborkarten]", pureMagie.toString());
	}
	
	@Test
	public void testSpeertraegerComplexAction() {
		Card speertraeger = this.gameCardFactory.createCard("Speerträger");
		assertNotNull(speertraeger);
		System.out.println(speertraeger);
		assertEquals("Speerträger[Kosten: 2 Monster; Gegner: Wenn die Mauer größer der gegnerischen Mauer dann 3 " +
				"Schaden sonst 2 Schaden]", speertraeger.toString());
	}
	
	@Test
	public void testSpeikaeferComplexAction() {
		Card speikaefer = this.gameCardFactory.createCard("Speikäfer");
		assertNotNull(speikaefer);
		System.out.println(speikaefer);
		assertEquals("Speikäfer[Kosten: 8 Monster; Gegner: Wenn gegnerische Mauer=0 dann 10 Schaden sonst 6 Schaden]", 
				speikaefer.toString());
	}
	
	@Test
	public void testSpionageComplexAction() {
		Card spionage = this.gameCardFactory.createCard("Spionage");
		assertNotNull(spionage);
		System.out.println(spionage);
		assertEquals("Spionage[Kosten: 5 Ziegel; Selbst: Wenn dein Steinbruchlevel niedriger " +
			"als das des Gegners ist, wird es auf die Stufe des Gegners angehoben]", spionage.toString());
	}
	
	@Test
	public void testUeberflutungComplexAction() {
		Card ueberflutung = this.gameCardFactory.createCard("Überflutung");
		assertNotNull(ueberflutung);
		System.out.println(ueberflutung);
		assertEquals("Überflutung[Kosten: 6 Ziegel; Selbst: Spieler mit niedrigster Mauer -1 Verlies und 2 " +
			"Turmschaden; Gegner: Spieler mit niedrigster Mauer -1 Verlies und 2 Turmschaden]", 
			ueberflutung.toString());
	}
	
	@Test
	public void testVerschiebungComplexAction() {
		Card verschiebung = this.gameCardFactory.createCard("Verschiebung");
		assertNotNull(verschiebung);
		System.out.println(verschiebung);
		assertEquals("Verschiebung[Kosten: 17 Ziegel; Selbst: Tausche deine Mauer mit der des " +
			"Gegners]", verschiebung.toString());
	}
	
	@Test
	public void testWeihnachtsmannComplexAction() {
		Card weihnachtsmann = this.gameCardFactory.createCard("Weihnachtsmann");
		assertNotNull(weihnachtsmann);
		System.out.println(weihnachtsmann);
		assertEquals("Weihnachtsmann[Selbst: +5 Ziegel, +5 Monster, +5 Kristall, " +
			"Zufällige Karte mit Kosten>14 vom Vorratsstapel oder Friedhof ziehen]", weihnachtsmann.toString());
	}
	
	@Test
	public void testPlayerToString() {
		Player player = new PlayerImpl();
		player.setName("Kurt");
		assertEquals("Player[name:Kurt tower:25 wall:10 " +
				"mine:{lvl:1 stock:15} magicLab:{lvl:1 stock:15} dungeon:{lvl:1 stock:15}]", player.toString());
	}
}
