package herbstJennrichLehmannRitter.server;

import herbstJennrichLehmannRitter.engine.service.GameService;

public interface GameServer extends GameService {
	
	public void register();

	public void unregister();
	
}
