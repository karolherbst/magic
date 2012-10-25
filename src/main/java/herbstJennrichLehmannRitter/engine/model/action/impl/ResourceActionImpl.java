package herbstJennrichLehmannRitter.engine.model.action.impl;

import static herbstJennrichLehmannRitter.engine.enums.BuildingType.DUNGEON;
import static herbstJennrichLehmannRitter.engine.enums.BuildingType.MAGIC_LAB;
import static herbstJennrichLehmannRitter.engine.enums.BuildingType.MINE;
import static herbstJennrichLehmannRitter.engine.enums.BuildingType.TOWER;
import static herbstJennrichLehmannRitter.engine.enums.BuildingType.WALL;
import static herbstJennrichLehmannRitter.engine.enums.RessourceType.BRICK;
import static herbstJennrichLehmannRitter.engine.enums.RessourceType.CRYSTAL;
import static herbstJennrichLehmannRitter.engine.enums.RessourceType.MONSTER;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;

public class ResourceActionImpl implements ResourceAction {

	private final int towerEffect;
	private final int wallEffect;
	private final int mineLvlEffect;
	private final int dungeonLvlEffect;
	private final int magicLabLvlEffect;
	private final int monsterEffect;
	private final int crystalEffect;
	private final int brickEffect;
	private final int damage;
	
	public ResourceActionImpl(ResourceAction simpleCardAction) {
		if (simpleCardAction == null) {
			this.towerEffect = 0;
			this.wallEffect = 0;
			this.mineLvlEffect = 0;
			this.dungeonLvlEffect = 0;
			this.magicLabLvlEffect = 0;
			this.monsterEffect = 0;
			this.crystalEffect = 0;
			this.brickEffect = 0;
			this.damage = 0;
		} else {
			this.towerEffect = simpleCardAction.getTowerEffect();
			this.wallEffect = simpleCardAction.getWallEffect();
			this.mineLvlEffect = simpleCardAction.getMineLvlEffect();
			this.dungeonLvlEffect = simpleCardAction.getDungeonLvlEffect();
			this.magicLabLvlEffect = simpleCardAction.getMagicLabLvlEffect();
			this.monsterEffect = simpleCardAction.getMonsterEffect();
			this.crystalEffect = simpleCardAction.getCrystalEffect();
			this.brickEffect = simpleCardAction.getBrickEffect();
			this.damage = simpleCardAction.getDamage();
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
	
	@Override
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		
		MagicUtils.addValueToStringBuilder(WALL, Integer.valueOf(getWallEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(TOWER, Integer.valueOf(getTowerEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(MINE, Integer.valueOf(getMineLvlEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(DUNGEON, Integer.valueOf(getDungeonLvlEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(MAGIC_LAB, Integer.valueOf(getMagicLabLvlEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(BRICK, Integer.valueOf(getBrickEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(MONSTER, Integer.valueOf(getMonsterEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder(CRYSTAL, Integer.valueOf(getCrystalEffect()), stringBuilder, true);
		MagicUtils.addValueToStringBuilder("Schaden", Integer.valueOf(getDamage()), stringBuilder, true);
		
		return stringBuilder.toString();
	}
}
