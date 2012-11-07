package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertEquals;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.impl.DataImpl;
import herbstJennrichLehmannRitter.engine.model.impl.PlayerImpl;

import org.junit.Test;

public class DataTests {
	
	private Player player = new PlayerImpl();
	private DataImpl data = new DataImpl(this.player, this.player);
	
	@Test
	public void testOwnPlayer() {
		this.data.setOwnPlayer(this.player);
		assertEquals(this.data.getOwnPlayer(), this.player);
	}
	
	@Test
	public void testEnemyPlayer() {
		this.data.setEnemyPlayer(this.player);
		assertEquals(this.data.getEnemyPlayer(), this.player);
	}

}
