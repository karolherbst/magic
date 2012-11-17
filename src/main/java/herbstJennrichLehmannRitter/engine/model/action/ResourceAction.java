package herbstJennrichLehmannRitter.engine.model.action;

import java.io.Serializable;

/**	Description of ResourceAction Class
 * 	Contains all relevant information for all cards who perform only simple actions like applying damage, distributing
 * 	resources, actions on buildings and card actions.
 */
public interface ResourceAction extends Serializable {
	
	public int getTowerEffect();
	public int getWallEffect();
	public int getMineLvlEffect();
	public int getDungeonLvlEffect();
	public int getMagicLabLvlEffect();
	public int getBrickEffect();
	public int getMonsterEffect();
	public int getCrystalEffect();
	public int getDamage();
}
