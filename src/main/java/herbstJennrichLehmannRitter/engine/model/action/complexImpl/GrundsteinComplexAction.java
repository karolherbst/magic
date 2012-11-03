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

	@Override
	public String getOwnEffectDescription() {
		return "Wenn die eigene Mauer zerstört wurde, wird die Mauer um 6 erhöht, sonst nur um 3";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
