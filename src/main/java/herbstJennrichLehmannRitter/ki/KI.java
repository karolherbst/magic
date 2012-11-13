package herbstJennrichLehmannRitter.ki;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.concurrent.Semaphore;

public class KI implements UserInterface, Runnable {

	private Thread thread = null;
	private Data data = null;
	private final String name;
	private final GameServer gameServer;
	private Object mutex = new Object();
	private Semaphore semaphore = new Semaphore(1);
	
	static public void newKiOnServer(final GameServer gameServer, String name) {
		final KI ki = new KI(name, gameServer);
		
		ki.thread = new Thread(ki);
		ki.thread.start();
	}
	
	static public void startBridgedKIOnServer(final GameServer gameServer, String name, final UserInterface bridgeTo) {
		final KI ki = new KI(name, gameServer) {
			
			@Override
			public void setData(Data data) {
				super.setData(data);
				bridgeTo.setData(data);
			}
			
			@Override
			public void twoPlayerFound() {
				super.twoPlayerFound();
				bridgeTo.twoPlayerFound();
			}
			
			@Override
			public void nextTurn() {
				super.nextTurn();
				bridgeTo.nextTurn();
			}
			
			@Override
			public void playAnotherCard() {
				super.playAnotherCard();
				bridgeTo.playAnotherCard();
			}
			
			@Override
			public void enemyPlayedCard(Card card) {
				super.enemyPlayedCard(card);
				bridgeTo.enemyPlayedCard(card);
			}
			
			@Override
			public void onDiscardCard(Card card) {
				super.onDiscardCard(card);
				bridgeTo.onDiscardCard(card);
			}
			
			@Override
			public void onPlayCard(Card card) {
				super.onPlayCard(card);
				bridgeTo.onPlayCard(card);
			}
			
			@Override
			public void youLost() {
				super.youLost();
				bridgeTo.youLost();
			}
			
			@Override
			public void youWon() {
				super.youWon();
				bridgeTo.youWon();
			}
			
			@Override
			public void abort(String reason) {
				super.abort(reason);
				bridgeTo.abort(reason);
			}
		};
		
		ki.thread = new Thread(ki);
		ki.thread.start();
	}
	
	@Override
	public void run() {
		try {
			this.semaphore.acquire();
			this.gameServer.register(this);
			System.out.println(getName() + ": I'm ready!");
			
			synchronized (this.mutex) {
				this.semaphore.release();
				this.mutex.wait();
			}
			runKILogic();
			
			while (true) {
				synchronized (this.mutex) {
					this.mutex.wait();
				}
				runKILogic();
			}
		} catch (InterruptedException e) {
			System.out.println("KI " + getName() + " failed!");
		} catch (RemoteException e) {
			// TODO: exception
			e.printStackTrace();
		}
	}
	
	static public void startKIOnLocal(String name) {
		newKiOnServer(Globals.getLocalGameServer(), name);
	}
	
	public KI(String name, GameServer gameServer) {
		this.name = name;
		this.gameServer = gameServer;
	}
	
	private void runKILogic() throws RemoteException, InterruptedException {
		System.out.println(getName() + ": my next turn, now you will die!");
		
		Thread.sleep(1000);
		
		Card cardToPlay = null;
		Card lastCard = null;
		for (Card card : this.data.getOwnPlayer().getDeck().getAllCards()) {
			lastCard = card;
			if (MagicUtils.canPlayerEffortCard(this.data.getOwnPlayer(), card)) {
				cardToPlay = card;
				break;
			}
		}
		
		if (cardToPlay != null) {
			onPlayCard(cardToPlay);
			this.gameServer.playCard(cardToPlay);
		} else {
			onDiscardCard(lastCard);
			this.gameServer.discardCard(lastCard);
		}
	}
	
	@Override
	public void onPlayCard(Card card) {
		// only for GUI notification
	}
	
	
	@Override
	public void onDiscardCard(Card card) {
		// on for GUI notification
	}
	
	@Override
	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public void nextTurn() {
		playAnotherCard();
	}

	@Override
	public void playAnotherCard() {
		try {
			this.semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized (this.mutex) {
			this.mutex.notify();
		}
		this.semaphore.release();
	}

	@Override
	public void enemyPlayedCard(Card card) {
		System.out.println(getName() + ": ahh your card (" + card.getName() + ") won't destroy me!");
	}

	@Override
	public void youLost() {
		System.out.println(getName() + ": you a sooo gay you motherfucker, you cheated you sucker!");
	}

	@Override
	public void youWon() {
		System.out.println(getName() + ": HAHA! you are so weak you looser!");
	}

	@Override
	public void abort(String reason) {
		System.out.println(getName() + ": :( the game was aborted! (Reason: " + reason + ')');
		if (this.thread != null) {
			this.thread.interrupt();
		}
		try {
			this.gameServer.unregister(this);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.thread = null;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Collection<String> getCards() {
		return Globals.getGameCardFactory().getAllPossibleCardNames();
	}

	@Override
	public void twoPlayerFound() {
		// nothing should be done here, we are using a KI bridge for starting demos
	}

}
