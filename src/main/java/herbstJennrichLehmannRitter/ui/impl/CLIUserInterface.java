package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ki.KI;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLIUserInterface implements UserInterface {

	private enum CLIState {
		MAINMENU,
		LOCALGAME,
		LOCALGAME_STARTED
	}
	
	private Thread eventLoopThread;
	private CLIState cliState = CLIState.MAINMENU;
	
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
	
	private boolean handleCommand(String command) {
		switch (this.cliState) {
		case MAINMENU:
			if (command.startsWith("quit")) {
				Thread.currentThread().interrupt();
				return true;
			} else if (command.startsWith("help")) {
				System.out.println("These commands are available:");
				System.out.println("quit - will quit this application");
				System.out.println("start [local] - will start a new local game");
				return true;
			} else if (command.startsWith("start")) {
				if (command.startsWith("start local")) {
					System.out.println("start local game against KI");
					this.cliState = CLIState.LOCALGAME;
				} else {
					return false;
				}
				return true;
			}
			break;
		case LOCALGAME:
			if (command.startsWith("quit")) {
				this.cliState = CLIState.MAINMENU;
				Globals.getLocalGameServer().stop();
				System.out.println("returned back to main menu");
				return true;
			} else if (command.startsWith("help")) {
				System.out.println("These commands are available:");
				System.out.println("quit - will return to main menu");
				System.out.println("start - will start the game!");
				return true;
			} else if (command.startsWith("start")) {
				KI.startKIOnLocal();
				Globals.getLocalGameServer().register(this);
				this.cliState = CLIState.LOCALGAME_STARTED;
				return true;
			}
			break;
		case LOCALGAME_STARTED:
			if (command.startsWith("quit")) {
				this.cliState = CLIState.MAINMENU;
				Globals.getLocalGameServer().unregister(this);
				System.out.println("returned back to main menu");
				return true;
			} else if (command.startsWith("help")) {
				System.out.println("These commands are available:");
				System.out.println("quit - will return to main menu");
				return true;
			}
			break;
		default:
			// undefined state
			return false;
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
	public void youLost() {
		System.out.println("You have lost!");
	}

	@Override
	public void youWon() {
		System.out.println("You have won!");
	}

	@Override
	public void abort() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "";
	}

}
