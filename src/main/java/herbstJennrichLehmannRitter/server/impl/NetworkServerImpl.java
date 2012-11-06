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

public class NetworkServerImpl extends UnicastRemoteObject implements GameServer, Remote {

	private static final long serialVersionUID = 1L;
	private GameService gameService;

	public NetworkServerImpl(GameService gameService) throws RemoteException {
		this.gameService = gameService;
		
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		} catch (RemoteException e) {
			e.getLocalizedMessage();
		}
		
		try {
			Naming.rebind("GameService", this);
		} catch (Exception e) {
			e.getLocalizedMessage();
		}
	}

	@Override
	public boolean register(UserInterface userInterface) {
		return this.gameService.register(Thread.currentThread(), userInterface);
	}

	@Override
	public void unregister(UserInterface userInterface) {
		this.gameService.unregister(userInterface);
	}

	@Override
	public void start(GameType gameType) {
		this.gameService.start(gameType);
	}

	@Override
	public void stop() {
		this.gameService.stop();
		this.gameService = null;
	}

	@Override
	public void playCard(Card card) {
		//TODO: We have to include the Player object here
		this.gameService.playCard(null, card);

	}

	@Override
	public void discardCard(Card card) {
		//TODO: We have to include the Player object here
		this.gameService.discardCard(null, card);
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.gameService.getAllPossibleCards();
	}

}
