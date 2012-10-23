package herbstJennrichLehmannRitter.engine.model.impl;

import java.util.ArrayList;
import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Deck;
import herbstJennrichLehmannRitter.engine.model.HandDeck;

public class DeckImpl implements Deck {
	
	private class HandDeckImpl implements HandDeck {
		
		private Collection<Card> handDeck = new ArrayList<Card>();
		
		@Override
		public boolean discardCard(Card card) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean discardAllCards() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Card pickCard() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Collection<Card> pickCards(int numberOfCards) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	@Override
	public Collection<Card> getDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Card> getHandDeck() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Card> getCemeteryDeck() {
		// TODO Auto-generated method stub
		return null;
	}

}
