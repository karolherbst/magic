package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

public class NetworkServerImpl extends UnicastRemoteObject implements GameServer {

//	private static final long serialVersionUID = -5758886288940510467L;
	
	private static final long serialVersionUID = 1L;
	private GameServer gameServer;
	
	public NetworkServerImpl(GameServer gameServer) throws RemoteException {
		this.gameServer = gameServer;
	}

	@Override
	public void register(UserInterface userInterface) throws RemoteException {
		this.gameServer.register(userInterface);
	}

	@Override
	public void unregister(UserInterface userInterface) throws RemoteException {
		this.gameServer.unregister(userInterface);
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

}
