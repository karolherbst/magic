package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Pfuschender Schmied")
public class PfuschenderSchmiedComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		for (Card card : targetPlayer.getHandDeck()) {
			if (card.getCardType() == CardType.CARD_TYPE_MINE) {
				targetPlayer.getHandDeck().remove(card);
			}
		}
	}
}
