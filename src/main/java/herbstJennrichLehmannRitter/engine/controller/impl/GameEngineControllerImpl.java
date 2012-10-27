package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
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
			throw new EngineCouldNotStartException("It is only one GameEngineController allowed");
		}
		this.gameService = new GameServiceImpl(this);
		this.gameServer = new GameServerImpl(this.gameService);
		once = true;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		once = false;
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
