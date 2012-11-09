package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.exception.GameEngineException;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.PlayerFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.factory.impl.PlayerFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;
import herbstJennrichLehmannRitter.engine.model.impl.DataImpl;
import herbstJennrichLehmannRitter.engine.utils.MagicUtils;

import java.util.Collection;

public class GameEngineControllerImpl implements GameEngineController {

	private static boolean once = false;
	private static final int DEFAULT_TOWER_POINTS = 25;
	private static final int DEFAULT_WALL_POINTS = 10;
	private static final int DEFAULT_RSC_BUILDING_LEVEL = 1;
	private static final int DEFAULT_RSC_BUILDING_STOCK = 15;

	private GameType gameType;
	
	private GameCardFactory gameCardFactory = new GameCardFactoryImpl();
	private PlayerFactory playerFactory = new PlayerFactoryImpl();
	
	public GameEngineControllerImpl(GameCardFactory gameCardFactory) {
		if (once) {
			System.out.println("WARNING: a second GameEngineController has started. In tests this is okay");
		}
		once = true;
		
		this.gameCardFactory = gameCardFactory;
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		once = false;
	}

	@Override
	public GameCardFactory getGameCardFactory() {
		return this.gameCardFactory;
	}
	
	@Override
	public Player createPlayer(String name, Collection<String> cardNames) {
		
		Collection<Card> cards = this.gameCardFactory.createCardsFromNames(cardNames);
		
		return this.playerFactory.createPlayer(name, cards, DEFAULT_TOWER_POINTS, DEFAULT_WALL_POINTS,
				DEFAULT_RSC_BUILDING_LEVEL, DEFAULT_RSC_BUILDING_STOCK);
	}

	@Override
	public void start(GameType gameType) {
		// TODO: add class for win and lose checks
		// FIXME: From where do I get the sourcePlayer and TargetPlayer? (Sebastian)
//		GameAction gameAction = new GameActionImpl(sourcePlayer, targetPlayer);
		this.gameType = gameType;
	}
	
	@Override
	public void stop() {
		this.gameType = null;
	}
	
	private boolean isRunning() {
		return this.gameType != null;
	}
	
	@Override
	public Data createDataForPlayer(Player player, Player enemy) {
		return new DataImpl(player, this.playerFactory.createCopyForEnemy(enemy));
	}
	
	private Player lastPlayerWhoGainedResources = null;
	@Override
	public void addResourcesToPlayer(Player player) {
		if (player == this.lastPlayerWhoGainedResources) {
			return;
		}
		
		addResourcesToResourceBuilding(player.getMine());
		addResourcesToResourceBuilding(player.getMagicLab());
		addResourcesToResourceBuilding(player.getDungeon());
		
		this.lastPlayerWhoGainedResources = player;
	}
	
	private void addResourcesToResourceBuilding(ResourceBuilding rb) {
		rb.addStock(rb.getLevel());
	}

	@Override
	public void playCard(Card card, Player player, Player enemyPlayer) {
		
		if (!MagicUtils.canPlayerEffortCard(player, card)) {
			throw new GameEngineException("player can't effort card");
		}
		
		applyCostFromCardOnPlayer(card, player);
		applyResourceAction(card.getOwnResourceAction(), player);
		applyResourceAction(card.getEnemyResourceAction(), enemyPlayer);
		applyComplexCardAction(card.getComplexCardAction(), player, enemyPlayer);
		
		// we can simply call this method here
		discardCard(card, player);
	}
	
	// playCard helper functions
	private void applyCostFromCardOnPlayer(Card card, Player player) {
		player.getDungeon().reduceStock(card.getCostMonsters());
		player.getMagicLab().reduceStock(card.getCostCrystal());
		player.getMine().reduceStock(card.getCostBrick());
	}
	
	private void applyResourceAction(ResourceAction ra, Player player) {

		player.getMine().addStock(ra.getBrickEffect());
		player.getMine().addLevel(ra.getMineLvlEffect());
		
		player.getDungeon().addStock(ra.getMonsterEffect());
		player.getDungeon().addLevel(ra.getDungeonLvlEffect());
		
		player.getMagicLab().addStock(ra.getCrystalEffect());
		player.getMagicLab().addLevel(ra.getMagicLabLvlEffect());
		
		player.getWall().addPoints(ra.getWallEffect());
		player.getTower().addPoints(ra.getTowerEffect());
		
		// apply damage on Player
		player.getTower().applyDamage(player.getWall().applyDamage(ra.getDamage()));
	}
	
	private void applyComplexCardAction(ComplexCardAction cca, Player player, Player enemy) {
		if (cca == null) {
			return;
		}
		
		cca.applyActionOnPlayer(player, enemy);
	}
	
	@Override
	public void discardCard(Card card, Player player) {
		player.getDeck().discardCard(card);
		// this will refill to an amount of max 6 cards
		player.getDeck().pickCards(6);
	}

}
