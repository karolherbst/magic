package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.*;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.DataImpl;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;

import org.junit.Test;

public class DataTests {

	@Test
	public void testOwnPlayer() {
		Player player = new PlayerImpl();
		DataImpl data = new DataImpl();
		
		data.setOwnPlayer(player);
		assertEquals(data.getOwnPlayer(), player);
	}
	
	@Test
	public void testEnemyPlayer() {
		Player player = new PlayerImpl();
		DataImpl data = new DataImpl();
		
		data.setEnemyPlayer(player);
		assertEquals(data.getEnemyPlayer(), player);
	}

}
