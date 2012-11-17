package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Weihnachtsmann Class
 *  This Class implements the complex effect for the complex Card Weihnachtsmann.
 *  To do this, the player picks up a random card with costs higher than 14.
 */

@ComplexCard("Weihnachtsmann")
public class WeihnachtsmannComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getDeck().pickCardFromDeckStackOrCemeteryDeckWithCostAbove(14);
	}

	@Override
	public String getOwnEffectDescription() {
		return "Zufällige Karte mit Kosten>14 vom Vorratsstapel oder Friedhof ziehen";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}

}
