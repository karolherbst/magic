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

	private Player ownPlayer = null;
	private Player enemyPlayer = null;
	
	public DataImpl(Player own, Player enemy) {
		this.ownPlayer = own;
		this.enemyPlayer = enemy;
	}
	
	@Override
	public Player getOwnPlayer() {
		return this.ownPlayer;
	}
	
	public void setOwnPlayer(Player ownPlayer) {
		this.ownPlayer = ownPlayer;
	}

	@Override
	public Player getEnemyPlayer() {
		return this.enemyPlayer;
	}

	public void setEnemyPlayer(Player enemyPlayer) {
		this.enemyPlayer = enemyPlayer;
	}
	
	@Override
	public String toString() {
		return "Data{" + this.ownPlayer + '\n' + this.enemyPlayer + '}';
	}

}
