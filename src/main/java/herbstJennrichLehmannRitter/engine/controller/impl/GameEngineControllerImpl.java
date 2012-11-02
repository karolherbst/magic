package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.action.GameAction;
import herbstJennrichLehmannRitter.engine.model.action.impl.GameActionImpl;
import herbstJennrichLehmannRitter.server.GameServer;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;

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
