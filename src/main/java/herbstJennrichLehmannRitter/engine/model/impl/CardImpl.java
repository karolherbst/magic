package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.enums.RessourceType;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.action.CardAction;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;
import herbstJennrichLehmannRitter.engine.model.action.impl.ResourceActionImpl;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;

public class CardImpl implements Card {

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
			throw new EngineCouldNotStartException("CardImpl needs a card!=null for constructor");
		}

		this.name = card.getName();
		this.cardType = card.getCardType();
		this.costBrick = card.getCostBrick();
		this.costMonsters = card.getCostMonsters();
		this.costCrystal = card.getCostCrystal();
		
		if (card.getCardAction() != null) {
			this.cardAction = card.getCardAction();
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
	
	private String getCostDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		MagicUtils.addValueToStringBuilder(RessourceType.MONSTER, Integer.valueOf(getCostMonsters()), stringBuilder);
		MagicUtils.addValueToStringBuilder(RessourceType.CRYSTAL, Integer.valueOf(getCostCrystal()), stringBuilder);
		MagicUtils.addValueToStringBuilder(RessourceType.BRICK, Integer.valueOf(getCostBrick()), stringBuilder);
		
		return stringBuilder.toString();
	}
	
	private String getOwnEffectDescription() {
		if (getOwnResourceAction() != null) {
			return getOwnResourceAction().toString();
		}
		return "";
	}
	
	private String getEnemyEffectDescription() {
		if (getEnemyResourceAction() != null) {
			return getEnemyResourceAction().toString();
		}
		return "";
	}
	
	@Override
	public String toString() {
		// TODO: spezial action
		StringBuilder stringBuilder = new StringBuilder(getName());
		
		String costDescription = getCostDescription();
		String ownEffectDescription = getOwnEffectDescription();
		String enemyEffectDescription = getEnemyEffectDescription();
		
		if (costDescription != null || ownEffectDescription != null || enemyEffectDescription != null) {
			stringBuilder.append('[');
			boolean somethingWasAppended = false;
			
			if (costDescription != null && costDescription.length() > 0) {
				stringBuilder.append("Kosten: ");
				stringBuilder.append(costDescription);
				somethingWasAppended = true;
			}
			
			if (ownEffectDescription != null && ownEffectDescription.length() > 0) {
				if (somethingWasAppended) {
					stringBuilder.append("; ");
				}
				stringBuilder.append("Selbst: ");
				stringBuilder.append(ownEffectDescription);
				somethingWasAppended = true;
			}
			
			if (enemyEffectDescription != null && enemyEffectDescription.length() > 0) {
				if (somethingWasAppended) {
					stringBuilder.append("; ");
				}
				stringBuilder.append("Gegner: ");
				stringBuilder.append(enemyEffectDescription);
				somethingWasAppended = true;
			}
			
			stringBuilder.append(']');
		}
		
		return stringBuilder.toString();
	}

}
