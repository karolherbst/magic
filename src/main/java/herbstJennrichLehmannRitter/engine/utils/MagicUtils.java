package herbstJennrichLehmannRitter.engine.utils;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;

public abstract class MagicUtils {

	private MagicUtils() {
		// Utils should never be instanciated
	}
	
	public void removeCardFromHandDeck(Player player, Card card) {
		player.getHandDeck().remove(card);
		player.getCemeteryDeck().add(card);
	}
}
