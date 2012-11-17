package herbstJennrichLehmannRitter.engine.controller;

import herbstJennrichLehmannRitter.engine.model.Player;

/** Description of WinAndLoseChecker Class
 *  This abstract Class implements two boolean, which determine if the player has won or lost.
 *  This is the interface from the server that answers to questions from the client.
 */

public abstract class WinAndLoseChecker {

	public abstract boolean hasPlayerWon(Player player);
	
	public final boolean hasPlayerLost(Player player) {
		return player.getTower().getActualPoints() <= 0;
	}
	
}
