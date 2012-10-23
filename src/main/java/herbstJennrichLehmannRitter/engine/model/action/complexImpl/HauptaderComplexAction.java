package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Hauptader")
public class HauptaderComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if( sourcePlayer.getMine().getLevel() < targetPlayer.getMine().getLevel()) {
			sourcePlayer.getMine().addLevel(2);
		} else {
			sourcePlayer.getMine().addLevel(1);
		}
	}
}