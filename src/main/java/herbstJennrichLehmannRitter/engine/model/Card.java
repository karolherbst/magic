package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;

/**
 * 
 * Interface für die Spielkarten
 * Dieses Interface beinhaltet die Schnittstellen für alle Kartenaktionen
 * 
 */
public interface Card {
	
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
