package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Barracke Class
 *  This Class implements the complex effect for the complex Card Barracke.
 *  To do this, the game checks, if the players dungeon level is lower than the enemy dungeon level. 
 *  If this is the case, the players dungeon level is increased by 1.
 */

@ComplexCard("Barracke")
public class BarrackeComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getDungeon().getLevel() < targetPlayer.getDungeon().getLevel()) {
			sourcePlayer.getDungeon().setLevel(sourcePlayer.getDungeon().getLevel() + 1);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn das eigene Verlies kleiner als das des Gegners ist, wird es um 1 erhöht";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
