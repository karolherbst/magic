package herbstJennrichLehmannRitter.engine.model;

import java.io.Serializable;

/**
 * 
 * Interface für das Spielerobjekt.
 * Beinhaltet alle relevanten Schnittstellen eines Spielerobjektes.
 *
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
