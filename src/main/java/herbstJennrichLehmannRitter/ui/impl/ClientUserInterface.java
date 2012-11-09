package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.GUI.MainMenuGUI;

import java.util.Collection;

public class ClientUserInterface implements UserInterface {

//	private PlayGameGUI playGameGUI;
	private MainMenuGUI mainMenuGui;

	public ClientUserInterface(MainMenuGUI mainMenuGui) {
		this.mainMenuGui = mainMenuGui;
		setData(null);
	}
	
	@Override
	public void setData(Data data) {
		this.mainMenuGui.getPlayGameGUI().setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
		this.mainMenuGui.getPlayGameGUI().setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
		this.mainMenuGui.getPlayGameGUI().setPlayerDungeonStock(data.getOwnPlayer().getDungeon().getStock());
		this.mainMenuGui.getPlayGameGUI().setPlayerMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
		this.mainMenuGui.getPlayGameGUI().setPlayerMagicLabStock(data.getOwnPlayer().getMagicLab().getStock());
		this.mainMenuGui.getPlayGameGUI().setPlayerMineLevel(data.getOwnPlayer().getMine().getLevel());
		this.mainMenuGui.getPlayGameGUI().setPlayerMineStock(data.getOwnPlayer().getMine().getStock());
		this.mainMenuGui.getPlayGameGUI().setPlayerTower(data.getOwnPlayer().getTower().getActualPoints());
		this.mainMenuGui.getPlayGameGUI().setPlayerWall(data.getOwnPlayer().getWall().getActualPoints());
		this.mainMenuGui.getPlayGameGUI().setEnemyDungeonLevel(data.getEnemyPlayer().getDungeon().getLevel());
		this.mainMenuGui.getPlayGameGUI().setEnemyDungeonStock(data.getEnemyPlayer().getDungeon().getStock());
		this.mainMenuGui.getPlayGameGUI().setEnemyMagicLabLevel(data.getEnemyPlayer().getMagicLab().getLevel());
		this.mainMenuGui.getPlayGameGUI().setEnemyMagicLabStock(data.getEnemyPlayer().getMagicLab().getStock());
		this.mainMenuGui.getPlayGameGUI().setEnemyMineLevel(data.getEnemyPlayer().getMine().getLevel());
		this.mainMenuGui.getPlayGameGUI().setEnemyMineStock(data.getEnemyPlayer().getMine().getStock());
		this.mainMenuGui.getPlayGameGUI().setEnemyTower(data.getEnemyPlayer().getTower().getActualPoints());
		this.mainMenuGui.getPlayGameGUI().setEnemyWall(data.getEnemyPlayer().getWall().getActualPoints());
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
		this.mainMenuGui.getPlayGameGUI().setEnemyChoosenCardName(card.getName());
	}

	@Override
	public void youLost() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void youWon() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abort(String reason) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return this.mainMenuGui.getGameMenuGui().getPlayersName();
	}

	@Override
	public Collection<String> getCards() {
		return this.mainMenuGui.getPlayGameGUI().getPlayerCards();
	}
}
