package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;

public class NetworkGameServerImpl extends UnicastRemoteObject implements GameServer, Remote {

	private static final long serialVersionUID = 1L;
	private UserInterface userInterface;
	private GameService gameService;

	public NetworkGameServerImpl(GameService gameService, String ipAddress) throws RemoteException {
		this.gameService = gameService;
		
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		} catch (RemoteException e) {
			e.getLocalizedMessage();
		}
		
		try {
			//TODO: Muss wirklich das Binding auf NetworkGameServerImpl lauten, oder auf GameServer? (Sebastian)
			Naming.rebind("//" + ipAddress + "/NetworkGameServerImpl" , this);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}
	
	@Override
	public synchronized void register(UserInterface userInterface) {
		if (userInterface != null) {
			this.userInterface = userInterface;
		}

	}

	@Override
	public void unregister(UserInterface userInterface) {
		if (userInterface != null) {
			this.userInterface = null;
		}

	}

	@Override
	public void start(GameType gameType) throws RemoteException {
			this.gameService.start(gameType);
	}

	@Override
	public void stop() throws RemoteException {
		this.gameService.stop();
		this.gameService = null;
	}

	@Override
	public void playCard(Card card) throws RemoteException {
		this.gameService.playCard(null, card);
	}

	@Override
	public void discardCard(Card card) throws RemoteException {
		this.gameService.discardCard(null, card);
	}

	@Override
	public Collection<Card> getAllPossibleCards() throws RemoteException {
		return this.gameService.getAllPossibleCards();
	}
}
