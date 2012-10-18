package herbstJennrichLehmannRitter.engine.service;

import herbstJennrichLehmannRitter.engine.model.Card;

public interface GameService {
	
	public void start();

	public void playCard(Card card);

	public void discardCard(Card card);

	public void getAllPossibleCards();
}
