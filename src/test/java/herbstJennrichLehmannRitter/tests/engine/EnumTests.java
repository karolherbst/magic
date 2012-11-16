package herbstJennrichLehmannRitter.tests.engine;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.enums.BuildingType;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.enums.ResourceType;

import org.junit.Test;

public class EnumTests {

	@Test
	public void testBuildingTypeToString() {
		assertEquals(BuildingType.DUNGEON.toString(), "Verlies");
		assertEquals(BuildingType.MAGIC_LAB.toString(), "Zauberlabor");
		assertEquals(BuildingType.MINE.toString(), "Steinbruch");
		assertEquals(BuildingType.WALL.toString(), "Mauer");
		assertEquals(BuildingType.TOWER.toString(), "Turm");
	}
	
	@Test
	public void testCardTypeToString() {
		assertEquals(CardType.DUNGEON.toString(), "Verlieskarte");
		assertEquals(CardType.MAGIC_LAB.toString(), "Zauberlaborkarte");
		assertEquals(CardType.MINE.toString(), "Steinbruchkarte");
		assertEquals(CardType.SPECIAL.toString(), "Spezialkarte");
	}

	@Test
	public void testGameTypeToString() {
		assertEquals(GameType.COLLECTION_RAGE.toString(), "Sammelwut");
		assertEquals(GameType.TOWER_BUILDING.toString(), "Turmbau");
	}
	
	@Test
	public void testRessourceTypeToString() {
		assertEquals(ResourceType.BRICK.toString(), "Ziegel");
		assertEquals(ResourceType.CRYSTAL.toString(), "Kristall");
		assertEquals(ResourceType.MONSTER.toString(), "Monster");
	}
}
