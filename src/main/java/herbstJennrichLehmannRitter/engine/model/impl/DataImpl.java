package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;

/** Description of DataImpl Class
 *  This Class implements the Data Interface.
 *  The playerobjects are saved in this class and are used by the GameClients to call both PlayerObjects.
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
