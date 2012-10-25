package herbstJennrichLehmannRitter.engine.enums;

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
