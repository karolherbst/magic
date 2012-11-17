package herbstJennrichLehmannRitter.engine.model.action;

import herbstJennrichLehmannRitter.engine.model.Player;

import java.io.Serializable;

/**	Description of ComplexCardAction Class
 * Contains all relevant Interfaces for the cards that go beyond Resources, Buildingactions, Damage or card allocation.
 * This means the following cards: Auferstehung, Barracke, Baumgeist, Blitz und Donner, Blutmond, Demolieren,
 * Dieb, Einhorn, Elfische Bogenschuetzen, Glasperlen, Grundstein, Hauptader, Korrosion, Paradoxon, Paritaet, 
 * Pfuschender Schmied, Pure Magie, Speertraeger, Speikaefer, Spionage, Ueberflutung, Verschiebung and Weihnachtsmann.
 */

public interface ComplexCardAction extends Serializable {
	
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer);
	
	public String getOwnEffectDescription();
	public String getEnemyEffectDescription();
	
}
