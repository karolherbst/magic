package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.exception.GameCardFactoryException;
import herbstJennrichLehmannRitter.engine.exception.GameCardFactoryException.CARD_FACTORY_ERROR;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.action.CardAction;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;
import herbstJennrichLehmannRitter.engine.model.action.impl.CardActionImpl;
import herbstJennrichLehmannRitter.engine.model.action.impl.ResourceActionImpl;

public class CardImpl extends AbstractCard {

	private final String name;
	private final CardType cardType;
	private final int costBrick;
	private final int costMonsters;
	private final int costCrystal;
	private final CardAction cardAction;
	private final ResourceAction ownResourceActions;
	private final ResourceAction enemyResourceActions;
	private final ComplexCardAction complexCardAction;
	private final boolean canBeDiscarded;

	
	public CardImpl(Card card) {
		
		if (card == null) {
			throw new GameCardFactoryException(CARD_FACTORY_ERROR.INTERNAL_CARD_WAS_NULL);
		}

		this.name = card.getName();
		this.cardType = card.getCardType();
		this.costBrick = card.getCostBrick();
		this.costMonsters = card.getCostMonsters();
		this.costCrystal = card.getCostCrystal();
		
		if (card.getCardAction() != null) {
			this.cardAction = new CardActionImpl(card.getCardAction());
		} else {
			this.cardAction = null;
		}
		
		if (card.getOwnResourceAction() != null) {
			this.ownResourceActions = new ResourceActionImpl(card.getOwnResourceAction());
		} else {
			this.ownResourceActions = null;
		}
		
		if (card.getEnemyResourceAction() != null) {
			this.enemyResourceActions = new ResourceActionImpl(card.getEnemyResourceAction());
		} else {
			this.enemyResourceActions = null;
		}
		
		this.complexCardAction = card.getComplexCardAction();
		this.canBeDiscarded = card.getCanBeDiscarded();
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
		return this.costMonsters;
	}

	@Override
	public int getCostCrystal() {
		return this.costCrystal;
	}

	@Override
	public ResourceAction getOwnResourceAction() {
		return this.ownResourceActions;
	}
	
	@Override
	public ResourceAction getEnemyResourceAction() {
		return this.enemyResourceActions;
	}

	@Override
	public ComplexCardAction getComplexCardAction() {
		return this.complexCardAction;
	}

	@Override
	public CardAction getCardAction() {
		return this.cardAction;
	}
	
	@Override
	public boolean getCanBeDiscarded() {
		return this.canBeDiscarded;
	}
	
}
