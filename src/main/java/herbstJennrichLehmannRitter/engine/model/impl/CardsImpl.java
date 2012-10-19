package herbstJennrichLehmannRitter.engine.model.impl;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cards")
public class CardsImpl {
	private Collection<CardImpl> cards;

	public Collection<CardImpl> getCards() {
		return cards;
	}

	public void setCards(Collection<CardImpl> cards) {
		this.cards = cards;
	}
}
