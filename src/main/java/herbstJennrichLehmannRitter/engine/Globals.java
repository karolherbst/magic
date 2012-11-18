package herbstJennrichLehmannRitter.engine;

import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.service.impl.GameServiceImpl;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.NetworkServer;
import herbstJennrichLehmannRitter.server.impl.GameServerImpl;
import herbstJennrichLehmannRitter.server.impl.NetworkServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/** Description of Globals Class
 *  This Class implements the Game Service, the Game Server and the GameCard Factory.
 */

public final class Globals {
	
	private static GameService gameService;
	private static GameServer localGameServer;
	private static NetworkServerImpl remoteGameServer;
	private static GameCardFactory gameCardFactory;
	
	private static boolean started = false;
	
	public static final String GAME_SERVER_NAME = "MagicServer";
	private static final int GAME_SERVER_PORT = 40000;
	
	/**
	 * The Class Globals should never be instantiated
	 */
	private Globals() {}
	
	private static void buildUpLocalEngine() {
		gameService = new GameServiceImpl(new GameEngineControllerImpl(getGameCardFactory()));
		localGameServer = new GameServerImpl(gameService);
		started = true;
	}
	
	public synchronized static GameServer getLocalGameServer() {
		if (!started) {
			buildUpLocalEngine();
		}
		return localGameServer;
	}
	
	public static GameCardFactory getGameCardFactory() {
		if (gameCardFactory == null) {
			gameCardFactory = new GameCardFactoryImpl();
		}
		return gameCardFactory;
	}
	
	public static void startRemoteServer() throws RemoteException {
		if (remoteGameServer != null) {
			return;
		}
		
		try {
			Registry registry = LocateRegistry.createRegistry(GAME_SERVER_PORT);
			System.out.println("Registry wurde erzeugt!");
			
			registry.bind(GAME_SERVER_NAME, new NetworkServerImpl(getLocalGameServer()));
			System.out.println(GAME_SERVER_NAME + ": remoteGameServer wurde registriert!");
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopRemoteServer() {
		if (remoteGameServer == null) {
			return;
		}
		
		try {
			Naming.unbind(GAME_SERVER_NAME);
			UnicastRemoteObject.unexportObject(remoteGameServer, true);
			remoteGameServer = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static NetworkServer getRemoteServer(String ipAddress) {
		NetworkServer gameServer = null;
		try {
			Registry registry = LocateRegistry.getRegistry(ipAddress, GAME_SERVER_PORT);
			System.out.println("Registry wurde located on IP:" + ipAddress);
			gameServer = (NetworkServer)registry.lookup(GAME_SERVER_NAME);
			System.out.println("Looking up to:" + GAME_SERVER_NAME);
		} catch (Exception e) {
			System.out.println("Exception Client");
			e.printStackTrace();
		}
		System.out.println(gameServer);
		return gameServer;
	}
	
}
