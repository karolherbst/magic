package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.GUI.MainMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.PlayGameGUI;

import java.rmi.RemoteException;
import java.util.Collection;

import org.eclipse.swt.widgets.Display;

/**	Description of DemoEnemyKIUserInterface Class
 * This class implements the UserInterface to show the Demo GUI
 */

@SuppressWarnings("serial")
public class DemoEnemyKIUserInterface implements UserInterface {

	private MainMenuGUI mainMenuGUI;
	private PlayGameGUI playGameGUI;

	public void setMainMenuGUI(MainMenuGUI mainMenuGUI) {
		this.mainMenuGUI = mainMenuGUI;
	}
	
	public void setPlayGameGUI(PlayGameGUI playGameGUI) {
		this.playGameGUI = playGameGUI;
	}
	
	@Override
	public void setData(final Data data) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyDungeonStock(data.getOwnPlayer().getDungeon().getStock());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyMagicLabStock(data.getOwnPlayer().getMagicLab().getStock());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyMineLevel(data.getOwnPlayer().getMine().getLevel());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyMineStock(data.getOwnPlayer().getMine().getStock());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyTower(data.getOwnPlayer().getTower().getActualPoints());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyWall(data.getOwnPlayer().getWall().getActualPoints());
				DemoEnemyKIUserInterface.this.playGameGUI.setEnemyHandCards(data.getOwnPlayer().getDeck().getAllCards());
			}
		});
	}
	
	@Override
	public void twoPlayerFound() {
		GameServer gameServer = Globals.getLocalGameServer();
		try {
			gameServer.start(this.mainMenuGUI.getGameType());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nextTurn() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				DemoEnemyKIUserInterface.this.playGameGUI.nextTurnEnemy();
			}
		});
	}

	@Override
	public void playAnotherCard() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				DemoEnemyKIUserInterface.this.playGameGUI.playAnotherCardEnemy();
			}
		});
	}

	@Override
	public void enemyPlayedCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				DemoEnemyKIUserInterface.this.playGameGUI.setPlayerChosenCardName(card.getName());
			}
		});
	}
	
	@Override
	public void onPlayCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				DemoEnemyKIUserInterface.this.playGameGUI.enemyPlayedCard(card.getName());
			}
		});
	}
	
	@Override
	public void onDiscardCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				DemoEnemyKIUserInterface.this.playGameGUI.enemyDiscardCard(card.getName());
			}
		});
	}
	
	
	@Override
	public void youLost() {}

	@Override
	public void youWon() {}

	@Override
	public void abort(final String reason) {
		if (this.playGameGUI != null) {
			Display.getDefault().asyncExec(new Runnable() {
				
				@Override
				public void run() {
					DemoEnemyKIUserInterface.this.playGameGUI.setGameStateToAbort(reason);
				}
			});
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
