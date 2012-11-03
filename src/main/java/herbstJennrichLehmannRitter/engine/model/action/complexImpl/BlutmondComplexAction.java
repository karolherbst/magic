package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Blutmond")

public class BlutmondComplexAction implements ComplexCardAction {
	
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getDeck().discardAllCards();
		sourcePlayer.getDeck().pickNumberOfCardsWithType(6, CardType.DUNGEON);
	}

	@Override
	public String getOwnEffectDescription() {
		return "Es werden alle Karten auf der Hand verworfen und 6 zufällige Verlieskarten gezogen";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
