package herbstJennrichLehmannRitter.engine.model.action.impl;

import herbstJennrichLehmannRitter.engine.model.action.CardAction;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;

public class CardActionImpl implements CardAction {

	private final int amountCardDraw;
	private final int ownAmountCardDiscard;
	private final int enemyAmountCardDiscard;
	private final boolean playCards;
	
	public CardActionImpl(CardAction cardAction) {
		if (cardAction == null) {
			this.amountCardDraw = 0;
			this.ownAmountCardDiscard = 0;
			this.enemyAmountCardDiscard = 0;
			this.playCards = false;

		} else {
			this.amountCardDraw = cardAction.getAmountCardDraw();
			this.ownAmountCardDiscard = cardAction.getOwnAmountCardDiscard();
			this.enemyAmountCardDiscard = cardAction.getEnemyAmountCardDiscard();
			this.playCards = cardAction.getPlayCards();
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
	public String getOwnEffectDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		MagicUtils.addValueToStringBuilder("Karte ablegen", Integer.valueOf(getOwnAmountCardDiscard()), 
				stringBuilder);
		MagicUtils.addValueToStringBuilder("Karte ziehen", Integer.valueOf(getAmountCardDraw()), 
				stringBuilder);
		if (getPlayCards() == true) {
			MagicUtils.addValueToStringBuilder("noch eine Karte spielen", stringBuilder);
		}
		return stringBuilder.toString();
	}
	
	@Override
	public String getEnemyEffectDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		MagicUtils.addValueToStringBuilder("Karte ablegen", Integer.valueOf(getEnemyAmountCardDiscard()), 
				stringBuilder);
		
		return stringBuilder.toString();
	}	
}
