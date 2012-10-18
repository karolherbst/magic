package herbstJennrichLehmannRitter.engine.model;

public interface SimpleCardAction {
	
	public int getEnemyTowerEffect();

	public int getOwnTowerEffect();

	public int getEnemyWallEffect();

	public int getOwnWallEffect();

	public int getEnemyMineLvlEffect();

	public int getOwnMineLvlEffect();

	public int getEnemyDungeonLvlEffect();

	public int getOwnDungeonLvlEffect();

	public int getEnemyMagicLabEffect();

	public int getOwnMagicLabEffect();

	public int getEnemyBrickEffect();

	public int getOwnBrickEffect();

	public int getEnemyMonsterEffect();

	public int getOwnMonsterEffect();

	public int getEnemyCristallEffect();

	public int getOwnCristallEffect();

	public int getAmountCardDraw();

	public int getAmountCardDiscard();

	public Boolean getPlayCards();

	public int getDamage();
}
