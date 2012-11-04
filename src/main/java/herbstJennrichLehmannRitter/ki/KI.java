package herbstJennrichLehmannRitter.ki;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;

public class KI implements UserInterface {

	private Thread thread = null;
	private Data data = null;
	private final String name;
	private Object mutex = new Object();
	
	static private KI newKiOnServer(final GameServer gameServer, String name) {
		final KI ki = new KI(name);
		
		ki.thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				gameServer.register(ki);
				
				while (true) {
					try {
						System.out.println(ki.getName() + ": I'm ready!");
						synchronized (ki.mutex) {
							ki.mutex.wait();
						}
						ki.runKILogic();
					} catch (InterruptedException e) {
						break;
					}
				}
			}
		});
		ki.thread.start();
		
		return ki;
	}
	
	static public void startKIOnLocal(String name) {
		newKiOnServer(Globals.getLocalGameServer(), name);
	}
	
	public KI(String name) {
		this.name = name;
	}
	
	private void runKILogic() {
		System.out.println(getName() + ": my next turn, now you will die!");
	}
	
	@Override
	public void setData(Data data) {
		synchronized (this.data) {
			this.data = data;
		}
	}

	@Override
	public synchronized void nextTurn() {
		this.mutex.notify();
	}

	@Override
	public synchronized void playAnotherCard() {
		this.mutex.notify();
	}

	@Override
	public void enemeyPlayedCard(Card card) {
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
		this.thread.interrupt();
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

}
