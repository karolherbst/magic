package herbstJennrichLehmannRitter.engine.model.action.complexImpl;
import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Einhorn Class
 *  This Class implements the complex effect for the complex Card Einhorn.
 *  To do this, the game checks, if the players magic lab level is higher than the enemies magic lab level. 
 *  If this is the case, the enemy gets 12 damage. Otherwise the enemy gets 8 damage.
 */

@ComplexCard("Einhorn")
public class EinhornComplexAction implements ComplexCardAction {
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getMagicLab().getLevel() > targetPlayer.getMagicLab().getLevel()) {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(12));
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
		return "Wenn das eigene Zauberlabor größer als das des Gegners ist, " +
				"wird 12 Schaden zugefügt, sonst nur 8";
	}
}
