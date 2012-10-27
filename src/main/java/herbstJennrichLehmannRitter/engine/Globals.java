package herbstJennrichLehmannRitter.engine;

import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.service.impl.GameServiceImpl;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.impl.GameServerImpl;

public final class Globals {
	
	private static GameService gameService;
	private static GameServer localGameServer;
	
	private static boolean started = false;
	
	private static void buildUpLocalEngine() {
		gameService = new GameServiceImpl(new GameEngineControllerImpl());
		localGameServer = new GameServerImpl(gameService);
		started = true;
	}
	
	public static GameServer getLocalGameServer() {
		if (!started) {
			buildUpLocalEngine();
		}
		return localGameServer;
	}
	
	private Globals() {}
}
