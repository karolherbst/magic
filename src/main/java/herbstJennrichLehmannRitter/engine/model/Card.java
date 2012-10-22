package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;

/**
 * 
 * Interface für die Spielkarten
 * Dieses Interface beinhaltet die Schnittstellen für alle Kartenaktionen
 * 
 */
public interface Card {
	
	public String getName();
	public CardType getCardType();
	public int getCostBrick();
	public int getCostMonsters();
	public int getCostCrystal();
	public ResourceAction getOwnSimpleCardAction();
	public ResourceAction getEnemySimpleCardAction();
	public ComplexCardAction getComplexCardAction();
}
