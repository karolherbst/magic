package herbstJennrichLehmannRitter.engine.service;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.util.Collection;

/**
 * 
 * Der Gameservice stellt die Funktionalität der GameEngine nach Außen bereit
 *
 */
public interface GameService {
	
	public void start(GameType gameType);
	public void stop();
	
	public void register(Thread thread, UserInterface userInterface);
	public void unregister(UserInterface userInterface);

	public void playCard(Player player, Card card);
	public void discardCard(Player player, Card card);

	public Collection<Card> getAllPossibleCards();
}
