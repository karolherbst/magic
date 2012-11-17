package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Elfische Bogenschützen")
public class ElfischeBogenschuetzenComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getWall().getActualPoints() > targetPlayer.getWall().getActualPoints()) {
			targetPlayer.getTower().applyDamage(6);
		} else {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(6));
		}
	}
	
	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn die eigene Mauer mehr Leben hat, als die gegnerische Mauer, " +
				"dann werden dem Gegner 6 Turmschaden zugefügt, " +
				"sonst nur 6 Schaden.";
	}
}
