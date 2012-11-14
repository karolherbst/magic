package herbstJennrichLehmannRitter.engine.controller;

import herbstJennrichLehmannRitter.engine.model.Player;

public abstract class WinAndLoseChecker {

	public abstract boolean hasPlayerWon(Player player);
	
	public final boolean hasPlayerLost(Player player) {
		return player.getTower().getActualPoints() <= 0;
	}
	
}
