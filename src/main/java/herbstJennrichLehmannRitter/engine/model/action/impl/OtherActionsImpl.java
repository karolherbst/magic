package herbstJennrichLehmannRitter.engine.model.action.impl;

import herbstJennrichLehmannRitter.engine.model.action.OtherActions;

public class OtherActionsImpl implements OtherActions {

	private final int towerEffect;
	private final int wallEffect;
	private final int mineLvlEffect;
	private final int dungeonLvlEffect;
	private final int magicLabLvlEffect;
	private final int monsterEffect;
	private final int crystalEffect;
	private final int brickEffect;
	
	public OtherActionsImpl(OtherActions simpleCardAction) {
		if (simpleCardAction == null) {
			this.towerEffect = 0;
			this.wallEffect = 0;
			this.mineLvlEffect = 0;
			this.dungeonLvlEffect = 0;
			this.magicLabLvlEffect = 0;
			this.monsterEffect = 0;
			this.crystalEffect = 0;
			this.brickEffect = 0;
		} else {
			this.towerEffect = simpleCardAction.getTowerEffect();
			this.wallEffect = simpleCardAction.getWallEffect();
			this.mineLvlEffect = simpleCardAction.getMineLvlEffect();
			this.dungeonLvlEffect = simpleCardAction.getDungeonLvlEffect();
			this.magicLabLvlEffect = simpleCardAction.getMagicLabLvlEffect();
			this.monsterEffect = simpleCardAction.getMonsterEffect();
			this.crystalEffect = simpleCardAction.getCrystalEffect();
			this.brickEffect = simpleCardAction.getBrickEffect();
		}
	}
	
	@Override
	public int getTowerEffect() {
		return this.towerEffect;
	}

	@Override
	public int getWallEffect() {
		return this.wallEffect;
	}

	@Override
	public int getMineLvlEffect() {
		return this.mineLvlEffect;
	}

	@Override
	public int getDungeonLvlEffect() {
		return this.dungeonLvlEffect;
	}

	@Override
	public int getMagicLabLvlEffect() {
		return this.magicLabLvlEffect;
	}

	@Override
	public int getMonsterEffect() {
		return this.monsterEffect;
	}

	@Override
	public int getCrystalEffect() {
		return this.crystalEffect;
	}

	@Override
	public int getBrickEffect() {
		return this.brickEffect;
	}
}
