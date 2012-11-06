package herbstJennrichLehmannRitter.engine.service.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.DataImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class GameServiceImpl implements GameService {

	private static long DEFAULT_TIMEOUT = 1000 * 30;
	
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
		this.gameEngineController.start(gameType);
	}
	
	@Override
	public void stop() {
		//this.isRunning = false;
	}
	
	private Player createPlayer(String name, Collection<String> cardNames) {
		return this.gameEngineController.createPlayer(name, cardNames);
	}
	
	static private Semaphore lockRegister = new Semaphore(1);
	@Override
	public boolean register(Thread thread, UserInterface userInterface) {
		final UIHolder newUIHolder = new UIHolder(userInterface);
		try {
			lockRegister.acquire();
			if (this.threadToUi.size() == 0) {
				
				synchronized (this.threadToUi) {
					this.threadToUi.put(thread, newUIHolder);
					lockRegister.release();
					this.threadToUi.wait(DEFAULT_TIMEOUT);
				
					if (this.threadToUi.size() != 2) {
						this.threadToUi.remove(newUIHolder);
						throw new IllegalArgumentException("something strange happend");
					}
					
					for ( UIHolder uiHolder : this.threadToUi.values()) {
						if (uiHolder != newUIHolder) {
							newUIHolder.enemy = uiHolder;
							uiHolder.enemy = newUIHolder;
							newUIHolder.player = createPlayer(userInterface.getName(), userInterface.getCards());
							this.threadToUi.notify();
						}
					}
				}
				
				newUIHolder.userInterface.setData(new DataImpl(newUIHolder.player, newUIHolder.enemy.player));
				newUIHolder.enemy.userInterface.setData(new DataImpl(newUIHolder.enemy.player, newUIHolder.player));
				return true;
			}
		} catch (InterruptedException e) {
			this.threadToUi.remove(newUIHolder);
			throw new IllegalArgumentException("wait timedout", e);
		}
		
		try {
			if (this.threadToUi.size() == 1) {
				newUIHolder.player = createPlayer(userInterface.getName(), userInterface.getCards());
				
				synchronized (this.threadToUi) {
					this.threadToUi.put(thread, newUIHolder);
					lockRegister.release();
					this.threadToUi.notify();
					this.threadToUi.wait(DEFAULT_TIMEOUT);
				}
				
				return false;
			}
		} catch (InterruptedException e) {
			throw new IllegalArgumentException("wait timedout", e);
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
				
				UserInterface userInterface1 = userInterface;
				UserInterface userInterface2 = uiHolder.enemy.userInterface;
				
				userInterface1.abort("Game aborted!");
				userInterface2.abort("Player " + uiHolder.player.getName() + " left the game");
				
				this.threadToUi = new HashMap<Thread, GameServiceImpl.UIHolder>();
			}
		}
	}

	@Override
	public void playCard(Thread thread, Card card) {
		UIHolder uiHolder = this.threadToUi.get(thread);
		System.out.println("service: player " + uiHolder.player.getName() + " played card " + card.getName());
	}

	@Override
	public void discardCard(Thread thread, Card card) {
		UIHolder uiHolder = this.threadToUi.get(thread);
		System.out.println("service: player " + uiHolder.player.getName() + " discard card " + card.getName());
	}

	@Override
	public Collection<Card> getAllPossibleCards() {
		return this.gameEngineController.getGameCardFactory().getAllPossibleCards();
	}
}
