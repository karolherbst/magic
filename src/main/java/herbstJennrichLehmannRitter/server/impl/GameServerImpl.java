package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;

public class GameServerImpl implements GameServer {

	private GameService gameService;
	
	public GameServerImpl(GameService gameService) {
		this.gameService = gameService;
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
		this.gameService.register(Thread.currentThread(), userInterface);
	}

	@Override
	public void unregister(UserInterface userInterface) {
		this.gameService.unregister(userInterface);
	}
	
}
