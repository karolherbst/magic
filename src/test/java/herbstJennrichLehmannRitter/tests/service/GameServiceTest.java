package herbstJennrichLehmannRitter.tests.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.service.impl.GameServiceImpl;

import org.junit.Test;

public class GameServiceTest {

	private GameService gameService = new GameServiceImpl(new GameEngineControllerImpl());
	
	@Test
	public void testAllPossibleCards() {
		assertNotNull(this.gameService.getAllPossibleCards());
		assertTrue(this.gameService.getAllPossibleCards().size() > 0);
	}

}
