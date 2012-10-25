package herbstJennrichLehmannRitter.engine.model.action.complexImpl;
import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Einhorn")
public class EinhornComplexAction implements ComplexCardAction {
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getMagicLab().getLevel() > targetPlayer.getMagicLab().getLevel()) {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(12));
		} else {
			targetPlayer.getTower().applyDamage(targetPlayer.getWall().applyDamage(8));
		}
		
	}

	@Override
	public String getOwnEffectDescription() {
		return "";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Eigenes Zauberlabor > gegnerisches Zauberlabor => 12 Schaden sonst 8 Schaden";
	}
}
