package herbstJennrichLehmannRitter.tests.ki;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.ki.KI;

import java.rmi.RemoteException;

import org.junit.Test;

public class KITest {

	@Test
	//@Ignore
	public void testKi() throws InterruptedException, RemoteException {
		KI.startKIOnLocal("KI2000");
		KI.startKIOnLocal("KI3000");
		// wait for KI to register
		Thread.sleep(100);
		Globals.getLocalGameServer().start(GameType.COLLECTION_RAGE);
		Thread.sleep(6000);
	}
	
}
