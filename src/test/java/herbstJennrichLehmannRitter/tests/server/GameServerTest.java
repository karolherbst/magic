package herbstJennrichLehmannRitter.tests.server;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.server.GameServer;

import java.rmi.RemoteException;

import org.junit.Test;

/** Description of GameServerTest Class
 *  This class tests the GameServer and one possible exception.
 */

public class GameServerTest {

	private GameServer localGameServer = Globals.getLocalGameServer();
	
	@Test
	public void testPossibleCards() throws RemoteException {
		assertNotNull(this.localGameServer.getAllPossibleCards());
		assertTrue(this.localGameServer.getAllPossibleCards().size() > 0);
	}

}
