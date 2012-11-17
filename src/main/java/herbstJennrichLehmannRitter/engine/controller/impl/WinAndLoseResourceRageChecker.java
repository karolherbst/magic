package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.WinAndLoseChecker;
import herbstJennrichLehmannRitter.engine.model.Player;

/** Description of WinAndLoseResourceRageChecker Class
 *  This Class extends the WindAndLoseChecker for the game mode Ressource Rage.
 */

public class WinAndLoseResourceRageChecker extends WinAndLoseChecker {

	@Override
	public boolean hasPlayerWon(Player player) {
		return player.getMagicLab().getStock() >= 400
				|| player.getMine().getStock() >= 400
				|| player.getDungeon().getStock() >= 400;
	}

}
