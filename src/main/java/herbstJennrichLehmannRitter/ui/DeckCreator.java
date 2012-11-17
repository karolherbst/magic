package herbstJennrichLehmannRitter.ui;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;

/**	Description of DeckCreator Class
 * Interface for creating a card deck or manage an existing deck
 */
public interface DeckCreator {
	
	public void addCard(Card card);

	public void removeCard(Card card);

	public void addCards(Collection<Card> cards);

	public void removeCards(Collection<Card> cards);
	
}
