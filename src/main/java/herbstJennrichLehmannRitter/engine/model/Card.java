package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.action.CardAction;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;

import java.io.Serializable;

/**	Description of Card Class
 * Interface for all Cards 
 */
public interface Card extends Serializable {
	
	public String getName();
	public CardType getCardType();
	public int getCostBrick();
	public int getCostMonsters();
	public int getCostCrystal();
	public CardAction getCardAction();
	public ResourceAction getOwnResourceAction();
	public ResourceAction getEnemyResourceAction();
	public ComplexCardAction getComplexCardAction();
	public boolean getCanBeDiscarded();
	
	public String getCostDescription();
	public String getOwnEffectDescription();
	public String getEnemyEffectDescription();

}
