package herbstJennrichLehmannRitter.ui;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;

/**
 * 
 * Interface um ein Kartendecks zu erstellen bzw. ein bestehendes Kartendeck zu verwalten
 *
 */
public interface DeckCreator {
	
	public void addCard(Card card);

	public void removeCard(Card card);

	public void addCards(Collection<Card> cards);

	public void removeCards(Collection<Card> cards);
	
}
