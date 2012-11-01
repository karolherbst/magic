package herbstJennrichLehmannRitter.engine;

import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.service.impl.GameServiceImpl;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.impl.GameServerImpl;

public final class Globals {
	
	private static GameService gameService;
	private static GameServer localGameServer;
	private static GameCardFactory gameCardFactory;
	
	private static boolean started = false;
	
	private static void buildUpLocalEngine() {
		gameService = new GameServiceImpl(new GameEngineControllerImpl(getGameCardFactory()));
		localGameServer = new GameServerImpl(gameService);
		started = true;
	}
	
	public static GameServer getLocalGameServer() {
		if (!started) {
			buildUpLocalEngine();
		}
		return localGameServer;
	}
	
	public static GameCardFactory getGameCardFactory() {
		if (gameCardFactory == null) {
			gameCardFactory = new GameCardFactoryImpl();
		}
		return gameCardFactory;
	}
	
	private Globals() {}
}
