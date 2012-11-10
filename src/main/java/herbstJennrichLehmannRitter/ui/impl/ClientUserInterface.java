package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.GUI.HostMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.MainMenuGUI;
import herbstJennrichLehmannRitter.ui.GUI.PlayGameGUI;

import java.util.Collection;

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
	public void setData(Data data) {
		this.playGameGUI.setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
		this.playGameGUI.setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
		this.playGameGUI.setPlayerDungeonStock(data.getOwnPlayer().getDungeon().getStock());
		this.playGameGUI.setPlayerMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
		this.playGameGUI.setPlayerMagicLabStock(data.getOwnPlayer().getMagicLab().getStock());
		this.playGameGUI.setPlayerMineLevel(data.getOwnPlayer().getMine().getLevel());
		this.playGameGUI.setPlayerMineStock(data.getOwnPlayer().getMine().getStock());
		this.playGameGUI.setPlayerTower(data.getOwnPlayer().getTower().getActualPoints());
		this.playGameGUI.setPlayerWall(data.getOwnPlayer().getWall().getActualPoints());
		
		this.playGameGUI.setEnemyDungeonLevel(data.getEnemyPlayer().getDungeon().getLevel());
		this.playGameGUI.setEnemyDungeonStock(data.getEnemyPlayer().getDungeon().getStock());
		this.playGameGUI.setEnemyMagicLabLevel(data.getEnemyPlayer().getMagicLab().getLevel());
		this.playGameGUI.setEnemyMagicLabStock(data.getEnemyPlayer().getMagicLab().getStock());
		this.playGameGUI.setEnemyMineLevel(data.getEnemyPlayer().getMine().getLevel());
		this.playGameGUI.setEnemyMineStock(data.getEnemyPlayer().getMine().getStock());
		this.playGameGUI.setEnemyTower(data.getEnemyPlayer().getTower().getActualPoints());
		this.playGameGUI.setEnemyWall(data.getEnemyPlayer().getWall().getActualPoints());
	}
	
	@Override
	public void twoPlayerFound() {
		this.hostMenuGUI.cancelTimerAndOpenPlayGameGUI();
	}

	@Override
	public void nextTurn() {
		this.playGameGUI.nextTurn();
		
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
