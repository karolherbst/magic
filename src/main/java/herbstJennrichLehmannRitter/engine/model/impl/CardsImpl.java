package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Cards;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Cards")
public class CardsImpl implements Cards {
	
	private Collection<Card> cards;

	@XmlElements(value={
		@XmlElement(name="Card", type=CardImpl.class)	
	})
	@Override
	public Collection<Card> getCards() {
		return this.cards;
	}

	@Override
	public void setCards(Collection<Card> cards) {
		this.cards = cards;
	}
}
