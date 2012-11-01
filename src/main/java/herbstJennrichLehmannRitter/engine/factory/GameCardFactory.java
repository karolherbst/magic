package herbstJennrichLehmannRitter.engine.factory;

import herbstJennrichLehmannRitter.engine.model.Card;

import java.util.Collection;

/**
 * 
 * Interface für die Erstellung von Kartenobjekten
 * 
 */
public interface GameCardFactory {
	
	public Card createCard(String card);

	public Collection<Card> createDefaultDeck();
	
	public Collection<Card> getAllPossibleCards();
	
	public void saveToXml(Collection<String> cardNames, String path);
	
	public Collection<Card> loadFromXml(String path);
}
