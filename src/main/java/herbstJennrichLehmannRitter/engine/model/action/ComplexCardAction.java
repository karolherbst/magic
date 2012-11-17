package herbstJennrichLehmannRitter.engine.model.action;

import herbstJennrichLehmannRitter.engine.model.Player;

import java.io.Serializable;

/**
 * 
 * Interface für alle Karten, die über die Ressourcenverteilung, Gebäudeaktionen, 
 * Schaden und Kartenzuteilung hinausgehen 
 * 
 * Verlies Karten: Blutmond, Elfische Bogenschützen, Elfischer Späher,
 * Fee, Korrosion, Schäfchen, Schattenfee, Speerträger, Speikäfer
 */
public interface ComplexCardAction extends Serializable {
	
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer);
	
	public String getOwnEffectDescription();
	public String getEnemyEffectDescription();
	
}
