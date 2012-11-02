package herbstJennrichLehmannRitter.ki;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;

public class KI implements UserInterface {

	static KI ki = new KI();
	
	private Object mutex = new Object();
	
	static public void startKIOnLocal() {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				Globals.getLocalGameServer().register(ki);
				
				while (true) {
					try {
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
		
		thread.start();
	}
	
	private void runKILogic() {
		
	}
	
	@Override
	public void setData(Data data) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void youLost() {
		System.out.println("KI: you a sooo gay you motherfucker, you cheated you sucker!");
	}

	@Override
	public void youWon() {
		System.out.println("KI: HAHA! you are so weak you looser!");
	}

	@Override
	public void abort(String reason) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "super KI3000";
	}

	@Override
	public Collection<String> getCards() {
		return Globals.getGameCardFactory().getAllPossibleCardNames();
	}

}
