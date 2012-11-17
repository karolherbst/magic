package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Spionage")
public class SpeikaeferComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (targetPlayer.getWall().getActualPoints() == 0) {
			targetPlayer.getTower().applyDamage(10);
		} else {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(6));
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Wenn dein Steinbruchlevel niedriger als das des Gegners ist, " +
				"wird es auf die Stufe des Gegners angehoben";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
