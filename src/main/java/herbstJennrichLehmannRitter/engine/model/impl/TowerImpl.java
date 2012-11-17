/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.BuildingType;

/**	Description of TowerImpl Class
 *  This Class extends the AbstractDefenceBuilding Interface and implements the tower.
 *	Saves level of the tower.
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
