package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;

public abstract class AbstractDefenceBuilding implements DefenceBuilding {

private int actualPoints;
	
	@Override
	public int getActualPoints() {
		return this.actualPoints;
	}

	@Override
	public void setActualPoints(int points) {
		this.actualPoints = points;
	}
	
	@Override
	public void addPoints(int points) {
		this.actualPoints += points;
	}
	
	@Override
	public int applyDamage(int damage) {
		if (this.actualPoints < damage) {
			int result = damage - this.actualPoints;
			this.actualPoints = 0;
			return result;
		}
		
		this.actualPoints -= damage;
		return 0;
	}

}
