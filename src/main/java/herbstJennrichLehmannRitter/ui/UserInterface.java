package herbstJennrichLehmannRitter.ui;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;

public interface UserInterface {
	
	public void setData(Data data);

	public void nextTurn();

	public void playAnotherCard();

	public void enemeyPlayedCard(Card card);

	public boolean youLost();

	public boolean youWon();

	public void abort();
	
}
