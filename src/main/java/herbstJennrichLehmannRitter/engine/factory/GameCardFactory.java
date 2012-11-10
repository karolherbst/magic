package herbstJennrichLehmannRitter.engine.factory;

import herbstJennrichLehmannRitter.engine.exception.GameCardFactoryException;
import herbstJennrichLehmannRitter.engine.model.Card;

import java.io.Reader;
import java.io.Writer;
import java.util.Collection;

/**
 * 
 * Interface für die Erstellung von Kartenobjekten
 * 
 */
public interface GameCardFactory {
	
	public Card createCard(String card);

	public Collection<Card> createDefaultDeck();
	
	public Collection<Card> createCardsFromNames(Collection<String> names);
	
	public Collection<Card> getAllPossibleCards();
	
	public Collection<String> getAllPossibleCardNames();
	
	public void saveToXml(Collection<String> cardNames, Writer destination) throws GameCardFactoryException;
	
	public Collection<Card> loadFromXml(Reader source) throws GameCardFactoryException;
}
