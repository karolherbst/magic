package herbstJennrichLehmannRitter.engine.model.xml;

import javax.xml.bind.annotation.XmlElement;

import herbstJennrichLehmannRitter.engine.model.action.CardAction;

public class XmlCardAction implements CardAction {

	private int amountCardDraw;
	private int ownAmountCardDiscard;
	private int enemyAmountCardDiscard;
	private boolean playCards;
	
	@XmlElement(name="DrawCard")
	@Override
	public int getAmountCardDraw() {
		return this.amountCardDraw;
	}

	public void setAmountCardDraw(int amountCardDraw) {
		this.amountCardDraw = amountCardDraw;
	}

	@XmlElement(name="OwnDiscardCard")
	@Override
	public int getOwnAmountCardDiscard() {
		return this.ownAmountCardDiscard;
	}

	public void setOwnAmountCarddiscard(int ownAmountCardDiscard) {
		this.ownAmountCardDiscard = ownAmountCardDiscard;
	}
	
	@XmlElement(name="EnemyDiscardCard")
	@Override
	public int getEnemyAmountCardDiscard() {
		return this.enemyAmountCardDiscard;
	}

	public void setEnemyAmountCarddiscard(int enemyAmountCardDiscard) {
		this.enemyAmountCardDiscard = enemyAmountCardDiscard;
	}

	@XmlElement(name="PlayAnotherCard")
	@Override
	public boolean getPlayCards() {
		return this.playCards;
	}

	public void setPlayCards(boolean playCards) {
		this.playCards = playCards;
	}
}
