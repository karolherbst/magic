package herbstJennrichLehmannRitter.engine.controller;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;


public interface GameEngineController {

	public GameCardFactory getGameCardFactory();
	public void start(GameType gameType);
	public void stop();
	
}
