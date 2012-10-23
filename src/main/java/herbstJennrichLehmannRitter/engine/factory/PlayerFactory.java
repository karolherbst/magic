package herbstJennrichLehmannRitter.engine.factory;

import herbstJennrichLehmannRitter.engine.model.Deck;
import herbstJennrichLehmannRitter.engine.model.Player;

/**
 * 
 * Interface für die Erstellung von Spielerobjekten
 * 
 */
public interface PlayerFactory {
	
	public Player createPlayer(String name, Deck deck, int pointsTower, int pointsWall, int resourceBuildingLvl,
			int resourceBuildingStock);

}
