package herbstJennrichLehmannRitter.engine.enums;

/**
 * 
 * Enum der Ressourcentypen
 * 
 */
public enum RessourceType {
	
	BRICK("Ziegel"),
	CRYSTAL("Kristall"),
	MONSTER("Monster");
	
	private final String value;
	
	private RessourceType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
