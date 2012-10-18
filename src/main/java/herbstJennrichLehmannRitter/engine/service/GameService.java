package herbstJennrichLehmannRitter.engine.service;

import herbstJennrichLehmannRitter.engine.model.Card;

/**
 * 
 * Der Gameservice stellt die Funktionalität der GameEngine nach Außen bereit
 *
 */
public interface GameService {
	
	public void start();

	public void playCard(Card card);
	public void discardCard(Card card);

	public void getAllPossibleCards();
}
