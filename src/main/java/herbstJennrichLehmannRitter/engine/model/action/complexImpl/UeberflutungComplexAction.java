package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Ueberflutung Class
 *  This Class implements the complex effect for the complex Card Ueberflutung.
 *  To do this, the player with the lowest wall gets 2 tower damage and loses 1 dungeon level.
 */

@ComplexCard("Überflutung")
public class UeberflutungComplexAction implements ComplexCardAction {

	
	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if( sourcePlayer.getWall().getActualPoints() < targetPlayer.getWall().getActualPoints()) {
			sourcePlayer.getDungeon().reduceLevel(1);
			sourcePlayer.getTower().applyDamage(2);
		} else if (targetPlayer.getWall().getActualPoints() < sourcePlayer.getWall().getActualPoints()) {
			targetPlayer.getDungeon().reduceLevel(1);
			targetPlayer.getTower().applyDamage(2);
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Spieler mit niedrigster Mauer -1 Verlies und 2 Turmschaden";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Spieler mit niedrigster Mauer -1 Verlies und 2 Turmschaden";
	}
}
