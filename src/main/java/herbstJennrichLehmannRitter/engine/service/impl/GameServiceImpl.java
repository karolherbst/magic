package herbstJennrichLehmannRitter.engine.service.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException.ENGINE_ERROR;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class GameServiceImpl implements GameService {

	private class UIHolder {
		
		public UIHolder(UserInterface userInterface) {
			this.userInterface = userInterface;
		}
		
		private final UserInterface userInterface;
		private Player player;
		private UIHolder enemy;
	}
	
	private Map<Thread, UIHolder> threadToUi = new HashMap<Thread, GameServiceImpl.UIHolder>();
	
	private final GameEngineController gameEngineController;
	
	public GameServiceImpl(GameEngineController gameEngineController) {
		this.gameEngineController = gameEngineController;
	}
	
	@Override
	public void start(GameType gameType) {
		if (this.threadToUi.size() < 2) {
			throw new GameEngineException(ENGINE_ERROR.NOT_2_PLAYERS_AVAILABLE);
		}
		
		this.gameEngineController.start(gameType);
		
		this.threadToUi.values().iterator().next().userInterface.nextTurn();
	}
	
	@Override
	public void stop() {
		this.gameEngineController.stop();
		for (UIHolder uiHolder : this.threadToUi.values()) {
			uiHolder.userInterface.abort("Das Spiel wurde gestoppt");
		}
	}
	
	private Player createPlayer(String name, Collection<String> cardNames) {
		return this.gameEngineController.createPlayer(name, cardNames);
	}
	
	private void updatePlayerDatas(UIHolder uiHolder) {
		Data ownData = this.gameEngineController.createDataForPlayer(uiHolder.player, uiHolder.enemy.player);
		System.out.println("new data for player " + uiHolder.player.getName() + ":\n" + ownData);
		uiHolder.userInterface.setData(ownData);
		
		Data enemyData = this.gameEngineController.createDataForPlayer( uiHolder.enemy.player, uiHolder.player);
		System.out.println("new data for player " + uiHolder.enemy.player.getName() + ":\n" + enemyData);
		uiHolder.enemy.userInterface.setData(enemyData);
	}
	
	@Override
	public synchronized void register(Thread thread, UserInterface userInterface) {

		final UIHolder newUIHolder = new UIHolder(userInterface);

		if (this.threadToUi.size() == 0) {
			newUIHolder.player = createPlayer(userInterface.getName(), userInterface.getCards());
			this.threadToUi.put(thread, newUIHolder);
			return;
		}
		
		if (this.threadToUi.size() == 1) {
			newUIHolder.player = createPlayer(userInterface.getName(), userInterface.getCards());
			
			for (UIHolder uiHolder : this.threadToUi.values()) {
				// connect players
				if (uiHolder != newUIHolder) {
					newUIHolder.enemy = uiHolder;
					uiHolder.enemy = newUIHolder;
				}
			}
			
			this.threadToUi.put(thread, newUIHolder);
			
			updatePlayerDatas(newUIHolder);
			
			newUIHolder.userInterface.twoPlayerFound();
			newUIHolder.enemy.userInterface.twoPlayerFound();
			
			return;
		}
		
		if (this.threadToUi.size() > 2) {
			throw new IllegalArgumentException("there are already 2 players registered");
		}
		throw new IllegalStateException("this should never happen!");
	}
	
	@Override
	public synchronized void unregister(UserInterface userInterface) {
		for (UIHolder uiHolder : this.threadToUi.values()) {
			if (uiHolder.userInterface == userInterface) {
				
				if (uiHolder.enemy != null && uiHolder.enemy.userInterface != null) {
					UserInterface userInterface2 = uiHolder.enemy.userInterface;
					userInterface2.abort("Player " + uiHolder.player.getName() + " left the game");
				}
				
				this.threadToUi = new HashMap<Thread, GameServiceImpl.UIHolder>();
			}
		}
	}

	// for debugging
	static int round = 0;
	@Override
	public void playCard(Thread thread, Card card) {
		System.out.println("round: " + ++round);
		// sleep a bit to take away stress from the process
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// do nothing here
		}
		
		UIHolder uiHolder = this.threadToUi.get(thread);
		System.out.println("service: player " + uiHolder.player.getName() + " played card " + card.getName());
		
		this.gameEngineController.playCard(card, uiHolder.player, uiHolder.enemy.player);
		uiHolder.enemy.userInterface.enemeyPlayedCard(card);
		
		updatePlayerDatas(uiHolder);
		if (this.gameEngineController.canPlayerPlayAnotherRound(card, uiHolder.player)) {
			uiHolder.userInterface.playAnotherCard();
		} else {
			uiHolder.enemy.userInterface.nextTurn();
		}
		
	}

	@Override
	public void discardCard(Thread thread, Card card) {
		System.out.println("round: " + ++round);
		// sleep a bit to take away stress from the process
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// do nothing here
		}
				
		UIHolder uiHolder = this.threadToUi.get(thread);
		System.out.println("service: player " + uiHolder.player.getName() + " discard card " + card.getName());
		
		this.gameEngineController.discardCard(card, uiHolder.player);

		updatePlayerDatas(uiHolder);
		uiHolder.enemy.userInterface.nextTurn();
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.gameEngineController.getGameCardFactory().getAllPossibleCards();
	}
}
