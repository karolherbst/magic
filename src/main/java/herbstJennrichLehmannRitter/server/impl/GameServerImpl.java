package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

public class GameServerImpl implements GameServer {

	private UserInterface userInterface1 = null;
	private UserInterface userInterface2 = null;
	
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
	public void register(UserInterface userInterface) {
		if (userInterface == null) {
			// TODO: is this possible?
		}
		
		if (this.userInterface1 == null) {
			System.out.println("engine: " + userInterface + " has been registered as Player1");
			this.userInterface1 = userInterface;
		} else if (this.userInterface2 == null) {
			System.out.println("engine: " + userInterface + " has been registered as Player2");
			this.userInterface2 = userInterface;
		}
	}

	@Override
	public void unregister(UserInterface userInterface) {
		if (userInterface == null) {
			// TODO: what do we have to do here?
		}
		
		if (this.userInterface1 == userInterface) {
			System.out.println("engine: Player1 unregistered!");

			if (this.userInterface2 != null) {
				this.userInterface1.youLost();
				this.userInterface2.youWon();
			}
			
		} else if (this.userInterface2 == userInterface) {
			System.out.println("engine: Player2 unregistered!");

			if (this.userInterface1 != null) {
				this.userInterface2.youLost();
				this.userInterface1.youWon();
			}
		}
		this.userInterface1 = null;
		this.userInterface2 = null;
	}
	
}
