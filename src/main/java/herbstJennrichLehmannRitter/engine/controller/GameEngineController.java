package herbstJennrichLehmannRitter.engine.controller;

import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;

public interface GameEngineController {

	public GameService getGameService();
	public GameServer getGameServer();
	
}
