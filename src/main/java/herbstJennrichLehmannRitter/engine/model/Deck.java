package herbstJennrichLehmannRitter.engine.model;

import java.util.Collection;

/**
 * 
 * Interface, für die Karten
 *
 */
public interface Deck {
	
	public Collection<Card> getDeck();
	public Collection<Card> getHandDeck();
	public Collection<Card> getCemeteryDeck();

}
