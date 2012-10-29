package herbstJennrichLehmannRitter.server;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;

/**
 * 
 * Interface für die Schnittstelle zum GameClient
 *
 */
public interface GameServer {
	
	public void register(UserInterface userInterface);
	public void unregister(UserInterface userInterface);
	
	public void start();
	
	public void playCard(Card card);
	public void discardCard(Card card);
	
	public Collection<Card> getAllPossibleCards();
}
