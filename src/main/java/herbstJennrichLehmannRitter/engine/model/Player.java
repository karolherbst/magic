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

	public Collection<Card> getDeck();
	public Collection<Card> getHandDeck();
	public Collection<Card> getCemeteryDeck();

	public ResourceBuilding getMine();
	public ResourceBuilding getDungeon();
	public ResourceBuilding getMagicLab();

	public DefenceBuilding getTower();
	public DefenceBuilding getWall();
}
