/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;

/**
 * In der Implementierung der Mauer werden die aktuellen Punkte der Mauer für das jeweilige 
 * Spielerobjekt gespeichert. 
 *
 */
public class WallImpl implements DefenceBuilding {

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
