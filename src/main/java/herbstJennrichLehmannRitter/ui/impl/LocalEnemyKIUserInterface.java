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

/**	Description of LocalEnemyKIUserInterface Class
 * This class implements the UserInterface to show the GUI in local games against the KI
 */

@SuppressWarnings("serial")
public class LocalEnemyKIUserInterface implements UserInterface {

	private MainMenuGUI mainMenuGUI;
	private PlayGameGUI playGameGUI;

	public void setMainMenuGUI(MainMenuGUI mainMenuGUI) {
		LocalEnemyKIUserInterface.this.mainMenuGUI = mainMenuGUI;
	}
	
	public void setPlayGameGUI(PlayGameGUI playGameGUI) {
		LocalEnemyKIUserInterface.this.playGameGUI = playGameGUI;
	}
	
	@Override
	public void setData(final Data data) {
		Display.getDefault().asyncExec(new Runnable() {
			
			@Override
			public void run() {
				LocalEnemyKIUserInterface.this.playGameGUI.setEnemyDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
				LocalEnemyKIUserInterface.this.playGameGUI.setEnemyMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
				LocalEnemyKIUserInterface.this.playGameGUI.setEnemyMineLevel(data.getOwnPlayer().getMine().getLevel());
				LocalEnemyKIUserInterface.this.playGameGUI.setEnemyTower(data.getOwnPlayer().getTower().getActualPoints());
				LocalEnemyKIUserInterface.this.playGameGUI.setEnemyWall(data.getOwnPlayer().getWall().getActualPoints());
			}
		});
	}
	
	@Override
	public void twoPlayerFound() {
		GameServer gameServer = Globals.getLocalGameServer();
		try {
			gameServer.start(LocalEnemyKIUserInterface.this.mainMenuGUI.getGameType());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nextTurn() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				LocalEnemyKIUserInterface.this.playGameGUI.nextTurnEnemy();
			}
		});
	}

	@Override
	public void playAnotherCard() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				LocalEnemyKIUserInterface.this.playGameGUI.playAnotherCardEnemy();
			}
		});
	}

	@Override
	public void enemyPlayedCard(final Card card) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				LocalEnemyKIUserInterface.this.playGameGUI.setPlayerChosenCardName(card.getName());
			}
		});
	}
	
	@Override
	public void onPlayCard(final Card card) {}
	
	@Override
	public void onDiscardCard(final Card card) {}
	
	@Override
	public void youLost() {}

	@Override
	public void youWon() {}

	@Override
	public void abort(final String reason) {}

	@Override
	public String getName() {
		return LocalEnemyKIUserInterface.this.mainMenuGUI.getEnemyName();
	}

	@Override
	public Collection<String> getCards() {
		return LocalEnemyKIUserInterface.this.mainMenuGUI.getEnemyCards();
	}
}
