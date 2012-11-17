package herbstJennrichLehmannRitter.engine.enums;

/** Description of BuildingType enum
 *  This Class implements the enums for all Buildings.
 */

public enum BuildingType {
	
	TOWER("Turm"),
	WALL("Mauer"),
	MINE("Steinbruch"),
	MAGIC_LAB("Zauberlabor"),
	DUNGEON("Verlies");
	
	private final String value;
	
	private BuildingType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
