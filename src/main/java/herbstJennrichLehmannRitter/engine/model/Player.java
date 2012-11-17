package herbstJennrichLehmannRitter.engine.model;

import java.io.Serializable;

/**	Description of Player Class
 * Contains all relevant Interfaces of the Player Object.
 */

public interface Player extends Serializable {
	
	public String getName();
	public void setName(String name);
	
	public Deck getDeck();
	
	public ResourceBuilding getDungeon();
	public ResourceBuilding getMagicLab();
	public ResourceBuilding getMine();

	public DefenceBuilding getTower();
	public DefenceBuilding getWall();
}
