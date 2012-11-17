package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;

import java.io.Serializable;
import java.util.Collection;


/**	Description of Deck Class
 * Interface for the Decks
 */

public interface Deck extends Serializable {
	
	public Collection<Card> getAllCards();
	
	public void discardCard(Card card);
	public void discardAllCards();
	public void discardAllCardsByType(CardType cardType);
	
	public boolean pickCard();
	public boolean pickCards(int numberOfCards);
	public boolean pickNumberOfCardsWithType(int numberOfCards, CardType cardType);
	public boolean pickCardFromDeckStackOrCemeteryDeckWithCostAbove(int cost);
	
	public void exchangeCardsWithHandDeck(Deck deck);
	
	public void shuffle();
	
	public int getHandDeckSize();

}
