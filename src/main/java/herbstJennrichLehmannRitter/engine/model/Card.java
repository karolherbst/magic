package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;

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
	public SimpleCardAction getSimpleCardAction();
	public ComplexCardAction getComplexCardAction();
}
