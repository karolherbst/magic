package herbstJennrichLehmannRitter.ui;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;

/**
 * 
 * Interface um den Client Informationen zu übergeben
 *
 */
public interface UserInterface {
	
	public void setData(Data data);

	public void nextTurn();

	public void playAnotherCard();

	public void enemeyPlayedCard(Card card);

	public void youLost();

	public void youWon();

	public void abort();
	
	public String getName();
	
}
