package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Glasperlen")
public class GlasperlenComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getTower().getActualPoints() < targetPlayer.getTower().getActualPoints()) {
			sourcePlayer.getTower().addPoints(2);
		} else {
			sourcePlayer.getTower().addPoints(1);
		}
			
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn der eigene Turm kleiner als der des Gegner ist, wird er um 2 erhöht, sonst um 1";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}

}
