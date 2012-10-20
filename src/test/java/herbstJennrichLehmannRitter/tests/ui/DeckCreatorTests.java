package herbstJennrichLehmannRitter.tests.ui;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ui.DeckCreator;
import herbstJennrichLehmannRitter.ui.impl.DeckCreatorImpl;

import org.junit.Test;

public class DeckCreatorTests {

	@Test
	public void test() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Architektur");
		
		DeckCreator deckCreator = new DeckCreatorImpl();
		deckCreator.addCard(card);
		
		Collection<Card> arrayCard = new ArrayList<Card>();
		arrayCard.add(card);
		
		assertEquals(deckCreator, arrayCard);
	}


}
