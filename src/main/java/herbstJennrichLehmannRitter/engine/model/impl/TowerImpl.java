/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.BuildingType;



/**
 * 
 * In der Implementierung des Towers werden die aktuellen Punkte des Towers für das jeweilige 
 * Spielerobjekt gespeichert. 
 *
 */
public class TowerImpl extends AbstractDefenceBuilding {

	public TowerImpl() {
		super(25);
	}
	
	@Override
	public String getName() {
		return BuildingType.TOWER.name();
	}

}
