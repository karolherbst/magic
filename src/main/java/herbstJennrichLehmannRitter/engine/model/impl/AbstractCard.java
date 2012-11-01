package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.RessourceType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;

public abstract class AbstractCard implements Card {

	@Override
	public String getCostDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		MagicUtils.addValueToStringBuilder(RessourceType.MONSTER, Integer.valueOf(getCostMonsters()), stringBuilder);
		MagicUtils.addValueToStringBuilder(RessourceType.CRYSTAL, Integer.valueOf(getCostCrystal()), stringBuilder);
		MagicUtils.addValueToStringBuilder(RessourceType.BRICK, Integer.valueOf(getCostBrick()), stringBuilder);
		
		return stringBuilder.toString();
	}
	
	@Override
	public String getOwnEffectDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		if (getOwnResourceAction() != null) {
			MagicUtils.addValueToStringBuilder(getOwnResourceAction(), stringBuilder);
		}
		
		if (getComplexCardAction() != null && getComplexCardAction().getOwnEffectDescription() != null
				&& getComplexCardAction().getOwnEffectDescription().length() > 0) {
			MagicUtils.addValueToStringBuilder(getComplexCardAction().getOwnEffectDescription(), stringBuilder);
		}
		
		return stringBuilder.toString();
	}
	
	@Override
	public String getEnemyEffectDescription() {
		StringBuilder stringBuilder = new StringBuilder();
		
		if (getEnemyResourceAction() != null) {
			MagicUtils.addValueToStringBuilder(getEnemyResourceAction(), stringBuilder);
		}
		
		if (getComplexCardAction() != null && getComplexCardAction().getEnemyEffectDescription() != null
				&& getComplexCardAction().getOwnEffectDescription().length() > 0) {
			MagicUtils.addValueToStringBuilder(getComplexCardAction().getEnemyEffectDescription(), stringBuilder);
		}
		
		return stringBuilder.toString();
	}
	
	@Override
	public String toString() {
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