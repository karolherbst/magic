package herbstJennrichLehmannRitter.engine.model.action;

import herbstJennrichLehmannRitter.engine.model.Player;


/**
 * 
 * Interface für alle Karten, die über die Ressourcenverteilung, Gebäudeaktionen, 
 * Schaden und Kartenzuteilung hinausgehen 
 * 
 * Steinbruch-Karten: Barracke, Demolieren, Grundstein, Hauptader, Spionage, Verschiebung
 *
 * Verlies Karten: Blutmond, Dieb, Elfische Bogenschützen, Elfischer Späher,
 * Fee, Korrosion, Schäfchen, Schattenfee, Speerträger, Speikäfer
 * 
 * Spezialkarten: Auferstehung, Baumgeist, Paradoxon, Pfuschender Schmied, 
 */
public interface ComplexCardAction {
	
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer);
	
}
