package herbstJennrichLehmannRitter.ui;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;

public interface DeckCreator {
	
	public void addCard(Card card);

	public void deleteCard(Card card);

	public void addCards(Collection<Card> cards);

	public void deleteCards(Collection<Card> cards);
	
}
