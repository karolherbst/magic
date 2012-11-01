package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;

	private GameType gameType;
	
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	
	public GameEngineControllerImpl() {
		if (once) {
			System.out.println("WARNING: a second GameEngineController has started. In tests this is okay");
		}
		once = true;
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
		this.gameType = gameType;
	}

}
