package herbstJennrichLehmannRitter.engine.model;

import java.util.Collection;

/**
 * 
 * Interface für das Spielerobjekt.
 * Beinhaltet alle relevanten Schnittstellen eines Spielerobjektes.
 *
 */
public interface Player {
	
	public String getName();
	
	public Deck getDeck();
	
	public ResourceBuilding getDungeon();
	public ResourceBuilding getMagicLab();
	public ResourceBuilding getMine();

	public DefenceBuilding getTower();
	public DefenceBuilding getWall();
}
