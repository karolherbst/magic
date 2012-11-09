package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.WinAndLoseChecker;
import herbstJennrichLehmannRitter.engine.model.Player;

public class WinAndLoseResourceRageChecker extends WinAndLoseChecker {

	@Override
	public boolean hasPlayerWon(Player player) {
		return player.getMagicLab().getStock() >= 400
				|| player.getMine().getStock() >= 400
				|| player.getDungeon().getStock() >= 400;
	}

}
