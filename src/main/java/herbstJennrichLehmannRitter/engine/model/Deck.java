package herbstJennrichLehmannRitter.engine.model;


/**
 * 
 * Interface, für die Karten
 *
 */
public interface Deck {
	
	public DeckStack getDeck();
	public HandDeck getHandDeck();
	public CemeteryDeck getCemeteryDeck();

}
