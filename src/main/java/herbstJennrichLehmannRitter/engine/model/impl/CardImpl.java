package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.SimpleCardAction;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"name", "cardType", "costBrick", "costCrystal", "costMonsters"})
public class CardImpl implements Card {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCardType(CardType cardType) {
		// TODO Auto-generated method stub

	}

	public CardType getCardType() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCostBrick(int costBrick) {
		// TODO Auto-generated method stub

	}

	public int getCostBrick() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCostMonsters(int costMonsters) {
		// TODO Auto-generated method stub

	}

	public int getCostMonsters() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setCostCrystal(int costCrystal) {
		// TODO Auto-generated method stub

	}

	public int getCostCrystal() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSimpleCardAction(SimpleCardAction simpleCardAction) {
		// TODO Auto-generated method stub

	}

	@XmlTransient
	public SimpleCardAction getSimpleCardAction() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setComplexCardAction(ComplexCardAction complexCardAction) {
		// TODO Auto-generated method stub

	}

	@XmlTransient
	public ComplexCardAction getComplexCardAction() {
		// TODO Auto-generated method stub
		return null;
	}

}
