package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.enums.BuildingType;


/**	Description of WallImpl Class
 *  This Class extends the AbstractDefenceBuilding Interface and implements the wall.
 *	Saves level of the wall.
 */

public class WallImpl extends AbstractDefenceBuilding {

	public WallImpl() {
		super(10);
	}
	
	@Override
	public String getName() {
		return BuildingType.WALL.name();
	}

}
