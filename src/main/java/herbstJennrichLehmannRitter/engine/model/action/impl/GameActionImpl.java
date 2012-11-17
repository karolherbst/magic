package herbstJennrichLehmannRitter.engine.model.action.impl;

import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.GameAction;

/** Description of GameActionImpl Class
 *  This Class implements the GameAction Interface.
 *  It implements 2 players and decides who has won.
 */

public class GameActionImpl implements GameAction {
	
	private Player sourcePlayer;
	private Player targetPlayer;
	
	public GameActionImpl(Player sourcePlayer, Player targetPlayer) {
		this.sourcePlayer = sourcePlayer;
		this.targetPlayer = targetPlayer;
	}

	
	@Override
	public boolean checkIfIHaveWonTheGame() {
		return GameActionImpl.wonLooseDicision(this.targetPlayer);
	}

	@Override
	public boolean checkIfIHaveLooseTheGame() {
		return GameActionImpl.wonLooseDicision(this.sourcePlayer);
	}
	

	@Override
	public boolean checkIfTheGameIsUndecided() {
		if (GameActionImpl.wonLooseDicision(this.sourcePlayer) && GameActionImpl.wonLooseDicision(this.targetPlayer)) {
			return true;
		} else {
			return false;
		}
	}

	private static boolean wonLooseDicision(Player player) {
		if (player.getTower().getActualPoints() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
