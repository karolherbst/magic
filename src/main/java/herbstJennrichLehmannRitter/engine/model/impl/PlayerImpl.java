/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Deck;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

/**	Description ofPlayerImpl Class
 *  This Class implements the Player Interface and implements the dungeon.
 *	Saves name and information about the player.
 */

public class PlayerImpl implements Player {

	private String name;
	
	private Deck deck = null;
	
	private ResourceBuilding dungeon = new DungeonImpl();
	private ResourceBuilding magicLab = new MagicLabImpl();
	private ResourceBuilding mine = new MineImpl();

	private DefenceBuilding tower = new TowerImpl();
	private DefenceBuilding wall = new WallImpl();
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Deck getDeck() {
		return this.deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}
		
	@Override
	public ResourceBuilding getDungeon() {
		return this.dungeon;
	}

	public void setDungeon(ResourceBuilding dungeon) {
		this.dungeon = dungeon;
	}
	
	@Override
	public ResourceBuilding getMagicLab() {
		return this.magicLab;
	}
	
	public void setMagicLab(ResourceBuilding magiclab) {
		this.magicLab = magiclab;
	}	

	@Override
	public ResourceBuilding getMine() {
		return this.mine;
	}
	
	public void setMine(ResourceBuilding mine) {
		this.mine = mine;
	}

	@Override
	public DefenceBuilding getTower() {
		return this.tower;
	}

	public void setTower(DefenceBuilding tower) {
		this.tower = tower;
	}

	@Override
	public DefenceBuilding getWall() {
		return this.wall;
	}
	
	public void setWall(DefenceBuilding wall) {
		this.wall = wall;
	}
	
	@Override
	public String toString() {
		return "Player[name:" + getName()
				+ " tower:" + getTower().getActualPoints()
				+ " wall:" + getWall().getActualPoints()
				+ " mine:{lvl:" + getMine().getLevel() + " stock:" + getMine().getStock() + '}'
				+ " magicLab:{lvl:" + getMagicLab().getLevel() + " stock:" + getMagicLab().getStock() + '}'
				+ " dungeon:{lvl:" + getDungeon().getLevel() + " stock:" + getDungeon().getStock() + '}'
				+ ']';
	}

}
