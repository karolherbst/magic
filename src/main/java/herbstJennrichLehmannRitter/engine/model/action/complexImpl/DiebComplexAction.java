package herbstJennrichLehmannRitter.engine.model.action.complexImpl;
import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Dieb Class
 *  This Class implements the complex effect for the complex Card Dieb.
 *  To do this, the enemies stock of bricks is reduced by maximum 5 and the stock of crystal is reduced by maximum 10.
 *  The player gets half the stolen amount.
 */

@ComplexCard("Dieb")
public class DiebComplexAction implements ComplexCardAction {
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
	
		if (targetPlayer.getMagicLab().getStock() > 10){
			targetPlayer.getMagicLab().reduceStock(10);
			sourcePlayer.getMagicLab().addStock(5);
		}
		else {
			sourcePlayer.getMagicLab().addStock(Math.round((float)targetPlayer.getMagicLab().getStock() / 2));
			targetPlayer.getMagicLab().reduceStock(targetPlayer.getMagicLab().getStock());	
		}
		if (targetPlayer.getMine().getStock() > 5){
			targetPlayer.getMine().reduceStock(5);
			sourcePlayer.getMine().addStock(Math.round(5f/2));
		}
		else {
			sourcePlayer.getMine().addStock(Math.round((float)targetPlayer.getMine().getStock() / 2));
			targetPlayer.getMine().reduceStock(targetPlayer.getMine().getStock());
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Man erhält die Hälfte des gegnerischen Verlustes";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Es werden maximal 10 Kristall und 5 Ziegel abgezogen";
	}
}
