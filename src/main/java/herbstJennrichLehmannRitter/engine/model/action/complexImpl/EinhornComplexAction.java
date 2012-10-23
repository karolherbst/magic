package herbstJennrichLehmannRitter.engine.model.action.complexImpl;
import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Einhorn")
public class EinhornComplexAction implements ComplexCardAction {
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getMagicLab().getLevel() > targetPlayer.getMagicLab().getLevel()){
			
		}
	}
}
