package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.NetworkServer;
import herbstJennrichLehmannRitter.ui.RMIUsertInterface;
import herbstJennrichLehmannRitter.ui.impl.RMIUserInterfaceWrapper;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

/**	Description of NetworkServerImpl Class
 *  This Class implements the GameServer Interface and saves the necessary network data
 */

public class NetworkServerImpl extends UnicastRemoteObject implements NetworkServer {

	private static final long serialVersionUID = -5758886288940510467L;
	private GameServer gameServer;
	
	public NetworkServerImpl(GameServer gameServer) throws RemoteException {
		this.gameServer = gameServer;
	}

	@Override
	public void register(RMIUsertInterface userInterface) throws RemoteException {
		this.gameServer.register(new RMIUserInterfaceWrapper(userInterface));
	}

	@Override
	public void unregister() throws RemoteException {
		this.gameServer.unregister();
	}

	@Override
	public void start(GameType gameType) throws RemoteException {
		this.gameServer.start(gameType);
	}

	@Override
	public void stop() throws RemoteException {
		this.gameServer.stop();
	}

	@Override
	public void playCard(Card card) throws RemoteException {
		this.gameServer.playCard(card);
	}

	@Override
	public void discardCard(Card card) throws RemoteException {
		this.gameServer.discardCard(card);
	}

	@Override
	public Collection<Card> getAllPossibleCards() throws RemoteException {
		return this.gameServer.getAllPossibleCards();
	}
	
	@Override
	public GameType getGameType() throws RemoteException {
		return this.gameServer.getGameType();
	}

}
