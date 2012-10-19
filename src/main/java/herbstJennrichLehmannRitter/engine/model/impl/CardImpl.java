package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.SimpleCardAction;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Card")
public class CardImpl implements Card {

	private String name;
	private CardType cardType;
	private int costBrick;
	private int costMonster;
	private int costCrystal;
	private SimpleCardAction simpleCardAction;
	private ComplexCardAction complexCardAction;
	
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="Name")
	public String getName() {
		return this.name;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@XmlElement(name="CardType")
	public CardType getCardType() {
		return this.cardType;
	}

	public void setCostBrick(int costBrick) {
		this.costBrick = costBrick;
	}

	@XmlElement(name="CostBrick")
	public int getCostBrick() {
		return this.costBrick;
	}

	public void setCostMonsters(int costMonsters) {
		this.costMonster = costMonsters;
	}

	@XmlElement(name="CostMonster")
	public int getCostMonsters() {
		return this.costMonster;
	}

	public void setCostCrystal(int costCrystal) {
		this.costCrystal = costCrystal;
	}

	@XmlElement(name="CostCrystal")
	public int getCostCrystal() {
		return this.costCrystal;
	}

	public void setSimpleCardAction(SimpleCardAction simpleCardAction) {
		this.simpleCardAction = simpleCardAction;
	}

	@XmlElement(name="SimpleCardAction", type=SimpleCardActionImpl.class)
	public SimpleCardAction getSimpleCardAction() {
		return this.simpleCardAction;
	}

	public void setComplexCardAction(ComplexCardAction complexCardAction) {
		this.complexCardAction = complexCardAction;
	}

	@XmlTransient
	public ComplexCardAction getComplexCardAction() {
		return this.complexCardAction;
	}

}
