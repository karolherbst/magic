package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Blutmond")

public class BlutmondComplexAction implements ComplexCardAction {
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		// TODO: Verwirf alle Karten, ziehe 6 zufällige Verlies-Karten
		
		sourcePlayer.getHandDeck().removeAll(sourcePlayer.getHandDeck());
		 int i = 0;
		 while (i < 6){
			 sourcePlayer.getHandDeck.pickCard(card.getCardType() == CardType.CARD_TYPE_DUNGEON);
			 i++;
		 }
		
	}
}
