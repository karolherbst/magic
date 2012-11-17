package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Grundstein Class
 *  This Class implements the complex effect for the complex Card Grundstein.
 *  To do this, the game checks, if the players wall is destroyed. 
 *  If this is the case, the players wall gets 6 points, otherwise the players wall gets 3 points.
 */

@ComplexCard("Grundstein")
public class GrundsteinComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getWall().getActualPoints() == 0) {
			sourcePlayer.getWall().addPoints(6);
		} else {
			sourcePlayer.getWall().addPoints(3);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn die eigene Mauer zerstört wurde, wird die Mauer um 6 erhöht, sonst nur um 3";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
