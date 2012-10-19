package herbstJennrichLehmannRitter.ui.impl;

import java.util.ArrayList;
import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.DeckCreator;

public class DeckCreatorImpl implements DeckCreator {

	Collection<Card> cards = new ArrayList<Card>();
	
	@Override
	public void addCard(Card card) {
		this.cards.add(card);
	}

	@Override
	public void removeCard(Card card) {
		this.cards.remove(card);
	}

	@Override
	public void addCards(Collection<Card> cardsToAdd) {
		this.cards.addAll(cardsToAdd);
	}

	@Override
	public void removeCards(Collection<Card> cardsToRemove) {
		this.cards.removeAll(cardsToRemove);
	}

}
