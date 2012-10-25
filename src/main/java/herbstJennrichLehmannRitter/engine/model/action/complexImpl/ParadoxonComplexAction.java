package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Paradoxon")
public class ParadoxonComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getDeck().exchangeCardsWithHandDeck(targetPlayer.getDeck());
	}

	@Override
	public String getOwnEffectDescription() {
		return "Tausche Kartenhand mit dem Gegner";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}

}
