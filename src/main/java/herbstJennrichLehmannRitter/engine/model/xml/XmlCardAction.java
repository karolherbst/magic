package herbstJennrichLehmannRitter.engine.model.xml;

import herbstJennrichLehmannRitter.engine.model.action.CardAction;

public class XmlCardAction implements CardAction {

	private int amountCardDraw;
	private int ownAmountCardDiscard;
	private int enemyAmountCardDiscard;
	private boolean playCards;
	private int damage;
	
	@Override
	public int getAmountCardDraw() {
		return this.amountCardDraw;
	}

	public void setAmountCardDraw(int amountCardDraw) {
		this.amountCardDraw = amountCardDraw;
	}

	@Override
	public int getOwnAmountCardDiscard() {
		return this.ownAmountCardDiscard;
	}

	public void setOwnAmountCarddiscard(int ownAmountCardDiscard) {
		this.ownAmountCardDiscard = ownAmountCardDiscard;
	}
	
	@Override
	public int getEnemyAmountCardDiscard() {
		return this.enemyAmountCardDiscard;
	}

	public void setEnemyAmountCarddiscard(int enemyAmountCardDiscard) {
		this.enemyAmountCardDiscard = enemyAmountCardDiscard;
	}

	@Override
	public boolean getPlayCards() {
		return this.playCards;
	}

	public void setPlayCards(boolean playCards) {
		this.playCards = playCards;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

}
