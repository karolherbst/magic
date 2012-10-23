package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Verschiebung")
public class VerschiebungComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		int targetWall = targetPlayer.getWall().getActualPoints();
		targetPlayer.getWall().setActualPoints(sourcePlayer.getWall().getActualPoints());
		sourcePlayer.getWall().setActualPoints(targetWall);
	}
}
