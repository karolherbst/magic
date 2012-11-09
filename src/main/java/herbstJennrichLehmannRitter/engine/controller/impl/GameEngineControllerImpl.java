package herbstJennrichLehmannRitter.engine.controller.impl;

import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.controller.WinAndLoseChecker;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.exception.EngineCouldNotStartException;
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

	private WinAndLoseChecker winAndLoseChecker;
	
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
		
		switch (gameType) {
		case TOWER_BUILDING:
			this.winAndLoseChecker = new WinAndLoseTowerBuildingChecker();
			break;

		case COLLECTION_RAGE:
			this.winAndLoseChecker = new WinAndLoseResourceRageChecker();
			break;
			
		default:
			throw new EngineCouldNotStartException("unknown game mode:" + gameType);
		}
	}
	
	@Override
	public void stop() {
		this.winAndLoseChecker = null;
	}
	
	private boolean isRunning() {
		return this.winAndLoseChecker != null;
	}
	
	@Override
	public Data createDataForPlayer(Player player, Player enemy) {
		return new DataImpl(player, this.playerFactory.createCopyForEnemy(enemy));
	}
	
	private Player lastPlayerWhoGainedResources = null;
	private void addResourcesToPlayer(Player player) {
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
		if (!isRunning()) {
			throw new GameEngineException("GameEngine is not Running");
		}
		
		if (!MagicUtils.canPlayerEffortCard(player, card)) {
			throw new GameEngineException("player can't effort card");
		}
		
		addResourcesToPlayer(player);
		
		applyCostFromCardOnPlayer(card, player);
		applyResourceAction(card.getOwnResourceAction(), player);
		applyResourceAction(card.getEnemyResourceAction(), enemyPlayer);
		applyComplexCardAction(card.getComplexCardAction(), player, enemyPlayer);
		
		throwAwayCardAndRefillHandDeckIfNeeded(card, player);
	}
	
	@Override
	public void discardCard(Card card, Player player) {
		if (!isRunning()) {
			throw new GameEngineException("GameEngine is not Running");
		}
		
		addResourcesToPlayer(player);
		throwAwayCardAndRefillHandDeckIfNeeded(card, player);
	}
	
	public void throwAwayCardAndRefillHandDeckIfNeeded(Card card, Player player) {
		player.getDeck().discardCard(card);
		
		if (!card.getCardAction().getPlayCards()) {
			player.getDeck().pickCards(6);
		}
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
	public boolean canPlayerPlayAnotherRound(Card card, Player player) {
		// TODO: add check against hand deck
		return card.getCardAction().getPlayCards();
	}

}
