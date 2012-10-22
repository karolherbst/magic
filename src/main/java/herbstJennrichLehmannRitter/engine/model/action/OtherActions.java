package herbstJennrichLehmannRitter.engine.model.action;

/**
 *
 * Interface für alle Karten, die nur einfache Aktionen durchführen, wie<br />
 *  - Schaden<br />
 *  - Ressourcenverteilung<br />
 *  - Gebäudeaktionen und <br />
 *  - Kartenaktionen<br />
 *  hinausgehen
 *
 */
public interface OtherActions {
	
	public int getTowerEffect();
	public int getWallEffect();
	public int getMineLvlEffect();
	public int getDungeonLvlEffect();
	public int getMagicLabLvlEffect();
	public int getBrickEffect();
	public int getMonsterEffect();
	public int getCrystalEffect();
}
