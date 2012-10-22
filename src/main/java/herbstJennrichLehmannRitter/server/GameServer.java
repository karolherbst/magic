package herbstJennrichLehmannRitter.server;

import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.ui.UserInterface;

/**
 * 
 * Interface für die Schnittstelle zum GameClient
 *
 */
public interface GameServer extends GameService {
	
	public void register(UserInterface userInterface);

	public void unregister(UserInterface userInterface);
	
}
