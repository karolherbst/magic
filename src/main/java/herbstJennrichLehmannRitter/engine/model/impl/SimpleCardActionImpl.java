package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.SimpleCardAction;

public class SimpleCardActionImpl implements SimpleCardAction {

	private final int enemyTowerEffect;
	private final int ownTowerEffect;
	private final int enemyWallEffect;
	private final int ownWallEffect;
	private final int enemyMineLvlEffect;
	private final int ownMineLvlEffect;
	private final int enemyDungeonLvlEffect;
	private final int ownDungeonLvlEffect;
	private final int enemyMagicLabLvlEffect;
	private final int ownMagicLabLvlEffect;
	private final int enemyMonsterEffect;
	private final int ownMonsterEffect;
	private final int enemyCrystalEffect;
	private final int ownCrystalEffect;
	private final int enemyBrickEffect;
	private final int ownBrickEffect;
	private final int amountCardDraw;
	private final int amountCardDiscard;
	private final boolean playCards;
	private final int damage;
	
	public SimpleCardActionImpl(int enemyTowerEffect, int ownTowerEffect, int enemyWallEffect, int ownWallEffect,
			int enemyMineLvlEffect, int ownMineLvlEffect, int enemyDungeonLvlEffect, int ownDungeonLvlEffect,
			int enemyMagicLabLvlEffect, int ownMagicLabLvlEffect, int enemyMonsterEffect, int ownMonsterEffect,
			int enemyCrystalEffect, int ownCrystalEffect, int enemyBrickEffect, int ownBrickEffect, int amountCardDraw,
			int amountCardDiscard, boolean playCards, int damage) {
		
		this.enemyTowerEffect = enemyTowerEffect;
		this.ownTowerEffect = ownTowerEffect;
		this.enemyWallEffect = enemyWallEffect;
		this.ownWallEffect = ownWallEffect;
		this.enemyMineLvlEffect = enemyMineLvlEffect;
		this.ownMineLvlEffect = ownMineLvlEffect;
		this.enemyDungeonLvlEffect = enemyDungeonLvlEffect;
		this.ownDungeonLvlEffect = ownDungeonLvlEffect;
		this.enemyMagicLabLvlEffect = enemyMagicLabLvlEffect;
		this.ownMagicLabLvlEffect = ownMagicLabLvlEffect;
		this.enemyMonsterEffect = enemyMonsterEffect;
		this.ownMonsterEffect = ownMonsterEffect;
		this.enemyCrystalEffect = enemyCrystalEffect;
		this.ownCrystalEffect = ownCrystalEffect;
		this.enemyBrickEffect = enemyBrickEffect;
		this.ownBrickEffect = ownBrickEffect;
		this.amountCardDraw = amountCardDraw;
		this.amountCardDiscard = amountCardDiscard;
		this.playCards = playCards;
		this.damage = damage;
	}
	
	@Override
	public int getEnemyTowerEffect() {
		return this.enemyTowerEffect;
	}

	@Override
	public int getOwnTowerEffect() {
		return this.ownTowerEffect;
	}

	@Override
	public int getEnemyWallEffect() {
		return this.enemyWallEffect;
	}

	@Override
	public int getOwnWallEffect() {
		return this.ownWallEffect;
	}

	@Override
	public int getEnemyMineLvlEffect() {
		return this.enemyMineLvlEffect;
	}

	@Override
	public int getOwnMineLvlEffect() {
		return this.ownMineLvlEffect;
	}

	@Override
	public int getEnemyDungeonLvlEffect() {
		return this.enemyDungeonLvlEffect;
	}

	@Override
	public int getOwnDungeonLvlEffect() {
		return this.ownDungeonLvlEffect;
	}

	@Override
	public int getEnemyMagicLabLvlEffect() {
		return this.enemyMagicLabLvlEffect;
	}

	@Override
	public int getOwnMagicLabLvlEffect() {
		return this.ownMagicLabLvlEffect;
	}

	@Override
	public int getEnemyMonsterEffect() {
		return this.enemyMonsterEffect;
	}

	@Override
	public int getOwnMonsterEffect() {
		return this.ownMonsterEffect;
	}

	@Override
	public int getEnemyCrystalEffect() {
		return this.enemyCrystalEffect;
	}

	@Override
	public int getOwnCrystalEffect() {
		return this.ownCrystalEffect;
	}

	@Override
	public int getEnemyBrickEffect() {
		return this.enemyBrickEffect;
	}

	@Override
	public int getOwnBrickEffect() {
		return this.ownBrickEffect;
	}

	@Override
	public int getAmountCardDraw() {
		return this.amountCardDraw;
	}

	@Override
	public int getAmountCardDiscard() {
		return this.amountCardDiscard;
	}

	@Override
	public boolean getPlayCards() {
		return this.playCards;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}
	

}
