package herbstJennrichLehmannRitter.engine.factory;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;

import java.util.Collection;

/**
 * 
 * Interface für die Erstellung von Spielerobjekten
 * 
 */
public interface PlayerFactory {
	
	public Player createPlayer(String name, Collection<Card> cards, int pointsTower, int pointsWall, int resourceBuildingLvl,
			int resourceBuildingStock);
	
	public Player createCopyForEnemy(Player player);

}
