package herbstJennrichLehmannRitter.server.impl;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

public class NetworkClient implements GameServer {
	
	private GameService gameService;

	public NetworkClient(String ipAddress) {
		try {
			Registry registry = LocateRegistry.getRegistry(ipAddress, Registry.REGISTRY_PORT);
			this.gameService = (GameService) registry.lookup("GameService");
		} catch (RemoteException e) {
			e.getLocalizedMessage();
		} catch (NotBoundException e) {
			e.getLocalizedMessage();
		}
			
	}

	@Override
	public void register(UserInterface userInterface) {
		this.gameService.register(Thread.currentThread(), userInterface);

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
	}

	@Override
	public void playCard(Card card) {
		this.gameService.playCard(null, card);
	}

	@Override
	public void discardCard(Card card) {
		this.gameService.discardCard(null, card);
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.gameService.getAllPossibleCards();
	}
}
