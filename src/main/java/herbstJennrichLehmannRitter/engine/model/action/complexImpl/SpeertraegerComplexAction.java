package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Speertraeger Class
 *  This Class implements the complex effect for the complex Card Speertraeger.
 *  To do this, the game checks, if the players wall is higher than the enemies. If this is the case, the enemy 
 *  suffers 3 damage. If not, the enemy suffers 2 damage. 
 */

@ComplexCard("Speerträger")
public class SpeertraegerComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getWall().getActualPoints() > targetPlayer.getWall().getActualPoints()) {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(3));
		} else {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(2));
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn die Mauer größer der gegnerischen Mauer dann 3 Schaden sonst 2 Schaden";
	}
}
