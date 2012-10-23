package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Blitz und Donner")
public class BlitzUndDonnerComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getTower().getActualPoints() > targetPlayer.getTower().getActualPoints() ) {
			targetPlayer.getTower().applyDamage(8);
		} else {
			targetPlayer.getTower().applyDamage(6);
		}
	}

}