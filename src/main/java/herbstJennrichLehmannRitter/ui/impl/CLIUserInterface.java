package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIUserInterface implements UserInterface {

	private Thread eventLoopThread;
	
	public CLIUserInterface() {
		startEventLoop();
	}
	
	private void startEventLoop() {
		if (this.eventLoopThread == null) {
			Runnable eventLoop = new Thread() {
				
				@SuppressWarnings("synthetic-access")
				@Override
				public void run() {
					System.out.println("Magic started. Please enter command (press help for list):");
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					
					while (!Thread.interrupted()) {
						try {
							String line = reader.readLine();
							if(!handleCommand(line)) {
								System.out.println("command: \"" + line + "\" not found!");
							}
						} catch (IOException e) {
							System.out.println("error occured while reading input, try again:");
						}
					}
				}
			};
			this.eventLoopThread = new Thread(eventLoop);
			this.eventLoopThread.start();
			try {
				this.eventLoopThread.join();
				System.out.println("Magic is stopping!");
			} catch (InterruptedException e) {
				System.out.println("Magic is stopping!");
			}
		}
	}
	
	private static boolean handleCommand(String command) {
		if (command.startsWith("quit")) {
			Thread.currentThread().interrupt();
			return true;
		} else if (command.startsWith("help")) {
			System.out.println("These commands are available:");
			System.out.println("quit - will quit this application");
			System.out.println("start [local] - will start a new local game");
			return true;
		} else if (command.startsWith("start")) {
			return true;
		}
		return false;
	}
	
	@Override
	public void setData(Data data) {
		// TODO Auto-generated method stub
	}

	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playAnotherCard() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enemeyPlayedCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean youLost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean youWon() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void abort() {
		// TODO Auto-generated method stub

	}

}
