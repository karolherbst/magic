package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Pure Magie")
public class PureMagieComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		
		// TODO Verwirf alle Karten, ziehe 6 zuf ̈allige Zauberlabor-Karten
		sourcePlayer.getHandDeck().removeAll(sourcePlayer.getHandDeck());
		 int i = 0;
		 while (i < 6){
			 sourcePlayer.getHandDeck.pickCard(card.getCardType() == CardType.CARD_TYPE_MAGIC_LAB);
			 i++;
		 }
		
	}

}
