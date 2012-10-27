package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;
	
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
}
