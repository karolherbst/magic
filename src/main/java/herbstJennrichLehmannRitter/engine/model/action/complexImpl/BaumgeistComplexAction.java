package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Baumgeist")
public class BaumgeistComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getDungeon().getLevel() > targetPlayer.getWall().getActualPoints()) {
			targetPlayer.getTower().applyDamage(11);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn das eigene Verlies größer als die gegnerische Mauer ist, bekommt der Gegner 11 Turmschaden";
	}
}
