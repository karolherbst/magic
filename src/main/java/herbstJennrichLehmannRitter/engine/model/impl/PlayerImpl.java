/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

/**
 *
 * Implementation des Spielerobjektes
 * Hält alle relevanten Objekte des Spielers
 *
 */
public class PlayerImpl implements Player {

	private String name;
	
	private Collection<Card> deck;
	private Collection<Card> handDeck;
	private Collection<Card> cemeteryDeck;
	
	private ResourceBuilding dungeon;
	private ResourceBuilding magicLab;
	private ResourceBuilding mine;

	private DefenceBuilding tower;
	private DefenceBuilding wall;
	
	@Override
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Collection<Card> getDeck() {
		return this.deck;
	}

	public void setDeck(Collection<Card> deck) {
		this.deck = deck;
	}
	
	@Override
	public Collection<Card> getHandDeck() {
		return this.handDeck;
	}

	public void setHandDeck(Collection<Card> handDeck) {
		this.handDeck = handDeck;
	}
	
	public void addCardToHandDeck(Card card) {
		this.handDeck.add(card);
	}
	
	public void removeCardFromHandDeck(Card card) {
		this.handDeck.remove(card);
	}

	@Override
	public Collection<Card> getCemeteryDeck() {
		return this.cemeteryDeck;
	}

	public void setCemeteryDeck(Collection<Card> cemeteryDeck) {
		this.cemeteryDeck = cemeteryDeck;
	}
	
	public void addCardToCemeteryDeck(Card card) {
		this.cemeteryDeck.add(card);
	}
	
	public void removeCardFromCemerteryDeck(Card card) {
		this.cemeteryDeck.remove(card);
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
	
	public void setMagiclab(ResourceBuilding magiclab) {
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

}
