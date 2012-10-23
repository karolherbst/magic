package herbstJennrichLehmannRitter.engine.model.action.complexImpl;

import herbstJennrichLehmannRitter.engine.annotation.ComplexCard;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;

@ComplexCard("Prisma")
public class PrismaComplexAction implements ComplexCardAction {

	@Override
	public void applyActionOnPlayer(Player sourcePlayer, Player targetPlayer) {
		// TODO Ziehe eine Karte, verwirf eine Karte, spiele noch eine Karte
	}

}
