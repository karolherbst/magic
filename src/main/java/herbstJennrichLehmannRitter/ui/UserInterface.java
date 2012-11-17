package herbstJennrichLehmannRitter.ui;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;

import java.io.Serializable;
import java.util.Collection;

/**	Description of GameServerImpl Class
 *	Interface for sending information to the client
 */
public interface UserInterface extends Serializable {
	
	public void setData(Data data);

	public void twoPlayerFound();
	
	public void nextTurn();

	public void playAnotherCard();

	public void enemyPlayedCard(Card card);
	
	public void onPlayCard(Card card);
	
	public void onDiscardCard(Card card);

	public void youLost();

	public void youWon();

	public void abort(String reason);
	
	public String getName();
	
	public Collection<String> getCards();
	
}
