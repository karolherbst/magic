package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Pure Magie")
public class PureMagieComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getDeck().getHandDeck().discardAllCards();
		sourcePlayer.getDeck().getHandDeck().pickNumberOfCardsWithType(6, CardType.CARD_TYPE_MAGIC_LAB);
	}
}
