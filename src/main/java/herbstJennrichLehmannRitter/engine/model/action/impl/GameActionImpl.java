package herbstJennrichLehmannRitter.engine.model.action.impl;

import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.GameAction;

public class GameActionImpl implements GameAction {
	
	private Player sourcePlayer;
	private Player targetPlayer;
	
	public GameActionImpl(Player sourcePlayer, Player targetPlayer) {
		this.sourcePlayer = sourcePlayer;
		this.targetPlayer = targetPlayer;
	}

	
	@Override
	public boolean checkIfIHaveWonTheGame() {
		return this.wonLooseDicision(this.targetPlayer);
	}

	@Override
	public boolean checkIfIHaveLooseTheGame() {
		return this.wonLooseDicision(this.sourcePlayer);
	}
	

	@Override
	public boolean checkIfTheGameIsUndecided() {
		if (this.wonLooseDicision(this.sourcePlayer) && this.wonLooseDicision(this.targetPlayer)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean wonLooseDicision(Player player) {
		if (player.getTower().getActualPoints() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
