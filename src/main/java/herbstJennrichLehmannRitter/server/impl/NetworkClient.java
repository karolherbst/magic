package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

public class NetworkClient implements GameServer {
	
	private GameService remoteGameService;

	public NetworkClient(String ipAddress) {
		try {
			Registry registry = LocateRegistry.getRegistry(ipAddress, Registry.REGISTRY_PORT);
			this.remoteGameService = (GameService) registry.lookup("GameService");
		} catch (RemoteException e) {
			e.getLocalizedMessage();
		} catch (NotBoundException e) {
			e.getLocalizedMessage();
		}
			
	}
	
	public GameService getRemoteGameService() {
		return this.remoteGameService;
	}

	@Override
	public void register(UserInterface userInterface) {
		this.remoteGameService.register(Thread.currentThread(), userInterface);
	}

	@Override
	public void unregister(UserInterface userInterface) {
		this.remoteGameService.unregister(userInterface);
	}

	@Override
	public void start(GameType gameType) {
		this.remoteGameService.start(gameType);
	}

	@Override
	public void stop() {
		this.remoteGameService.stop();
	}

	@Override
	public void playCard(Card card) {
		this.remoteGameService.playCard(null, card);
	}

	@Override
	public void discardCard(Card card) {
		this.remoteGameService.discardCard(null, card);
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.remoteGameService.getAllPossibleCards();
	}
}
