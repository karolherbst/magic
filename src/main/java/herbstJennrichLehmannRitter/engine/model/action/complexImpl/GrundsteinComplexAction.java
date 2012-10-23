package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Grundstein")
public class GrundsteinComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getWall().getActualPoints() == 0) {
			sourcePlayer.getWall().addPoints(6);
		} else {
			sourcePlayer.getWall().addPoints(3);
		}
	}
}
