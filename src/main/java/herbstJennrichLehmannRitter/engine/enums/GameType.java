package herbstJennrichLehmannRitter.engine.enums;

/** Description of GameType enum
 *  This Class implements the enums for all Game Types.
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