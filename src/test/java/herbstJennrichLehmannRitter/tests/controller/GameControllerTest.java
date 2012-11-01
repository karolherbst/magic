package herbstJennrichLehmannRitter.tests.controller;

import static org.junit.Assert.assertNotNull;
import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;

import org.junit.Test;

public class GameControllerTest {

	private GameEngineController gameEngineController = new GameEngineControllerImpl(Globals.getGameCardFactory());
	
	@Test
	public void testGameCardFactory() {
		assertNotNull(this.gameEngineController.getGameCardFactory());
	}

}
