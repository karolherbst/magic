package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Spionage Class
 *  This Class implements the complex effect for the complex Card Spionage.
 *  To do this, the game checks, if the players mine level is lower than the enemies. If this is the case, the players 
 *  mine gets the same level as the enemies mine.
 */

@ComplexCard("Spionage")
public class SpionageComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if( sourcePlayer.getMine().getLevel() < targetPlayer.getMine().getLevel() ) {
			sourcePlayer.getMine().setLevel(targetPlayer.getMine().getLevel());
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn dein Steinbruchlevel niedriger als das des Gegners ist, " +
				"wird es auf die Stufe des Gegners angehoben";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
