package herbstJennrichLehmannRitter.tests.ki;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.ki.KI;

import java.rmi.RemoteException;

import org.junit.Test;

public class KITest {

	@Test
	public void testKiWithCollectionRage() throws InterruptedException, RemoteException {
		KI.startKIOnLocal("KI2000");
		KI.startKIOnLocal("KI3000");
		// wait for KI to register
		Thread.sleep(100);
		Globals.getLocalGameServer().start(GameType.COLLECTION_RAGE);
		Thread.sleep(30000);
		Globals.getLocalGameServer().stop();
		Globals.getLocalGameServer().unregister(new KI("KI2000", Globals.getLocalGameServer()));
		Globals.getLocalGameServer().unregister(new KI("KI3000", Globals.getLocalGameServer()));
	}
	
	@Test
	public void testKiWithTowerBuilding() throws InterruptedException, RemoteException {
		KI.startKIOnLocal("KI2000");
		KI.startKIOnLocal("KI3000");
		// wait for KI to register
		Thread.sleep(100);
		Globals.getLocalGameServer().start(GameType.TOWER_BUILDING);
		Thread.sleep(30000);
		Globals.getLocalGameServer().stop();
		Globals.getLocalGameServer().unregister(new KI("KI2000", Globals.getLocalGameServer()));
		Globals.getLocalGameServer().unregister(new KI("KI3000", Globals.getLocalGameServer()));
	}
}
