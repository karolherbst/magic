package herbstJennrichLehmannRitter.engine.model;

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
public interface SimpleCardAction {
	
	public int getEnemyTowerEffect();
	public int getOwnTowerEffect();

	public int getEnemyWallEffect();
	public int getOwnWallEffect();

	public int getEnemyMineLvlEffect();
	public int getOwnMineLvlEffect();

	public int getEnemyDungeonLvlEffect();
	public int getOwnDungeonLvlEffect();

	public int getEnemyMagicLabLvlEffect();
	public int getOwnMagicLabLvlEffect();

	public int getEnemyBrickEffect();
	public int getOwnBrickEffect();

	public int getEnemyMonsterEffect();
	public int getOwnMonsterEffect();

	public int getEnemyCrystalEffect();
	public int getOwnCrystalEffect();

	public int getAmountCardDraw();
	public int getAmountCardDiscard();

	public boolean getPlayCards();

	public int getDamage();
}
