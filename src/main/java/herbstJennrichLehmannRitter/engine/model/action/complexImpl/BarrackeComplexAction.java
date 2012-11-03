package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Barracke")
public class BarrackeComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getDungeon().getLevel() < targetPlayer.getDungeon().getLevel()) {
			sourcePlayer.getDungeon().setLevel(sourcePlayer.getDungeon().getLevel() + 1);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn das eigene Verlies größer als das des Gegners ist, wird es um 1 erhöht";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
