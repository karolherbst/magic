package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Hauptader Class
 *  This Class implements the complex effect for the complex Card Hauptader.
 *  To do this, the game checks, if the players mine level is lower than the enemies mine level. 
 *  If this is the case, the players mine gets 2 points. Otherwise the mine gets 1 point.
 */

@ComplexCard("Hauptader")
public class HauptaderComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getMine().getLevel() < targetPlayer.getMine().getLevel()) {
			sourcePlayer.getMine().addLevel(2);
		} else {
			sourcePlayer.getMine().addLevel(1);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn der eigene Steinbruch kleiner als der des Gegners ist, " +
				"wird er um 2 erhöht, sonst nur um 1";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
