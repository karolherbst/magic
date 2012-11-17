package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Speikaefer Class
 *  This Class implements the complex effect for the complex Card Speikaefer.
 *  To do this, the game checks, if the enemy's wall is down to level 'zero'. If the wall is down to 'zero', the enemy
 *  suffers 10 damage. If not, the enemy suffers 6 damage. * 
 */

@ComplexCard("Speikäfer")
public class SpeikaeferComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (targetPlayer.getWall().getActualPoints() == 0) {
			targetPlayer.getTower().applyDamage(10);
		} else {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(6));
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn gegnerische Mauer=0 dann 10 Schaden sonst 6 Schaden";
	}
}
