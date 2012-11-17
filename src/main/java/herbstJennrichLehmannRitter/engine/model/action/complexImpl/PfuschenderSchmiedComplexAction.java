package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of PfuschenderSchmied Class
 *  This Class implements the complex effect for the complex Card Pfuschender Schmied.
 *  To do this, all mine cards on the enemies hand are discarded.
 */

@ComplexCard("Pfuschender Schmied")
public class PfuschenderSchmiedComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		targetPlayer.getDeck().discardAllCardsByType(CardType.MINE);
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Alle Steinbruchkarten aus der Hand ablegen";
	}
}
