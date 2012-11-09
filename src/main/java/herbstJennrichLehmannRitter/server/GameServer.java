package herbstJennrichLehmannRitter.server;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**
 * 
 * Interface für die Schnittstelle zum GameClient
 *
 */
public interface GameServer extends Remote {
	
	public void register(UserInterface userInterface) throws RemoteException;
	public void unregister(UserInterface userInterface) throws RemoteException;
	
	public void start(GameType gameType) throws RemoteException;
	public void stop() throws RemoteException;
	
	public void playCard(Card card) throws RemoteException;
	public void discardCard(Card card) throws RemoteException;
	
	public Collection<Card> getAllPossibleCards() throws RemoteException;
}
