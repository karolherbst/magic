package herbstJennrichLehmannRitter.engine.service.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

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
	private boolean isRunning = false;
	
	public GameServiceImpl(GameEngineController gameEngineController) {
		this.gameEngineController = gameEngineController;
	}
	
	@Override
	public void start(GameType gameType) {
		this.gameEngineController.start(gameType);
		this.isRunning = true;
	}
	
	@Override
	public void stop() {
		this.isRunning = false;
	}
	
	static private Semaphore lockRegister = new Semaphore(1);
	@Override
	public void register(Thread thread, UserInterface userInterface) {
		UIHolder newUIHolder = null;
		try {
			lockRegister.acquire();
			if (this.threadToUi.size() == 0) {
				
				newUIHolder = new UIHolder(userInterface);
				
				synchronized (this.threadToUi) {
					this.threadToUi.put(thread, newUIHolder);
					lockRegister.release();
					this.threadToUi.wait();
				
					if (this.threadToUi.size() != 2) {
						this.threadToUi.remove(newUIHolder);
						throw new IllegalArgumentException("something strange happend");
					}
					
					for ( UIHolder uiHolder : this.threadToUi.values()) {
						if (uiHolder != newUIHolder) {
							newUIHolder.enemy = uiHolder;
							uiHolder.enemy = newUIHolder;
							this.threadToUi.notify();
						}
					}
				}
				
				return;
			}
		} catch (InterruptedException e) {
			this.threadToUi.remove(newUIHolder);
			throw new IllegalArgumentException("wait timedout", e);
		}
		
		try {
			if (this.threadToUi.size() == 1) {
				newUIHolder = new UIHolder(userInterface);
				
				synchronized (this.threadToUi) {
					this.threadToUi.put(thread, newUIHolder);
					lockRegister.release();
					this.threadToUi.notify();
					this.threadToUi.wait();
				}
				
				return;
			}
		} catch (InterruptedException e) {
			throw new IllegalArgumentException("wait timedout", e);
		}
		
		if (this.threadToUi.size() > 2) {
			throw new IllegalArgumentException("there are already 2 players registered");
		}
	}
	
	@Override
	public void unregister(UserInterface userInterface) {
		
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
