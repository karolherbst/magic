package herbstJennrichLehmannRitter.engine.model.action;

import herbstJennrichLehmannRitter.engine.model.Player;


/**
 * 
 * Interface für alle Karten, die über die Ressourcenverteilung, Gebäudeaktionen, 
 * Schaden und Kartenzuteilung hinausgehen 
 * 
 * Steinbruch-Karten: Barracke, Demolieren, Grundstein, Hauptader, Spionage, Verschiebung
 * Zauberlabor-Karten: Baukoloss, Blitz und Donner, Glasperlen, Parität, Prisma, Pure Magie, Quarz, Rauchquarz, Weihnachtsmann  
 *
 *Verslies Karten: Blutmond, Dieb, Einhorn, Elfische Bogenschützen, Elfischer Späher,
 *Fee, 
 */
public interface ComplexCardAction {
	
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer);
	
}
