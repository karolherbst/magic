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
		return "Wenn das eigene Zauberlabor größer als das des Gegners ist, wird 12 Schaden zugefügt, sonst nur 8";
	}
}
