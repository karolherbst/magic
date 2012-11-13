package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.GUI.ClientMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.HostMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.MainMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.PlayGameGUI;

import java.rmi.RemoteException;
import java.util.Collection;

import org.eclipse.swt.widgets.Display;

public class DemoUserInterface implements UserInterface {

	private MainMenuGUI mainMenuGUI;
	private PlayGameGUI playGameGUI;
	private HostMenuGUI hostMenuGUI;
	private ClientMenuGUI clientMenuGUI;

	public void setMainMenuGUI(MainMenuGUI mainMenuGUI) {
		this.mainMenuGUI = mainMenuGUI;
	}
	
	public void setPlayGameGUI(PlayGameGUI playGameGUI) {
		this.playGameGUI = playGameGUI;
	}
	
	public void setHostMenuGUI(HostMenuGUI hostMenuGUI) {
		this.hostMenuGUI = hostMenuGUI;
	}
	
	public void setClientMenuGUI(ClientMenuGUI clientMenuGUI) {
		this.clientMenuGUI = clientMenuGUI;
	}
	
	@Override
	public void setData(final Data data) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				DemoUserInterface.this.playGameGUI.setEnemyDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
				DemoUserInterface.this.playGameGUI.setEnemyDungeonStock(data.getOwnPlayer().getDungeon().getStock());
				DemoUserInterface.this.playGameGUI.setEnemyMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
				DemoUserInterface.this.playGameGUI.setEnemyMagicLabStock(data.getOwnPlayer().getMagicLab().getStock());
				DemoUserInterface.this.playGameGUI.setEnemyMineLevel(data.getOwnPlayer().getMine().getLevel());
				DemoUserInterface.this.playGameGUI.setEnemyMineStock(data.getOwnPlayer().getMine().getStock());
				DemoUserInterface.this.playGameGUI.setEnemyTower(data.getOwnPlayer().getTower().getActualPoints());
				DemoUserInterface.this.playGameGUI.setEnemyWall(data.getOwnPlayer().getWall().getActualPoints());
				DemoUserInterface.this.playGameGUI.setEnemyHandCards(data.getOwnPlayer().getDeck().getAllCards());
				
				DemoUserInterface.this.playGameGUI.setPlayerDungeonLevel(data.getEnemyPlayer().getDungeon().getLevel());
				DemoUserInterface.this.playGameGUI.setPlayerDungeonStock(data.getEnemyPlayer().getDungeon().getStock());
				DemoUserInterface.this.playGameGUI.setPlayerMagicLabLevel(data.getEnemyPlayer().getMagicLab().getLevel());
				DemoUserInterface.this.playGameGUI.setPlayerMagicLabStock(data.getEnemyPlayer().getMagicLab().getStock());
				DemoUserInterface.this.playGameGUI.setPlayerMineLevel(data.getEnemyPlayer().getMine().getLevel());
				DemoUserInterface.this.playGameGUI.setPlayerMineStock(data.getEnemyPlayer().getMine().getStock());
				DemoUserInterface.this.playGameGUI.setPlayerTower(data.getEnemyPlayer().getTower().getActualPoints());
				DemoUserInterface.this.playGameGUI.setPlayerWall(data.getEnemyPlayer().getWall().getActualPoints());
			}
		});
	}
	
	@Override
	public void twoPlayerFound() {
		if (this.hostMenuGUI != null) {
			this.hostMenuGUI.cancelTimerAndOpenPlayGameGUI();
		} else if (this.clientMenuGUI != null) {
			this.clientMenuGUI.cancelTimerAndOpenPlayGameGUI();
		} else {
			GameServer gameServer = Globals.getLocalGameServer();
			try {
				gameServer.start(this.mainMenuGUI.getGameType());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void nextTurn() {
		System.out.println("ENEMY: NEXT TURN");
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.nextTurnEnemy();
			}
		});
	}

	@Override
	public void playAnotherCard() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.playAnotherCardEnemy();
			}
		});
	}

	@Override
	public void enemyPlayedCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.setPlayerChoosenCardName(card.getName());
			}
		});
	}
	
	@Override
	public void onPlayCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.enemyPlayedCard(card.getName());
			}
		});
	}
	
	@Override
	public void onDiscardCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.enemyDiscardCard(card.getName());
			}
		});
	}
	
	
	@Override
	public void youLost() {
		this.playGameGUI.setGameStateToLoose();
		
	}

	@Override
	public void youWon() {
		this.playGameGUI.setGameStateToWon();
		
	}

	@Override
	public void abort(final String reason) {
		if (this.playGameGUI != null) {
			Display.getDefault().asyncExec(new Runnable() {
				
				@Override
				public void run() {
					playGameGUI.setGameStateToAbort(reason);
				}
			});
		} else if (this.hostMenuGUI != null) {
			this.hostMenuGUI.displayMessageBox(reason);
		}
	}

	@Override
	public String getName() {
		return this.mainMenuGUI.getEnemyName();
	}

	@Override
	public Collection<String> getCards() {
		return this.mainMenuGUI.getEnemyCards();
	}
}
