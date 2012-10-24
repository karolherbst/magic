package herbstJennrichLehmannRitter.engine.model.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.CemeteryDeck;
import herbstJennrichLehmannRitter.engine.model.Deck;
import herbstJennrichLehmannRitter.engine.model.DeckStack;
import herbstJennrichLehmannRitter.engine.model.HandDeck;

public class DeckImpl implements Deck {
	
	private HandDeckImpl handDeckImpl = new HandDeckImpl();
	private CemeteryDeckImpl cemeteryDeckImpl = new CemeteryDeckImpl();
	private DeckStackImpl deckStackImpl = new DeckStackImpl();
	
	private class HandDeckImpl implements HandDeck {
		
		private Collection<Card> handDeck = new ArrayList<Card>();
		
		@Override
		public void discardCard(Card card) {
			this.handDeck.remove(card);
			cemeteryDeckImpl.addCard(card);
		}

		@Override
		public void discardAllCards() {
			cemeteryDeckImpl.addCards(this.handDeck);
			this.handDeck.clear();
		}
		
		@Override
		public void discardAllCardsByType(CardType cardType) {
			for (Card card : this.handDeck) {
				if (card.getCardType() == cardType) {
					this.discardCard(card);
				}
			}
		}
		
		private void addCard(Card card) {
			try {
				if (this.handDeck.size() > 6) {
					// TODO: Hier eine Exception sinnvoll?
					throw new Exception("Es können nicht mehr als 6 Karten gleichzeitig aufgenommen werden!");
				} else {
					this.handDeck.add(card);
				}
			} catch (Exception e) {
				System.out.println(e.getLocalizedMessage());
			}
		}

		@Override
		public void pickCard() {
			this.addCard(deckStackImpl.pickCard());
		}

		@Override
		public void pickCards(int numberOfCards) {
			if (numberOfCards < 6) {
				for (int i = 0; i < numberOfCards; i++) {
					if (this.handDeck.size() > 6) {
						break;
					}
					this.addCard(deckStackImpl.pickCard());
				}
			}
		}
		
		@Override
		public void pickCardFromDeckStackOrCemeteryDeckWithCostAbout(int cost) {
			List<Card> cards = new ArrayList<Card>();
			Card card = null;
			
			cards.addAll(cemeteryDeckImpl.getAllCards());
			cards.addAll(deckStackImpl.getAllCards());
			Collections.shuffle(cards);
			
			for (Card cardIteration : cards) {
				if (cardIteration.getCostBrick() > cost 
						|| cardIteration.getCostCrystal() > cost 
						|| cardIteration.getCostMonsters() > cost) {
					card = cardIteration;
					break;
				}
			}
			
			if( card != null ) {
				if (cemeteryDeckImpl.getAllCards().contains(card)) {
					cemeteryDeckImpl.removeCard(card);
				} else {
					deckStackImpl.removeCard(card);
				}
				this.addCard(card);
			} else {
				// TODO: Muss hier eine Exception hin, wenn es keine Karte gibt?
			}
		}

		@Override
		public void pickNumberOfCardsWithType(int numberOfCards, CardType cardType) {
			List<Card> cards = new ArrayList<Card>();
			Card card;
			do {
				card = deckStackImpl.pickCard();
				if (card.getCardType() == cardType) {
					cards.add(card);
				}
			} while (this.handDeck.size() < numberOfCards);
			
			Collections.shuffle(cards);
			for (int i = 0; i <= numberOfCards; i++) {
				this.addCard(cards.get(i));
			}
		}
		
		public void exchangeCardsWithHandDeck(HandDeck handDeck) {
			if (handDeck instanceof HandDeckImpl) {
				HandDeckImpl otherHandDeck = (HandDeckImpl)handDeck;
				
				Collection<Card> tmp = this.handDeck;
				this.handDeck = otherHandDeck.handDeck;
				otherHandDeck.handDeck = tmp;
			}
		}
	}
	
	private class CemeteryDeckImpl implements CemeteryDeck {

		private Collection<Card> cemeteryDeck = new ArrayList<Card>();
		
		public void addCard(Card card) {
			this.cemeteryDeck.add(card);
		}
		
		public void addCards(Collection<Card> cards) {
			this.cemeteryDeck.addAll(cards);
		}
		
		public void removeCard(Card card) {
			this.cemeteryDeck.remove(card);
		}
		
		public Collection<Card> getAllCards() {
			return this.cemeteryDeck;
		}
		
		 public void clear() {
			 this.cemeteryDeck.clear();
		 }
	}
	
	private class DeckStackImpl implements DeckStack {

		private List<Card> deckStack = new ArrayList<Card>();
		
		@Override
		public void shuffle() {
			Collections.shuffle(deckStack);
		}
		
		public Card pickCard() {
			if (deckStack.isEmpty()) {
				this.refill();
			}
			
			Card result = this.deckStack.get(0);
			this.deckStack.remove(0);
			return result;
		}
		
		public void removeCard(Card card) {
			this.deckStack.remove(card);
		}
		
		private void refill() {
			deckStack.addAll(cemeteryDeckImpl.getAllCards());
			cemeteryDeckImpl.clear();
		}
		
		public Collection<Card> getAllCards() {
			return this.deckStack;
		}
	}
	
	@Override
	public DeckStack getDeck() {
		return this.deckStackImpl;
	}

	@Override
	public HandDeck getHandDeck() {
		return this.handDeckImpl;
	}

	@Override
	public CemeteryDeck getCemeteryDeck() {
		return this.cemeteryDeckImpl;
	}
}
