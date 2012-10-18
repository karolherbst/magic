package herbstJennrichLehmannRitter.engine.factory;

import herbstJennrichLehmannRitter.engine.model.Player;

/**
 * 
 * Interface für die Erstellung von Spielerobjekten
 * 
 */
public interface PlayerFactory {
	
	// TODO: which arguments do we need to create players?
	public Player createLocalPlayer();

	public Player createNetworkPlayer();
	
}
