package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.NetworkServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.RemoteException;
import java.util.Collection;

/**	Description of NetworkServerWrapper Class
 *  This Class implements the GameServer Interface and wraps the necessary network data
 */

public class NetworkServerWrapper implements GameServer {

	private final NetworkServer networkServer;
	
	public NetworkServerWrapper(NetworkServer networkServer) {
		this.networkServer = networkServer;
	}
	
	@Override
	public void register(UserInterface userInterface) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void unregister() throws RemoteException {
		this.networkServer.unregister();
	}

	@Override
	public void start(GameType gameType) throws RemoteException {
		this.networkServer.start(gameType);
	}

	@Override
	public void stop() throws RemoteException {
		this.networkServer.stop();
	}

	@Override
	public void playCard(Card card) throws RemoteException {
		this.networkServer.playCard(card);
	}

	@Override
	public void discardCard(Card card) throws RemoteException {
		this.networkServer.discardCard(card);
	}

	@Override
	public Collection<Card> getAllPossibleCards() throws RemoteException {
		return this.networkServer.getAllPossibleCards();
	}

	@Override
	public GameType getGameType() throws RemoteException {
		return this.networkServer.getGameType();
	}

}
