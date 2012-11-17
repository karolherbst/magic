package herbstJennrichLehmannRitter.engine.model;

import java.io.Serializable;

/**
 * 
 * Interface, wo die Daten der beiden Spielteilnehmern hinterlegt sind.
 *
 */
public interface Data extends Serializable {

	public Player getOwnPlayer();
	public Player getEnemyPlayer();
	
}
