package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class GameServerImpl implements GameServer {

	private List<UserInterface> userInterfaces = new ArrayList<UserInterface>();
	
	private final GameService gameService;
	
	public GameServerImpl(GameService gameService) {
		this.gameService = gameService;
	}

	@Override
	public void start() {
		this.gameService.start();
	}

	@Override
	public void playCard(Player player, Card card) {
		this.gameService.playCard(player, card);
	}

	@Override
	public void discardCard(Player player, Card card) {
		this.gameService.discardCard(player,card);
	}

	@Override
	public void getAllPossibleCards() {
		this.gameService.getAllPossibleCards();
	}

	@Override
	public synchronized void register(UserInterface userInterface) {
		if( userInterface != null ) {
			this.userInterfaces.add(userInterface);
		}
	}

	@Override
	public void unregister(UserInterface userInterface) {
		if( userInterface != null) {
			this.userInterfaces.remove(userInterface);
		}
	}
	
}
