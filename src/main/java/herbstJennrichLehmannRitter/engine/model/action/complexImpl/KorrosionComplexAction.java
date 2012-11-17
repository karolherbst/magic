package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Korrosion")
public class KorrosionComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (targetPlayer.getWall().getActualPoints() > 0) {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(10));
		} else {
			targetPlayer.getTower().applyDamage(7);
		}
	}
	
	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Wenn gegnerische Mauer>0 dann 10 Schaden sonst 7 Schaden";
	}
}
