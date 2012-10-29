package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;
	
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	
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
}
