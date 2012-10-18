package herbstJennrichLehmannRitter.engine.factory;

import herbstJennrichLehmannRitter.engine.model.Player;

public interface PlayerFactory {
	
	// TODO: which arguments do we need to create players?
	public Player createLocalPlayer();

	public Player createNetworkPlayer();
	
}
