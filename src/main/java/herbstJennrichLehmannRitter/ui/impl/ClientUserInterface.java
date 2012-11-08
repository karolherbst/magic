package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.GUI.PlayGameGUI;

import java.util.Collection;

public class ClientUserInterface implements UserInterface {

	private PlayGameGUI playGameGUI;

	public ClientUserInterface(PlayGameGUI playGameGUI) {
		//TODO: Was hier?
	setData(null);
	}
	
	@Override
	public void setData(Data data) {
		// TODO: ist das von der Logik her so richtig?
		playGameGUI.setPlayerDungeonLevel(data.getOwnPlayer().getDungeon().getLevel());
		playGameGUI.setPlayerDungeonStock(data.getOwnPlayer().getDungeon().getStock());
		playGameGUI.setPlayerMagicLabLevel(data.getOwnPlayer().getMagicLab().getLevel());
		playGameGUI.setPlayerMagicLabStock(data.getOwnPlayer().getMagicLab().getStock());
		playGameGUI.setPlayerMineLevel(data.getOwnPlayer().getMine().getLevel());
		playGameGUI.setPlayerMineStock(data.getOwnPlayer().getMine().getStock());
		playGameGUI.setPlayerTower(data.getOwnPlayer().getTower().getActualPoints());
		playGameGUI.setPlayerWall(data.getOwnPlayer().getWall().getActualPoints());
		playGameGUI.setEnemyDungeonLevel(data.getEnemyPlayer().getDungeon().getLevel());
		playGameGUI.setEnemyDungeonStock(data.getEnemyPlayer().getDungeon().getStock());
		playGameGUI.setEnemyMagicLabLevel(data.getEnemyPlayer().getMagicLab().getLevel());
		playGameGUI.setEnemyMagicLabStock(data.getEnemyPlayer().getMagicLab().getStock());
		playGameGUI.setEnemyMineLevel(data.getEnemyPlayer().getMine().getLevel());
		playGameGUI.setEnemyMineStock(data.getEnemyPlayer().getMine().getStock());
		playGameGUI.setEnemyTower(data.getEnemyPlayer().getTower().getActualPoints());
		playGameGUI.setEnemyWall(data.getEnemyPlayer().getWall().getActualPoints());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<String> getCards() {
		// TODO Auto-generated method stub
		return null;
	}
}
