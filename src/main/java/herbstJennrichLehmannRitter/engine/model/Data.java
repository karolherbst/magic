package herbstJennrichLehmannRitter.engine.model;

import java.io.Serializable;

/**	Description of Data Class
 * Interface where the data of both players are deposited
 */
 
public interface Data extends Serializable {

	public Player getOwnPlayer();
	public Player getEnemyPlayer();
	
}
