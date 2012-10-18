package herbstJennrichLehmannRitter.engine.model;

/**
 * Interface für die Spielkarten
 * Dieses Interface beinhaltet die Schnittstellen für alle Kartenaktionen
 */
public interface Card {
	
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
	
	public void setName(String name);
	public String getName();
	
	public void setCardType(CardType cardType);
	public CardType getCardType();
	
	public void setCostBrick(int costBrick);
	public int getCostBrick();
	
	public void setCostMonsters(int costMonsters);
	public int getCostMonsters();
	
	public void setCostCrystal(int costCrystal);
	public int getCostCrystal();
	
	public void setSimpleCardAction(SimpleCardAction simpleCardAction);
	public SimpleCardAction getSimpleCardAction();
	
	public void setComplexCardAction(ComplexCardAction complexCardAction);
	public ComplexCardAction getComplexCardAction();
}
