package herbstJennrichLehmannRitter.engine.model;

import java.util.Collection;

public interface HandDeck {

	public boolean discardCard(Card card);
	public boolean discardAllCards();
	
	public Card pickCard();
	public Collection<Card> pickCards(int numberOfCards);	
}
