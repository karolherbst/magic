package herbstJennrichLehmannRitter.engine.model.action;

import java.io.Serializable;

public interface CardAction extends Serializable {
	
	public int getAmountCardDraw();
	public int getOwnAmountCardDiscard();
	public int getEnemyAmountCardDiscard();
	public boolean getPlayCards();

	public String getOwnEffectDescription();
	public String getEnemyEffectDescription();

}
