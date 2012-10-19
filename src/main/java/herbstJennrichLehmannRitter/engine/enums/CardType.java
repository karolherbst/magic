package herbstJennrichLehmannRitter.engine.enums;

public enum CardType {
	CARD_TYPE_MINE("Steinbruch"),
	CARD_TYPE_MAGIC_LAB("Zauberlabor"),
	CARD_TYPE_DUNGEON("Verlies"),
	CARD_TYPE_SPECIAL("Spezial");
	
	private String value;
	
	private CardType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
