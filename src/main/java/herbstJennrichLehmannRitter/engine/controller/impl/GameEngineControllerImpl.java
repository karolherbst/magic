package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.service.impl.GameServiceImpl;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.impl.GameServerImpl;

public class GameEngineControllerImpl implements GameEngineController {

	private final GameService gameService;
	private final GameServer gameServer;
	
	private static boolean once = false;
	
	public GameEngineControllerImpl() {
		if (once) {
			// TODO: exception here
		}
		this.gameService = new GameServiceImpl();
		this.gameServer = new GameServerImpl(this.gameService);
		once = true;
	}
	
	@Override
	public GameService getGameService() {
		return this.gameService;
	}

	@Override
	public GameServer getGameServer() {
		return this.gameServer;
	}

}
