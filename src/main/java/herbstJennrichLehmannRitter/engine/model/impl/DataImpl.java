package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;

// TODO Muss hier auch Javadoc hin?
public class DataImpl implements Data {

	private Player ownPlayer;
	private Player enemyPlaner;
	
	// TODO wie werden ownPlayer und enemyPlayer gesetzt? 
	
	public Player getOwnPlayer() {
		return this.ownPlayer;
	}

	public Player getEnemyPlayer() {
		return this.enemyPlaner;
	}

}
