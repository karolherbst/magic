package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

/** Description of Paritaet Class
 *  This Class implements the complex effect for the complex Card Paritaet.
 *  To do this, the players and the enemies magic lab are set on the highest level of the game.
 */

@ComplexCard("Parität")
public class ParitaetComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		if (sourcePlayer.getMagicLab().getLevel() > targetPlayer.getMagicLab().getLevel()) {
			targetPlayer.getMagicLab().setLevel(sourcePlayer.getMagicLab().getLevel());
		} else {
			sourcePlayer.getMagicLab().setLevel(targetPlayer.getMagicLab().getLevel());
		}
	}

	@Override
	public String getOwnEffectDescription() {
		return "Zauberlabor auf höchste Zauberlaborstufe im Spiel setzen";
	}

	@Override
	public String getEnemyEffectDescription() {
		return "Zauberlabor auf höchste Zauberlaborstufe im Spiel setzen";
	}

}
