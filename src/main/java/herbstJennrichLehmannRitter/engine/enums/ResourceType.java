package herbstJennrichLehmannRitter.engine.enums;

/** Description of ResourceType enum
 *  This Class implements the enums for all Resources.
 */

public enum ResourceType {
	
	BRICK("Ziegel"),
	CRYSTAL("Kristall"),
	MONSTER("Monster");
	
	private final String value;
	
	private ResourceType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
