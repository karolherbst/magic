package herbstJennrichLehmannRitter.engine.service;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;

/**
 * 
 * Der Gameservice stellt die Funktionalität der GameEngine nach Außen bereit
 *
 */
public interface GameService {
	
	public void start();

	public void playCard(Player player, Card card);
	public void discardCard(Player player, Card card);

	public void getAllPossibleCards();
}
