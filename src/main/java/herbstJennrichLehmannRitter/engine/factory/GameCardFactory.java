package herbstJennrichLehmannRitter.engine.factory;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;

/**
 * Interface für die Erstellung von Kartenobjekten
 */
public interface GameCardFactory {
	
	public Card createCard(String card);

	public Collection<Card> createDefaultDeck();
}
