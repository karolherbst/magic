package herbstJennrichLehmannRitter.engine.model.action;

public interface CardAction {
	
	public int getAmountCardDraw();
	public int getOwnAmountCardDiscard();
	public int getEnemyAmountCardDiscard();
	public boolean getPlayCards();
	
}
