package herbstJennrichLehmannRitter.engine.model.action.impl;

import herbstJennrichLehmannRitter.engine.model.action.CardAction;

public class CardActionImpl implements CardAction {

	private final int amountCardDraw;
	private final int ownAmountCardDiscard;
	private final int enemyAmountCardDiscard;
	private final boolean playCards;
	private final int damage;
	
	public CardActionImpl(CardAction cardAction) {
		if (cardAction == null) {
			this.amountCardDraw = 0;
			this.ownAmountCardDiscard = 0;
			this.enemyAmountCardDiscard = 0;
			this.playCards = false;
			this.damage = 0;
		} else {
			this.amountCardDraw = cardAction.getAmountCardDraw();
			this.ownAmountCardDiscard = cardAction.getOwnAmountCardDiscard();
			this.enemyAmountCardDiscard = cardAction.getEnemyAmountCardDiscard();
			this.playCards = cardAction.getPlayCards();
			this.damage = cardAction.getDamage();
		}
	}
	
	@Override
	public int getAmountCardDraw() {
		return this.amountCardDraw;
	}

	@Override
	public int getOwnAmountCardDiscard() {
		return this.ownAmountCardDiscard;
	}
	
	@Override
	public int getEnemyAmountCardDiscard() {
		return this.enemyAmountCardDiscard;
	}

	@Override
	public boolean getPlayCards() {
		return this.playCards;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}

}
