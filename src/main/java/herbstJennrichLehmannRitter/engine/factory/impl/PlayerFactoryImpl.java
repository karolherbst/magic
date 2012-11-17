/**
 * 
 */
package herbstJennrichLehmannRitter.engine.factory.impl;

import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.DefenceBuilding;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.impl.DeckImpl;
import herbstJennrichLehmannRitter.engine.model.impl.DungeonImpl;
import herbstJennrichLehmannRitter.engine.model.impl.MagicLabImpl;
import herbstJennrichLehmannRitter.engine.model.impl.MineImpl;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;
import herbstJennrichLehmannRitter.engine.model.impl.TowerImpl;
import herbstJennrichLehmannRitter.engine.model.impl.WallImpl;

import java.util.Collection;

/**	Description of PlayerFactoryImpl Class
 *  This Class implements the PlayerFactory Interface.
 *  The PlayerFactory creates playerObjects and assigns all needed Data.
 */
public class PlayerFactoryImpl implements PlayerFactory {

	@Override
	public Player createPlayer(String name, Collection<Card> cards, int pointsTower, int pointsWall, 
			int resourceBuildingLvl, 
			int resourceBuildingStock) {
		
		ResourceBuilding dungeon = new DungeonImpl();
		dungeon.setLevel(resourceBuildingLvl);
		dungeon.setStock(resourceBuildingStock);
		ResourceBuilding magicLab = new MagicLabImpl();
		magicLab.setLevel(resourceBuildingLvl);
		magicLab.setStock(resourceBuildingStock);
		ResourceBuilding mine = new MineImpl();
		mine.setLevel(resourceBuildingLvl);
		mine.setStock(resourceBuildingStock);
		
		DefenceBuilding tower = new TowerImpl();
		tower.setActualPoints(pointsTower);
		DefenceBuilding wall = new WallImpl();
		wall.setActualPoints(pointsWall);
		
		PlayerImpl newPlayer = new PlayerImpl();
		newPlayer.setName(name);
		newPlayer.setDeck(new DeckImpl(cards));
		newPlayer.setDungeon(dungeon);
		newPlayer.setMagiclab(magicLab);
		newPlayer.setMine(mine);
		newPlayer.setTower(tower);
		newPlayer.setWall(wall);
		
		return newPlayer;
	}
	
	@Override
	public Player createCopyForEnemy(Player player) {
		PlayerImpl copy = new PlayerImpl();
		
		copy.setName(player.getName());
		copy.setDeck(null);
		copy.setDungeon(player.getDungeon());
		copy.setMagiclab(player.getMagicLab());
		copy.setMine(player.getMine());
		copy.setTower(player.getTower());
		copy.setWall(player.getWall());
		
		return copy;
	}
}