package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;

public interface ChangeableCard extends Card {
	
	public void setName(String name);
	public void setCardType(CardType cardType);
	public void setCostBrick(int costBrick);
	public void setCostMonsters(int costMonsters);
	public void setCostCrystal(int costCrystal);
	public void setSimpleCardAction(SimpleCardAction simpleCardAction);
	public void setComplexCardAction(ComplexCardAction complexCardAction);
	
}
