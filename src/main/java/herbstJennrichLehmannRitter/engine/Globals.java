package herbstJennrichLehmannRitter.engine;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;

public final class Globals {
	
	private static GameEngineController gameEngineController;
	private static GameService gameService;
	private static Thread gameEngineThread;
	
	static public void buildUpEngine() {
		new GameEngineControllerImpl();
	}
	
}
