package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Baumgeist Class
 *  This Class implements the complex effect for the complex Card Baumgeist.
 *  To do this, the game checks, if the players dungeon level is higher than the enemy wall level. 
 *  If this is the case, the enemies tower gets 11 damage.
 */

@ComplexCard("Baumgeist")
public class BaumgeistComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getDungeon().getLevel() > targetPlayer.getWall().getActualPoints()) {
			targetPlayer.getTower().applyDamage(11);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn das eigene Verlies größer als die gegnerische Mauer ist, " +
				"bekommt der Gegner 11 Turmschaden";
	}
}
