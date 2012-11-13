package herbstJennrichLehmannRitter.engine;

import herbstJennrichLehmannRitter.engine.controller.impl.GameEngineControllerImpl;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.engine.service.impl.GameServiceImpl;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.server.impl.GameServerImpl;
import herbstJennrichLehmannRitter.server.impl.NetworkServerImpl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public final class Globals {
	
	private static GameService gameService;
	private static GameServer localGameServer;
	private static NetworkServerImpl remoteGameServer;
	private static GameCardFactory gameCardFactory;
	
	private static boolean started = false;
	
	public static final String GAME_SERVER_NAME = "MagicServer";
	
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
			LocateRegistry.createRegistry(51337);
			System.out.println("Registry wurde erzeugt!");
			
			remoteGameServer = new NetworkServerImpl(getLocalGameServer());
			
			Naming.rebind(GAME_SERVER_NAME, remoteGameServer);
			System.out.println(GAME_SERVER_NAME + ": remoteGameServer wurde registriert!");
//			Naming.rebind("//localhost/" + GAME_SERVER_NAME, remoteGameServer);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void stopRemoteServer() {
		if (remoteGameServer == null) {
			return;
		}
		
		try {
			Naming.unbind("//localhost/" + GAME_SERVER_NAME);
			UnicastRemoteObject.unexportObject(remoteGameServer, true);
			remoteGameServer = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static GameServer getRemoteServer(String ipAddress) {
		GameServer gameServer = null;
		try {
			Registry registry = LocateRegistry.getRegistry(ipAddress, 51337);
			System.out.println("Registry wurde located on IP:" + ipAddress);
			gameServer = (GameServer)registry.lookup(GAME_SERVER_NAME);
			System.out.println("Looking up to:" + GAME_SERVER_NAME);
//			gameServer = (GameServer)Naming.lookup("//" + ipAddress + "/" + GAME_SERVER_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(gameServer);
		return gameServer;
	}
	
}
