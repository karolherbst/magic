package herbstJennrichLehmannRitter.engine;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.server.GameServer;

public final class Globals {
	
	private static GameEngineController gameEngineController;
	private static boolean started = false;
	
	private static void buildUpEngine() {
		gameEngineController = new GameEngineControllerImpl();
		started = true;
	}
	
	public static GameServer getGameServer() {
		if (!started) {
			buildUpEngine();
		}
		return gameEngineController.getGameServer();
	}
	
}
