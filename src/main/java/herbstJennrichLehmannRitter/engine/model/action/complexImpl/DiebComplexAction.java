package herbstJennrichLehmannRitter.engine.model.action.complexImpl;
import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Einhorn")
public class DiebComplexAction implements ComplexCardAction {
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		// TODO: Gegner verliert 10 Kristalle und 5 Ziegel, die H ̈alfte des Verlusts erhält man selbst (aufgerundet)
		if (targetPlayer.getMagicLab().getStock() < 10){
			targetPlayer.getMagicLab().reduceStock(10);
			sourcePlayer.getMagicLab().addStock(5);
		}
		else {
			
		}
		
	}
}
