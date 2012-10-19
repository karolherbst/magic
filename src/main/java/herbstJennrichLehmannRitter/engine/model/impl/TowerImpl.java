/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;

/**
 * 
 * In der Implementierung des Towers werden die aktuellen Punkte des Towers für das jeweilige 
 * Spielerobjekt gespeichert. 
 *
 */
public class TowerImpl implements DefenceBuilding {

	private int actualPoints;
	
	@Override
	public int getActualPoints() {
		return this.actualPoints;
	}

	@Override
	public void setActualPoints(int points) {
		this.actualPoints = points;
	}

}
