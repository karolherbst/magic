package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.SimpleCardAction;

public class CardImpl implements Card {

	private final String name;
	private final CardType cardType;
	private final int costBrick;
	private final int costMonster;
	private final int costCrystal;
	private final SimpleCardAction simpleCardAction;
	private final ComplexCardAction complexCardAction;
	
	public CardImpl(String name, CardType cardType, int costBrick, int costMonster, int costCrystal,
			SimpleCardAction simpleCardAction, ComplexCardAction complexCardAction) {
		this.name = name;
		this.cardType = cardType;
		this.costBrick = costBrick;
		this.costMonster = costMonster;
		this.costCrystal = costCrystal;
		this.simpleCardAction = simpleCardAction;
		this.complexCardAction = complexCardAction;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public CardType getCardType() {
		return this.cardType;
	}

	@Override
	public int getCostBrick() {
		return this.costBrick;
	}

	@Override
	public int getCostMonsters() {
		return this.costMonster;
	}

	@Override
	public int getCostCrystal() {
		return this.costCrystal;
	}

	@Override
	public SimpleCardAction getSimpleCardAction() {
		return this.simpleCardAction;
	}

	@Override
	public ComplexCardAction getComplexCardAction() {
		return this.complexCardAction;
	}

}
