package herbstJennrichLehmannRitter.engine.model.xml;

import javax.xml.bind.annotation.XmlElement;

import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;

public class XmlResourceAction implements ResourceAction {

	private int towerEffect;
	private int wallEffect;
	private int mineLvlEffect;
	private int dungeonLvlEffect;
	private int magicLabLvlEffect;
	private int monsterEffect;
	private int crystalEffect;
	private int brickEffect;
	private int damage;
	
	@XmlElement(name="TowerEffect")
	@Override
	public int getTowerEffect() {
		return this.towerEffect;
	}

	public void setTowerEffect(int towerEffect) {
		this.towerEffect = towerEffect;
	}

	@XmlElement(name="WallEffect")
	@Override
	public int getWallEffect() {
		return this.wallEffect;
	}

	public void setWallEffect(int wallEffect) {
		this.wallEffect = wallEffect;
	}

	@XmlElement(name="MineEffect")
	@Override
	public int getMineLvlEffect() {
		return this.mineLvlEffect;
	}

	public void setMineLvlEffect(int mineLvlEffect) {
		this.mineLvlEffect = mineLvlEffect;
	}

	@XmlElement(name="DungeonEffect")
	@Override
	public int getDungeonLvlEffect() {
		return this.dungeonLvlEffect;
	}

	public void setDungeonLvlEffect(int dungeonLvlEffect) {
		this.dungeonLvlEffect = dungeonLvlEffect;
	}

	@XmlElement(name="MagicLabEffect")
	@Override
	public int getMagicLabLvlEffect() {
		return this.magicLabLvlEffect;
	}

	public void setMagicLabLvlEffect(int magicLabLvlEffect) {
		this.magicLabLvlEffect = magicLabLvlEffect;
	}

	@XmlElement(name="MonsterEffect")
	@Override
	public int getMonsterEffect() {
		return this.monsterEffect;
	}

	public void setMonsterEffect(int monsterEffect) {
		this.monsterEffect = monsterEffect;
	}

	@XmlElement(name="CrystalEffect")
	@Override
	public int getCrystalEffect() {
		return this.crystalEffect;
	}

	public void setCrystalEffect(int crystalEffect) {
		this.crystalEffect = crystalEffect;
	}

	@XmlElement(name="BrickEffect")
	@Override
	public int getBrickEffect() {
		return this.brickEffect;
	}

	public void setBrickEffect(int brickEffect) {
		this.brickEffect = brickEffect;
	}
	
	@XmlElement(name="Damage")
	@Override
	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
}
