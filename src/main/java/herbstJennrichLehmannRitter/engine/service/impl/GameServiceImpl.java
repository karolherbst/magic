package herbstJennrichLehmannRitter.engine.service.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;

import java.util.Collection;

public class GameServiceImpl implements GameService {

	private final GameEngineController gameEngineController;
	
	public GameServiceImpl(GameEngineController gameEngineController) {
		this.gameEngineController = gameEngineController;
	}
	
	@Override
	public void start(GameType gameType) {
		this.gameEngineController.start(gameType);
	}

	@Override
	public void playCard(Player player, Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void discardCard(Player player, Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.gameEngineController.getGameCardFactory().getAllPossibleCards();
	}

	@Override
	public Player createPlayer(String name, Collection<String> cardNames) {
		// TODO Auto-generated method stub
		return null;
	}
}
