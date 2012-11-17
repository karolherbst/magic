package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of BlitzUndDonner Class
 *  This Class implements the complex effect for the complex Card Blitz und Donner.
 *  To do this, the game checks, if the players tower health is higher than the enemy tower health. 
 *  If this is the case, the enemies tower gets 8 damage. Otherwise the enemy gets 8 damage.
 */

@ComplexCard("Blitz und Donner")
public class BlitzUndDonnerComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getTower().getActualPoints() > targetPlayer.getTower().getActualPoints()) {
			targetPlayer.getTower().applyDamage(8);
		} else {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(8));
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn der eigene Turm größer als der des Gegners ist, " +
				"werden 8 Turmschaden und sonst 8 Schaden zugefügt";
	}

}
