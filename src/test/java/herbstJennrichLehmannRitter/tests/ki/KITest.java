package herbstJennrichLehmannRitter.tests.ki;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;
import herbstJennrichLehmannRitter.ki.KI;
import herbstJennrichLehmannRitter.ki.KICardSelection;

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
		KI.startKIOnLocal("KI4000");
		KI.startKIOnLocal("KI5000");
		// wait for KI to register
		Thread.sleep(100);
		Globals.getLocalGameServer().start(GameType.TOWER_BUILDING);
		Thread.sleep(30000);
		Globals.getLocalGameServer().stop();
		Globals.getLocalGameServer().unregister(new KI("KI2000", Globals.getLocalGameServer()));
		Globals.getLocalGameServer().unregister(new KI("KI3000", Globals.getLocalGameServer()));
	}
	
	@Test
	public void testKiSelectorWithKolossAndCollectionRage() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card koloss = gameCardFactory.createCard("Koloss");
		Player player = new PlayerImpl();
		player.getTower().addPoints(20);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(koloss), 30);
	}
}
