package herbstJennrichLehmannRitter.engine.model.action;

import herbstJennrichLehmannRitter.engine.model.Player;


/**
 * 
 * Interface für alle Karten, die über die Ressourcenverteilung, Gebäudeaktionen, 
 * Schaden und Kartenzuteilung hinausgehen 
 *
 */
public interface ComplexCardAction {
	
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer);
	
}