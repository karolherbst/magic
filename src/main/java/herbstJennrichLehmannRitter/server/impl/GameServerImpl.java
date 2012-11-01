package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameServerImpl implements GameServer {

	private UserInterface userInterface1 = null;
	private UserInterface userInterface2 = null;
	
	private volatile Map<Thread, UserInterface> uiFromThread = new HashMap<Thread, UserInterface>();
	private volatile Map<UserInterface, Player> playerFromUI = new HashMap<UserInterface, Player>();
	
	private final GameService gameService;
	
	public GameServerImpl(GameService gameService) {
		this.gameService = gameService;
	}

	@Override
	public void start(GameType gameType) {
		this.gameService.start(gameType);
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
