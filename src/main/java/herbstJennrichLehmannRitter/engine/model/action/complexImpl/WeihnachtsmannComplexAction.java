package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Weihnachtsmann")
public class WeihnachtsmannComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		// TODO Zufällige Karte mit Kosten>14 vom Vorratsstapel oder Kartenfriedhof auf die Hand
	}

}
