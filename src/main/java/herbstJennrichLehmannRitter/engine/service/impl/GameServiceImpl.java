package herbstJennrichLehmannRitter.engine.service.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;

public class GameServiceImpl implements GameService {

	private final GameEngineController gameEngineController;
	
	public GameServiceImpl(GameEngineController gameEngineController) {
		this.gameEngineController = gameEngineController;
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub

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
	public void getAllPossibleCards() {
		// TODO Auto-generated method stub

	}

}
