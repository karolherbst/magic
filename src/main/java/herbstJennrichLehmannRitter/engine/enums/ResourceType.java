package herbstJennrichLehmannRitter.engine.enums;

/**
 * 
 * Enum der Ressourcentypen
 * 
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
