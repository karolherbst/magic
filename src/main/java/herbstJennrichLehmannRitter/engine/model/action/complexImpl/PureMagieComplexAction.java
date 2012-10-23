package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Pure Magie")
public class PureMagieComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getHandDeck().removeAll(sourcePlayer.getHandDeck());
		
		for (Card card : sourcePlayer.getHandDeck()) {
		}
		// TODO Verwirf alle Karten, ziehe 6 zuf ̈allige Zauberlabor-Karten
	}

}
