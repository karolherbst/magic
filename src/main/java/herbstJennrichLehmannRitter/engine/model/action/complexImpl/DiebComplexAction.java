package herbstJennrichLehmannRitter.engine.model.action.complexImpl;
import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Einhorn")
public class DiebComplexAction implements ComplexCardAction {
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		// TODO: Gegner verliert 10 Kristalle und 5 Ziegel, die Hälfte des Verlusts erhält man selbst (aufgerundet)
		if (targetPlayer.getMagicLab().getStock() > 10){
			targetPlayer.getMagicLab().reduceStock(10);
			sourcePlayer.getMagicLab().addStock(5);
		}
		else {
			sourcePlayer.getMagicLab().addStock(targetPlayer.getMagicLab().getStock() / 2);
			targetPlayer.getMagicLab().reduceStock(targetPlayer.getMagicLab().getStock());	
		}
		if (targetPlayer.getMine().getStock() > 5){
			targetPlayer.getMine().reduceStock(5);
			sourcePlayer.getMine().addStock(5/2);
		}
		else {
			sourcePlayer.getMine().addStock(targetPlayer.getMine().getStock() / 2);
			targetPlayer.getMine().reduceStock(targetPlayer.getMine().getStock());
		}
	}
}
