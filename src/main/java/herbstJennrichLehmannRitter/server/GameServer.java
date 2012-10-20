package herbstJennrichLehmannRitter.server;

import java.rmi.RemoteException;

import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.ui.UserInterface;

/**
 * 
 * Interface für die Schnittstelle zum GameClient
 *
 */
public interface GameServer extends GameService {
	
	public void register(UserInterface userInterface) throws RemoteException;

	public void unregister(UserInterface userInterface) throws RemoteException;
	
}
