package herbstJennrichLehmannRitter.ui.impl;

import java.util.ArrayList;
import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.DeckCreator;

public class DeckCreatorImpl implements DeckCreator {

	Collection<Card> cards = new ArrayList<Card>();
	
	public void addCard(Card card) {
		this.cards.add(card);
	}

	public void removeCard(Card card) {
		this.cards.remove(card);
	}

	public void addCards(Collection<Card> cards) {
		this.cards.addAll(cards);
	}

	public void removeCards(Collection<Card> cards) {
		this.cards.removeAll(cards);
	}

}
