package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;

import java.util.Collection;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;
	private static final int DEFAULT_TOWER_POINTS = 25;
	private static final int DEFAULT_WALL_POINTS = 10;
	private static final int DEFAULT_RSC_BUILDING_LEVEL = 1;
	private static final int DEFAULT_RSC_BUILDING_STOCK = 15;

	private GameType gameType;
	
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	
	public GameEngineControllerImpl(GameCardFactory gameCardFactory) {
		if (once) {
			System.out.println("WARNING: a second GameEngineController has started. In tests this is okay");
		}
		once = true;
		
		this.gameCardFactory = gameCardFactory;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		once = false;
	}

	@Override
	public GameCardFactory getGameCardFactory() {
		return this.gameCardFactory;
	}
	
	@Override
	public Player createPlayer(String name, Collection<String> cardNames) {
		
		Collection<Card> cards = this.gameCardFactory.createCardsFromNames(cardNames);
		
		return this.playerFactory.createPlayer(name, cards, DEFAULT_TOWER_POINTS, DEFAULT_WALL_POINTS,
				DEFAULT_RSC_BUILDING_LEVEL, DEFAULT_RSC_BUILDING_STOCK);
	}

	@Override
	public void start(GameType gameType) {
		// TODO: add class for win and lose checks
		// FIXME: From where do I get the sourcePlayer and TargetPlayer? (Sebastian)
//		GameAction gameAction = new GameActionImpl(sourcePlayer, targetPlayer);
		this.gameType = gameType;
	}
	
	@Override
	public void stop() {
		
	}

}
