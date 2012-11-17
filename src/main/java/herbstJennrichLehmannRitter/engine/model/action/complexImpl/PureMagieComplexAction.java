package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of PureMagie Class
 *  This Class implements the complex effect for the complex Card Pure Magie.
 *  To do this, the player discards all hand cards and picks up 6 magic lab cards.
 */

@ComplexCard("Pure Magie")
public class PureMagieComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getDeck().discardAllCards();
		sourcePlayer.getDeck().pickNumberOfCardsWithType(6, CardType.MAGIC_LAB);
	}

	@Override
	public String getOwnEffectDescription() {
		return "Verwirf alle Karten und ziehe 6 zufällige Zauberlaborkarten";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
