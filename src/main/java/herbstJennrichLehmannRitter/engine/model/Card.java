package herbstJennrichLehmannRitter.engine.model;

/**
 * 
 */
public interface Card {
	
	/**
	 * 
	 */
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
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * 
	 * @return
	 */
	public String getName();
	
	/**
	 * 
	 * @param cardType
	 */
	public void setCardType(CardType cardType);
	
	/**
	 * 
	 * @return
	 */
	public CardType getCardType();
	
	/**
	 * 
	 * @param costBrick
	 */
	public void setCostBrick(int costBrick);
	
	/**
	 * 
	 * @return
	 */
	public int getCostBrick();
	
	/**
	 * 
	 * @param costMonsters
	 */
	public void setCostMonsters(int costMonsters);
	
	/**
	 * 
	 * @return
	 */
	public int getCostMonsters();
	
	/**
	 * 
	 * @param costCrystal
	 */
	public void setCostCrystal(int costCrystal);
	
	/**
	 * 
	 * @return
	 */
	public int getCostCrystal();
	
	/**
	 * 
	 * @param simpleCardAction
	 */
	public void setSimpleCardAction(SimpleCardAction simpleCardAction);
	
	/**
	 * 
	 * @return
	 */
	public SimpleCardAction getSimpleCardAction();
	
	/**
	 * 
	 * @param complexCardAction
	 */
	public void setComplexCardAction(ComplexCardAction complexCardAction);
	
	/**
	 * 
	 * @return
	 */
	public ComplexCardAction getComplexCardAction();
	
}
