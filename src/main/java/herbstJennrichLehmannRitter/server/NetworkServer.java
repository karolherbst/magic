package herbstJennrichLehmannRitter.server;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.RMIUsertInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

/**	Description of NetworkServer Class
 *  This Class extends the Remote Interface and works as interface for the Network Server
 */

public interface NetworkServer extends Remote {
	
	public void register(RMIUsertInterface userInterface) throws RemoteException;
	public void unregister(RMIUsertInterface userInterface) throws RemoteException;
	public void start(GameType gameType) throws RemoteException;
	public void stop() throws RemoteException;
	public void playCard(Card card) throws RemoteException;
	public void discardCard(Card card) throws RemoteException;
	public Collection<Card> getAllPossibleCards() throws RemoteException;
	public GameType getGameType() throws RemoteException;
}
