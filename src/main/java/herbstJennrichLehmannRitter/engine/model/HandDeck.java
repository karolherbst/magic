package herbstJennrichLehmannRitter.engine.model;

import herbstJennrichLehmannRitter.engine.enums.CardType;

public interface HandDeck {

	public void discardCard(Card card);
	public void discardAllCards();
	public void discardAllCardsByType(CardType cardType);
	
	public void pickCard();
	public void pickCards(int numberOfCards);
	public void pickNumberOfCardsWithType(int numberOfCards, CardType cardType);
	public void pickCardFromDeckStackOrCemeteryDeckWithCostAbout(int cost);
	
	public void exchangeCardsWithHandDeck(HandDeck handDeck);
}
