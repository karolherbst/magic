package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.WinAndLoseChecker;
import herbstJennrichLehmannRitter.engine.model.Player;

public class WinAndLoseTowerBuildingChecker extends WinAndLoseChecker {

	@Override
	public boolean hasPlayerWon(Player player) {
		return player.getTower().getActualPoints() >= 100;
	}

}
