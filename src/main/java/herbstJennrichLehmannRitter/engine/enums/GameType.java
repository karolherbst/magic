package herbstJennrichLehmannRitter.engine.enums;

/**
 * 
 * Enum der Spieltypen
 * 
 */
public enum GameType {
	
	TOWER_BUILDING("Turmbau"),
	COLLECTION_RAGE("Sammelwut");
	
	private final String value;
	
	private GameType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}