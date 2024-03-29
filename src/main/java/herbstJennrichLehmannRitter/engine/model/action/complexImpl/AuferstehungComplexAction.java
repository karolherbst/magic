package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.enums.BuildingType;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Auferstehung Class
 *  This Class implements the complex effect for the complex Card Auferstehung.
 *  To do this, the game adds 30% to the players tower. 
 */

@ComplexCard("Auferstehung")
public class AuferstehungComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		sourcePlayer.getTower().setActualPoints((int)(sourcePlayer.getTower().getActualPoints() * 1.3));
	}

	@Override
	public String getOwnEffectDescription() {
		return "+30% " + BuildingType.TOWER;
	}

	@Override
	public String getEnemyEffectDescription() {
		return "";
	}
}
