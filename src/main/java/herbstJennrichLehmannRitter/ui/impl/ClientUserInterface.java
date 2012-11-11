package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.GUI.HostMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.MainMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.PlayGameGUI;

import java.rmi.RemoteException;
import java.util.Collection;

import org.eclipse.swt.widgets.Display;

public class ClientUserInterface implements UserInterface {

	private MainMenuGUI mainMenuGUI;
	private PlayGameGUI playGameGUI;
	private HostMenuGUI hostMenuGUI;

	public void setMainMenuGUI(MainMenuGUI mainMenuGUI) {
		this.mainMenuGUI = mainMenuGUI;
	}
	
	public void setPlayGameGUI(PlayGameGUI playGameGUI) {
		this.playGameGUI = playGameGUI;
	}
	
	public void setHostMenuGUI(HostMenuGUI hostMenuGUI) {
		this.hostMenuGUI = hostMenuGUI;
	}
	
	@Override
	public void setData(final Data data) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				ClientUserInterface.this.playGameGUI.setPlayerHandCards(data.getOwnPlayer().getDeck().getAllCards());
				ClientUserInterface.this.playGameGUI.setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
				ClientUserInterface.this.playGameGUI.setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
				ClientUserInterface.this.playGameGUI.setPlayerDungeonStock(data.getOwnPlayer().getDungeon().getStock());
				ClientUserInterface.this.playGameGUI.setPlayerMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
				ClientUserInterface.this.playGameGUI.setPlayerMagicLabStock(data.getOwnPlayer().getMagicLab().getStock());
				ClientUserInterface.this.playGameGUI.setPlayerMineLevel(data.getOwnPlayer().getMine().getLevel());
				ClientUserInterface.this.playGameGUI.setPlayerMineStock(data.getOwnPlayer().getMine().getStock());
				ClientUserInterface.this.playGameGUI.setPlayerTower(data.getOwnPlayer().getTower().getActualPoints());
				ClientUserInterface.this.playGameGUI.setPlayerWall(data.getOwnPlayer().getWall().getActualPoints());
				
				ClientUserInterface.this.playGameGUI.setEnemyDungeonLevel(data.getEnemyPlayer().getDungeon().getLevel());
				ClientUserInterface.this.playGameGUI.setEnemyDungeonStock(data.getEnemyPlayer().getDungeon().getStock());
				ClientUserInterface.this.playGameGUI.setEnemyMagicLabLevel(data.getEnemyPlayer().getMagicLab().getLevel());
				ClientUserInterface.this.playGameGUI.setEnemyMagicLabStock(data.getEnemyPlayer().getMagicLab().getStock());
				ClientUserInterface.this.playGameGUI.setEnemyMineLevel(data.getEnemyPlayer().getMine().getLevel());
				ClientUserInterface.this.playGameGUI.setEnemyMineStock(data.getEnemyPlayer().getMine().getStock());
				ClientUserInterface.this.playGameGUI.setEnemyTower(data.getEnemyPlayer().getTower().getActualPoints());
				ClientUserInterface.this.playGameGUI.setEnemyWall(data.getEnemyPlayer().getWall().getActualPoints());
			}
		});
	}
	
	@Override
	public void twoPlayerFound() {
		if (this.hostMenuGUI != null) {
			this.hostMenuGUI.cancelTimerAndOpenPlayGameGUI();
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
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.nextTurn();
			}
		});
	}

	@Override
	public void playAnotherCard() {
		this.playGameGUI.playAnotherCard();
	}

	@Override
	public void enemeyPlayedCard(Card card) {
		this.playGameGUI.setEnemyChoosenCardName(card.getName());
	}
	
	@Override
	public void onPlayCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.playerPlayedCard(card.getName());
			}
		});
	}
	
	@Override
	public void onDiscardCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				playGameGUI.playerDiscardCard(card.getName());
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
	public void abort(String reason) {
		if (this.playGameGUI != null) {
			this.playGameGUI.setGameStateToAbort(reason);
		} else if (this.hostMenuGUI != null) {
			this.hostMenuGUI.displayMessageBox(reason);
		}
	}

	@Override
	public String getName() {
		return this.mainMenuGUI.getPlayerName();
	}

	@Override
	public Collection<String> getCards() {
		return this.mainMenuGUI.getPlayerCards();
	}
}
