package herbstJennrichLehmannRitter.tests.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.server.GameServer;

import org.junit.Test;

public class GameServerTest {

	private GameServer localGameServer = Globals.getLocalGameServer();
	
	@Test
	public void testPossibleCards() {
		assertNotNull(this.localGameServer.getAllPossibleCards());
		assertTrue(this.localGameServer.getAllPossibleCards().size() > 0);
	}

}
