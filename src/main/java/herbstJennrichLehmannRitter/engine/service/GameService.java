package herbstJennrichLehmannRitter.engine.service;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;

/**	Description of GameService Class
 * 	The Gameservice secures the functionality of the GameEngine to the outside.
 */
public interface GameService {
	
	public void start(GameType gameType);
	public void stop();
	
	public void register(Thread thread, UserInterface userInterface);
	public void unregister(UserInterface userInterface);

	public void playCard(Thread thread, Card card);
	public void discardCard(Thread thread, Card card);

	public Collection<Card> getAllPossibleCards();
	public GameType getGameType();
}
