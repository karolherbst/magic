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

/** Description of KITest Class
 *  This class tests the KI in the modes ResourceRage and TowerBuilding.
 */

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
		
		Thread.sleep(1000);
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
	public void testKiSelectorWithRinderwahnsinnAndCollectionRage15TowerPoints() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card rinderwahnsinn = gameCardFactory.createCard("Rinderwahnsinn");
		
		Player player = new PlayerImpl();
		player.getDungeon().addStock(6);
		player.getTower().applyDamage(10);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(rinderwahnsinn), 6);
	}
	
	@Test
	public void testKiSelectorWithRinderwahnsinnAndCollectionRage() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card rinderwahnsinn = gameCardFactory.createCard("Rinderwahnsinn");
		
		Player player = new PlayerImpl();
		player.getDungeon().addStock(6);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(rinderwahnsinn), 12);
	}
	
	@Test
	public void testKiSelectorWithRinderwahnsinnAndTowerBuilding() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card rinderwahnsinn = gameCardFactory.createCard("Rinderwahnsinn");
		
		Player player = new PlayerImpl();
		player.getDungeon().addStock(6);
		player.getTower().addPoints(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(rinderwahnsinn), 12);
	}
	
	@Test
	public void testKiSelectorWithKolossAndCollectionRage15TowerPoints() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card koloss = gameCardFactory.createCard("Koloss");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(10);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(koloss), 15);
	}
	
	@Test
	public void testKiSelectorWithKolossAndCollectionRage() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card koloss = gameCardFactory.createCard("Koloss");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(koloss), 60);
	}
	
	@Test
	public void testKiSelectorWithKolossAndTowerBuilding() {
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card koloss = gameCardFactory.createCard("Koloss");
		Player player = new PlayerImpl();
		player.getTower().addPoints(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(koloss), 105);
	}
	
	@Test
	public void testKiSelectorWithVollmondAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card vollmond = gameCardFactory.createCard("Vollmond");
		Player playerOne = new PlayerImpl();
		playerOne.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(playerOne);
		assertEquals(kiCardSelection.generateCardSum(vollmond), 9);
	}
	
	@Test
	public void testKiSelectorWithVollmondAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card vollmond = gameCardFactory.createCard("Vollmond");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(vollmond), 13);
	}
	
	@Test
	public void testKiSelectorWithVollmondAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card vollmond = gameCardFactory.createCard("Vollmond");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(vollmond), 13);
	}
	
	@Test
	public void testKiSelectorWithOrkanAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card orkan = gameCardFactory.createCard("Orkan");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(orkan), 30);
	}
	
	
	@Test
	public void testKiSelectorWithOrkanAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card orkan = gameCardFactory.createCard("Orkan");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(orkan), 30);
	}
	
	
	@Test
	public void testKiSelectorWithOrkanAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card orkan = gameCardFactory.createCard("Orkan");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(orkan), 50);
	}
	
	@Test
	public void testKiSelectorWithParadoxonAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card paradoxon = gameCardFactory.createCard("Paradoxon");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(paradoxon), 28);
	}
	
	@Test
	public void testKiSelectorWithErzharmonieAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card erzharmonie = gameCardFactory.createCard("Erzharmonie");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(erzharmonie), 22);
	}
	
	@Test
	public void testKiSelectorWithErzharmonieAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card erzharmonie = gameCardFactory.createCard("Erzharmonie");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(erzharmonie), 10);
	}
	
	@Test
	public void testKiSelectorWithErzharmonieAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card erzharmonie = gameCardFactory.createCard("Erzharmonie");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(erzharmonie), 22);
	}
	
	@Test
	public void testKiSelectorWithKristallmatrixAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card kristallmatrix = gameCardFactory.createCard("Kristallmatrix");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(kristallmatrix), 9);
	}
	
	@Test
	public void testKiSelectorWithKristallmatrixAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card kristallmatrix = gameCardFactory.createCard("Kristallmatrix");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(kristallmatrix), 4);
	}
	
	@Test
	public void testKiSelectorWithKristallmatrixAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card kristallmatrix = gameCardFactory.createCard("Kristallmatrix");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(kristallmatrix), 9);
	}
	
	@Test
	public void testKiSelectorWithInnovationAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card innovation = gameCardFactory.createCard("Innovation");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(innovation), 10);
	}
	
	@Test
	public void testKiSelectorWithInnovationAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card innovation = gameCardFactory.createCard("Innovation");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(innovation), 15);
	}
	
	@Test
	public void testKiSelectorWithInnovationAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card innovation = gameCardFactory.createCard("Innovation");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(innovation), 10);
	}
	
	@Test
	public void testKiSelectorWithBruechigerSteinAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Brüchiger Stein");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(card), 24);
	}
	
	@Test
	public void testKiSelectorWithBruechigerSteinAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Brüchiger Stein");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(card), 20);
	}
	
	@Test
	public void testKiSelectorWithBruechigerSteinAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Brüchiger Stein");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(card), 24);
	}
	
	@Test
	public void testKiSelectorWithPhasenjuwelAndCollectionRage15TowerPoints(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Phasenjuwel");
		Player player = new PlayerImpl();
		player.getTower().applyDamage(15);
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(card), 54);
	}
	
	@Test
	public void testKiSelectorWithPhasenjuwelAndCollectionRage(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Phasenjuwel");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.COLLECTION_RAGE);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(card), 40);
	}
	
	@Test
	public void testKiSelectorWithPhasenjuwelAndTowerBuilding(){
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		Card card = gameCardFactory.createCard("Phasenjuwel");
		Player player = new PlayerImpl();
		
		KICardSelection kiCardSelection = new KICardSelection();
		kiCardSelection.setGameType(GameType.TOWER_BUILDING);
		kiCardSelection.setPlayer(player);
		assertEquals(kiCardSelection.generateCardSum(card), 60);
	}


}
