package herbstJennrichLehmannRitter.engine.factory;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;

/**
 * 
 * Interface für die Erstellung von Spielerobjekten
 * 
 */
public interface PlayerFactory {
	
	public Player createPlayer(String name, Collection<Card> deck, int pointsTower, int pointsWall, int resourceBuildingLvl, int resourceBuildingStock);

}
