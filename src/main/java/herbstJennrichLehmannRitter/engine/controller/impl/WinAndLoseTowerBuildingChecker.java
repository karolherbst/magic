package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.WinAndLoseChecker;
import herbstJennrichLehmannRitter.engine.model.Player;

/** Description of WinAndLoseResourceRageChecker Class
 *  This Class extends the WindAndLoseChecker for the game mode Ressource Rage.
 */

public class WinAndLoseTowerBuildingChecker extends WinAndLoseChecker {

	@Override
	public boolean hasPlayerWon(Player player) {
		return player.getTower().getActualPoints() >= 100;
	}

}
