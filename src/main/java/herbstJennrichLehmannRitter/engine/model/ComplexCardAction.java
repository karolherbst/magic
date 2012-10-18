package herbstJennrichLehmannRitter.engine.model;


/**
 * 
 * Interface für alle Karten, die über die Ressourcenverteilung, Gebäudeaktionen, 
 * Schaden und Kartenzuteilung hinausgehen 
 *
 */
public interface ComplexCardAction {
	
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer);
	
}
