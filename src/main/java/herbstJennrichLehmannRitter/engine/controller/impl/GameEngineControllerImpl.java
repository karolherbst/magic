package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;
	
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	
	public GameEngineControllerImpl() {
		if (once) {
			throw new EngineCouldNotStartException("It is only one GameEngineController allowed");
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
