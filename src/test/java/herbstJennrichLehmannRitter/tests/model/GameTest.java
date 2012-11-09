package herbstJennrichLehmannRitter.tests.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.GameAction;
import herbstJennrichLehmannRitter.engine.model.action.impl.GameActionImpl;

import org.junit.Test;

public class GameTest {

	@Test
	public void testCheckIfIHaveWonTheGame() {
		PlayerFactory playerFactory = new PlayerFactoryImpl();
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		
		Player ownPlayer = playerFactory.createPlayer("Own Player", gameCardFactory.createDefaultDeck(), 25, 15, 1, 15);
		Player enemyPlayer =  playerFactory.createPlayer("Enemy", gameCardFactory.createDefaultDeck(), 25, 15, 1, 15);
		GameAction gameAction = new GameActionImpl(ownPlayer, enemyPlayer);
		
		enemyPlayer.getTower().applyDamage(30);
		assertTrue(gameAction.checkIfIHaveWonTheGame());
		assertFalse(gameAction.checkIfIHaveLooseTheGame());
		assertFalse(gameAction.checkIfTheGameIsUndecided());
	}

	@Test
	public void testCheckIfIHaveLooseTheGame() {
		PlayerFactory playerFactory = new PlayerFactoryImpl();
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		
		Player ownPlayer = playerFactory.createPlayer("Own Player", gameCardFactory.createDefaultDeck(), 25, 15, 1, 15);
		Player enemyPlayer =  playerFactory.createPlayer("Enemy", gameCardFactory.createDefaultDeck(), 25, 15, 1, 15);
		GameAction gameAction = new GameActionImpl(ownPlayer, enemyPlayer);

		ownPlayer.getTower().applyDamage(30);
		
		assertFalse(gameAction.checkIfIHaveWonTheGame());
		assertTrue(gameAction.checkIfIHaveLooseTheGame());
		assertFalse(gameAction.checkIfTheGameIsUndecided());
	}

	@Test
	public void testCheckIfTheGameIsUndecided() {
		PlayerFactory playerFactory = new PlayerFactoryImpl();
		GameCardFactory gameCardFactory = new GameCardFactoryImpl();
		
		Player ownPlayer = playerFactory.createPlayer("Own Player", gameCardFactory.createDefaultDeck(), 25, 15, 1, 15);
		Player enemyPlayer =  playerFactory.createPlayer("Enemy", gameCardFactory.createDefaultDeck(), 25, 15, 1, 15);
		GameAction gameAction = new GameActionImpl(ownPlayer, enemyPlayer);

		ownPlayer.getTower().applyDamage(30);
		enemyPlayer.getTower().applyDamage(25);
		
		assertTrue(gameAction.checkIfTheGameIsUndecided());
	}

}
