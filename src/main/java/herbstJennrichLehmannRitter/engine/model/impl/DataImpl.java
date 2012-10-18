package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;

/**
 * Implementation von Data.<br />
 * Die Spielerobjekte werden in dieser Klasse gespeichert und 
 * von den GameClients ({@link herbstJennrichLehmannRitter.client.GameClient}) genutzt, um die 
 * beiden Spielerobjekte abzurufen.
 *
 */
public class DataImpl implements Data {

	private Player ownPlayer;
	private Player enemyPlaner;
	
	// TODO wie und wo werden ownPlayer und enemyPlayer eigentlich gesetzt? 
	
	public Player getOwnPlayer() {
		return this.ownPlayer;
	}

	public Player getEnemyPlayer() {
		return this.enemyPlaner;
	}

}
