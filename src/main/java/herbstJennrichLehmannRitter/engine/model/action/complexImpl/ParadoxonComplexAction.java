package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import java.util.Collection;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Paradoxon")
public class ParadoxonComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		Collection<Card> targetHandDeck = targetPlayer.getHandDeck();
		targetPlayer.getHandDeck().retainAll(sourcePlayer.getHandDeck());
		sourcePlayer.getHandDeck().retainAll(targetHandDeck);
	}

}
