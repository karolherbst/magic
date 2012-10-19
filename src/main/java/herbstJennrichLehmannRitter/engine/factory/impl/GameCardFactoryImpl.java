package herbstJennrichLehmannRitter.engine.factory.impl;

import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.model.Card;

import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class GameCardFactoryImpl implements GameCardFactory {

	private Unmarshaller unmarshaller;
	
	public GameCardFactoryImpl() {
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("herbstJennrichLehmannRitter.engine.model");
			this.unmarshaller = jaxbContext.createUnmarshaller();
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new EngineCouldNotStartException(e);
		}
	}
	
	public Card createCard(String card) {
		return null;
	}

	public Collection<Card> createDefaultDeck() {
		return null;
	}

}
