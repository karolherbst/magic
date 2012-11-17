package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Demolieren Class
 *  This Class implements the complex effect for the complex Card Demolieren.
 *  To do this, the enemies wall is destroyed, or in other words, set to zero.
 */

@ComplexCard("Demolieren")
public class DemolierenComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		targetPlayer.getWall().setActualPoints(0);
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Die Mauer wird zerstört";
	}
}
