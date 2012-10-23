package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Parität")
public class ParitaetComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getMagicLab().getLevel() > targetPlayer.getMagicLab().getLevel()) {
			targetPlayer.getMagicLab().setLevel(sourcePlayer.getMagicLab().getLevel());
		} else {
			sourcePlayer.getMagicLab().setLevel(targetPlayer.getMagicLab().getLevel());
		}
	}

}
