package herbstJennrichLehmannRitter.engine.model.impl;

import javax.xml.bind.annotation.XmlElement;

import herbstJennrichLehmannRitter.engine.model.SimpleCardAction;

public class SimpleCardActionImpl implements SimpleCardAction {

	private int enemyTowerEffect;
	private int ownTowerEffect;
	private int enemyWallEffect;
	private int ownWallEffect;
	private int enemyMineLvlEffect;
	private int ownMineLvlEffect;
	private int enemyDungeonLvlEffect;
	private int ownDungeonLvlEffect;
	private int enemyMagicLabLvlEffect;
	private int ownMagicLabLvlEffect;
	private int enemyMonsterEffect;
	private int ownMonsterEffect;
	private int enemyCrystalEffect;
	private int ownCrystalEffect;
	private int enemyBrickEffect;
	private int ownBrickEffect;
	private int amountCardDraw;
	private int amountCardDiscard;
	private boolean playCards;
	private int damage;
	
	public int getEnemyTowerEffect() {
		return this.enemyTowerEffect;
	}

	public void setEnemyTowerEffect(int enemyTowerEffect) {
		this.enemyTowerEffect = enemyTowerEffect;
	}

	@XmlElement(name="OwnTowerEffect")
	public int getOwnTowerEffect() {
		return this.ownTowerEffect;
	}

	public void setOwnTowerEffect(int ownTowerEffect) {
		this.ownTowerEffect = ownTowerEffect;
	}

	@XmlElement(name="EnemyWallEffect")
	public int getEnemyWallEffect() {
		return this.enemyWallEffect;
	}

	public void setEnemyWallEffect(int enemyWallEffect) {
		this.enemyWallEffect = enemyWallEffect;
	}

	@XmlElement(name="OwnWallEffect")
	public int getOwnWallEffect() {
		return this.ownWallEffect;
	}

	public void setOwnWallEffect(int ownWallEffect) {
		this.ownWallEffect = ownWallEffect;
	}

	public int getEnemyMineLvlEffect() {
		return this.enemyMineLvlEffect;
	}

	public void setEnemyMineLvlEffect(int enemyMineLvlEffect) {
		this.enemyMineLvlEffect = enemyMineLvlEffect;
	}

	public int getOwnMineLvlEffect() {
		return this.ownMineLvlEffect;
	}

	public void setOwnMineLvlEffect(int ownMineLvlEffect) {
		this.ownMineLvlEffect = ownMineLvlEffect;
	}

	public int getEnemyDungeonLvlEffect() {
		return this.enemyDungeonLvlEffect;
	}

	public void setEnemyDungeonLvlEffect(int enemyDungeonLvlEffect) {
		this.enemyDungeonLvlEffect = enemyDungeonLvlEffect;
	}

	public int getOwnDungeonLvlEffect() {
		return this.ownDungeonLvlEffect;
	}

	public void setOwnDungeonLvlEffect(int ownDungeonLvlEffect) {
		this.ownDungeonLvlEffect = ownDungeonLvlEffect;
	}

	public int getEnemyMagicLabLvlEffect() {
		return this.enemyMagicLabLvlEffect;
	}

	public void setEnemyMagicLabLvlEffect(int enemyMagicLabLvlEffect) {
		this.enemyMagicLabLvlEffect = enemyMagicLabLvlEffect;
	}

	public int getOwnMagicLabLvlEffect() {
		return this.ownMagicLabLvlEffect;
	}

	public void setOwnMagicLabLvlEffect(int ownMagicLabLvlEffect) {
		this.ownMagicLabLvlEffect = ownMagicLabLvlEffect;
	}

	public int getEnemyMonsterEffect() {
		return this.enemyMonsterEffect;
	}

	public void setEnemyMonsterEffect(int enemyMonsterEffect) {
		this.enemyMonsterEffect = enemyMonsterEffect;
	}

	public int getOwnMonsterEffect() {
		return this.ownMonsterEffect;
	}

	public void setOwnMonsterEffect(int ownMonsterEffect) {
		this.ownMonsterEffect = ownMonsterEffect;
	}

	public int getEnemyCrystalEffect() {
		return this.enemyCrystalEffect;
	}

	public void setEnemyCrystalEffect(int enemyCrystalEffect) {
		this.enemyCrystalEffect = enemyCrystalEffect;
	}

	public int getOwnCrystalEffect() {
		return this.ownCrystalEffect;
	}

	public void setOwnCrystalEffect(int ownCrystalEffect) {
		this.ownCrystalEffect = ownCrystalEffect;
	}

	public int getEnemyBrickEffect() {
		return this.enemyBrickEffect;
	}

	public void setEnemyBrickEffect(int enemyBrickEffect) {
		this.enemyBrickEffect = enemyBrickEffect;
	}

	public int getOwnBrickEffect() {
		return this.ownBrickEffect;
	}

	public void setOwnBrickEffect(int ownBrickEffect) {
		this.ownBrickEffect = ownBrickEffect;
	}

	public int getAmountCardDraw() {
		return this.amountCardDraw;
	}

	public void setAmountCardDraw(int amountCardDraw) {
		this.amountCardDraw = amountCardDraw;
	}

	public int getAmountCardDiscard() {
		return this.amountCardDiscard;
	}

	public void setAmountCarddiscard(int amountCarddiscard) {
		this.amountCardDiscard = amountCarddiscard;
	}

	public boolean getPlayCards() {
		return this.playCards;
	}

	public void setPlayCards(boolean playCards) {
		this.playCards = playCards;
	}

	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	

}
