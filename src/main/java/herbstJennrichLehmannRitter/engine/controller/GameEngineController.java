package herbstJennrichLehmannRitter.engine.controller;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;

import java.util.Collection;


public interface GameEngineController {

	public GameCardFactory getGameCardFactory();
	
	public void start(GameType gameType);
	public void stop();
	
	public Player createPlayer(String name, Collection<String> cardNames);
	
	public Data createDataForPlayer(Player player, Player enemy);
	
	public void playCard(Card card, Player player, Player enePlayer);
	public void discardCard(Card card, Player player);
}
