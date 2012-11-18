package herbstJennrichLehmannRitter.engine.service.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException.ENGINE_ERROR;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**	Description of GameServiceImpl Class
 *  This Class implements the GameService Interface and creates the ui, the player and the game engine.
 */

public class GameServiceImpl implements GameService {

	private class UIHolder {
		
		public UIHolder(UserInterface userInterface) {
			this.userInterface = userInterface;
		}
		
		private final UserInterface userInterface;
		private Player player;
		private UIHolder enemy;
	}
	
	private Map<Thread, UIHolder> threadToUi = new HashMap<Thread, GameServiceImpl.UIHolder>(2, 1);
	private int round;
	
	private final GameEngineController gameEngineController;
	
	public GameServiceImpl(GameEngineController gameEngineController) {
		this.gameEngineController = gameEngineController;
	}
	
	private void abort (Throwable t) {
		this.gameEngineController.stop();
		for (UIHolder uiHolder : this.threadToUi.values()) {
			uiHolder.userInterface.abort(t.getLocalizedMessage());
		}
	}
	
	@Override
	public void start(GameType gameType) {
		try {
			if (this.gameEngineController.isRunning()) {
				return;
			}
			
			if (this.threadToUi.size() < 2) {
				throw new GameEngineException(ENGINE_ERROR.NOT_2_PLAYERS_AVAILABLE);
			}
			
			this.gameEngineController.start(gameType);
			this.round = 0;
			UIHolder uiHolder = this.threadToUi.values().iterator().next();
			uiHolder.userInterface.nextTurn();
		} catch (Throwable t) {
			abort(t);
		}
	}
	
	@Override
	public synchronized void stop() {
		try {
			this.gameEngineController.stop();
			for (UIHolder uiHolder : this.threadToUi.values()) {
				uiHolder.userInterface.abort("Das Spiel wurde gestoppt");
			}
		} catch (Throwable t) {
			abort(t);
		}
	}
	
	private Player createPlayer(String name, Collection<String> cardNames) {
		return this.gameEngineController.createPlayer(name, cardNames);
	}
	
	private void updatePlayerDatas(UIHolder uiHolder) {
		Data ownData = this.gameEngineController.createDataForPlayer(uiHolder.player, 
				uiHolder.enemy.player);
		System.out.println("new data for player " + uiHolder.player.getName() + ":\n" + ownData);
		uiHolder.userInterface.setData(ownData);
		
		Data enemyData = this.gameEngineController.createDataForPlayer( uiHolder.enemy.player, 
				uiHolder.player);
		System.out.println("new data for player " + uiHolder.enemy.player.getName() + ":\n" + enemyData);
		uiHolder.enemy.userInterface.setData(enemyData);
	}
	
	private boolean hasSomebodyWon(UIHolder uiHolder) {
		if (this.gameEngineController.hasPlayerWon(uiHolder.player, uiHolder.enemy.player)) {
			uiHolder.userInterface.youWon();
			uiHolder.enemy.userInterface.youLost();
			return true;
		}
		
		if (this.gameEngineController.hasPlayerWon(uiHolder.enemy.player, uiHolder.player)) {
			uiHolder.enemy.userInterface.youWon();
			uiHolder.userInterface.youLost();
			return true;
		}
		return false;
	}
	
	@Override
	public synchronized void register(Thread thread, UserInterface userInterface) {
		try {
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
		} catch (Throwable t) {
			abort(t);
		}
	}
	
	@Override
	public synchronized void unregister(Thread thread) {
		try {
			UserInterface value = null;
			Thread key = null;
			for (Map.Entry<Thread, UIHolder> entry : this.threadToUi.entrySet()) {
				
				UIHolder uiHolder = entry.getValue();
				key = entry.getKey();
				
				if (key == thread) {
					
					if (uiHolder.enemy != null && uiHolder.enemy.userInterface != null) {
						uiHolder.enemy.enemy = null;
						UserInterface userInterface2 = uiHolder.enemy.userInterface;
						userInterface2.abort("Player " + uiHolder.player.getName() + " left the game");
					}
					
				}
			}
			this.threadToUi.remove(key);
		} catch (Throwable t) {
			abort(t);
		}
	}

	@Override
	public void playCard(Thread thread, Card card) {
		try {
			++this.round;
			System.out.println("round: " + this.round);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// do nothing here
			}
			
			UIHolder uiHolder = this.threadToUi.get(thread);
			if (uiHolder != null) {
				System.out.println("service: player " + uiHolder.player.getName() + " played card " + 
						card.getName());
				
				this.gameEngineController.playCard(card, uiHolder.player, uiHolder.enemy.player);
				uiHolder.enemy.userInterface.enemyPlayedCard(card);
				
				if (MagicUtils.canPlayerPlayAnotherRound(card, uiHolder.player)) {
					updatePlayerDatas(uiHolder);
					uiHolder.userInterface.playAnotherCard();
				} else {
					if (this.round > 1) {
						this.gameEngineController.addResourcesToPlayer(uiHolder.enemy.player);
					}
					if (!hasSomebodyWon(uiHolder)) {
						updatePlayerDatas(uiHolder);
						uiHolder.enemy.userInterface.nextTurn();
					}
				}
			}
		} catch (Throwable t) {
			abort(t);
		}
	}

	@Override
	public void discardCard(Thread thread, Card card) {
		try {
			++this.round;
			System.out.println("round: " + this.round);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// do nothing here
			}
					
			UIHolder uiHolder = this.threadToUi.get(thread);
			if (uiHolder != null) {
				System.out.println("service: player " + uiHolder.player.getName() + " discard card " + 
						card.getName());
			
				this.gameEngineController.discardCard(card, uiHolder.player);
				if (this.round > 1) {
					this.gameEngineController.addResourcesToPlayer(uiHolder.enemy.player);
				}
				if (!hasSomebodyWon(uiHolder)) {
					updatePlayerDatas(uiHolder);
					uiHolder.enemy.userInterface.nextTurn();
				}
			}
		} catch (Throwable t) {
			abort(t);
		}
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.gameEngineController.getGameCardFactory().getAllPossibleCards();
	}
	
	@Override
	public GameType getGameType() {
		return this.gameEngineController.getGameType();
	}
}
