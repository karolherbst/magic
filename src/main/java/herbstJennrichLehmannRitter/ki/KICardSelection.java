package herbstJennrichLehmannRitter.ki;

import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Player;
import herbstJennrichLehmannRitter.engine.model.action.ResourceAction;

/**
 * Implementierung der Wertigkeit einer einzelnen Karte für die KI Logik
 */
public class KICardSelection {
	private enum QUANTIFIER {
		NULL(0),
		LOW(1),
		MEDIUM(2),
		HIGH(3);
		
		private int quantifier;
		
		private QUANTIFIER(int quantifier) {
			this.quantifier = quantifier;
		}
		
		public int value() {
			return this.quantifier;
		}
	}
	
	private GameType gameType;
	private Card card;
	private int cardSum = 0;
	private Player player;
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}
	
	public int generateCardSum(Card card) {
		this.card = card;
		this.chooseSumMethod();
		
		return this.cardSum;
	}
	
	private void chooseSumMethod() {
		if (this.gameType == GameType.COLLECTION_RAGE) {
			if (this.player.getTower().getActualPoints() <= 15) {
				this.collectionRageTowerDefence();
			} else {
				this.collectionRage();
			}
		} else  {
			this.towerBuilding();
		}
	}
	
	private void collectionRageTowerDefence() {
		this.cardSum = 0;
		
		ResourceAction ownResourceAction = this.card.getOwnResourceAction();
		ResourceAction enemyResourceAction = this.card.getEnemyResourceAction();
		
		int ownTower = ownResourceAction.getTowerEffect();
		if (ownTower > 0) {
			this.cardSum += ownTower * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownTower * QUANTIFIER.MEDIUM.value();
		}
		
		int enemyTower = enemyResourceAction.getTowerEffect();
		if (enemyTower > 0) {
			this.cardSum += enemyTower * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyTower * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownWall = ownResourceAction.getWallEffect();
		if (ownWall > 0) {
			this.cardSum += ownWall * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownWall * QUANTIFIER.MEDIUM.value();
		}
		
		int enemyWall = enemyResourceAction.getWallEffect();
		if (enemyWall > 0) {
			this.cardSum += enemyWall * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyWall * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownDungeon = ownResourceAction.getDungeonLvlEffect();
		if (ownDungeon > 0) {
			this.cardSum += ownDungeon * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownDungeon * QUANTIFIER.LOW.value();
		}
		
		int enemyDungeon = enemyResourceAction.getDungeonLvlEffect();
		if (enemyDungeon > 0) {
			this.cardSum += enemyDungeon * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyDungeon * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMagicLab = ownResourceAction.getMagicLabLvlEffect();
		if (ownMagicLab > 0) {
			this.cardSum += ownMagicLab * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownMagicLab * QUANTIFIER.LOW.value();
		}
		
		int enemyMagicLab = enemyResourceAction.getMagicLabLvlEffect();
		if (enemyMagicLab > 0) {
			this.cardSum += enemyMagicLab * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyMagicLab * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMine = ownResourceAction.getMineLvlEffect();
		if (ownMine > 0) {
			this.cardSum += ownMine * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownMine * QUANTIFIER.LOW.value();
		}
		
		int enemyMine = enemyResourceAction.getMineLvlEffect();
		if (enemyMine > 0) {
			this.cardSum += enemyMine * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyMine * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownBrick = ownResourceAction.getBrickEffect();
		if (ownBrick > 0) {
			this.cardSum += ownBrick * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownBrick * QUANTIFIER.LOW.value();
		}
		
		int enemyBrick = enemyResourceAction.getBrickEffect();
		if (enemyBrick > 0) {
			this.cardSum += enemyBrick * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyBrick * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownCrystal = ownResourceAction.getCrystalEffect();
		if (ownCrystal > 0) {
			this.cardSum += ownCrystal * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownCrystal * QUANTIFIER.LOW.value();
		}
		
		int enemyCrystal = enemyResourceAction.getCrystalEffect();
		if (enemyCrystal > 0) {
			this.cardSum += enemyCrystal * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyCrystal * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMonster = ownResourceAction.getMonsterEffect();
		if (ownMonster > 0) {
			this.cardSum += ownMonster * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownMonster * QUANTIFIER.LOW.value();
		}
		
		int enemyMonster = enemyResourceAction.getMonsterEffect();
		if (enemyMonster > 0) {
			this.cardSum += enemyMonster * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyMonster * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		this.cardSum += ownResourceAction.getDamage() * QUANTIFIER.NULL.value();
		this.cardSum += enemyResourceAction.getDamage() * QUANTIFIER.LOW.value();
		
		this.addComplexCards();
		this.subtractCosts();
	}
	
	private void collectionRage() {
		this.cardSum = 0;
		
		ResourceAction ownResourceAction = this.card.getOwnResourceAction();
		ResourceAction enemyResourceAction = this.card.getEnemyResourceAction();
		
		int ownTower = ownResourceAction.getTowerEffect();
		if (ownTower > 0) {
			this.cardSum += ownTower * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += ownTower * QUANTIFIER.LOW.value();
		}
		
		int enemyTower = enemyResourceAction.getTowerEffect();
		if (enemyTower > 0) {
			this.cardSum += enemyTower * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyTower * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownWall = ownResourceAction.getWallEffect();
		if (ownWall > 0) {
			this.cardSum += ownWall * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownWall * QUANTIFIER.LOW.value();
		}
		
		int enemyWall = enemyResourceAction.getWallEffect();
		if (enemyWall > 0) {
			this.cardSum += enemyWall * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyWall * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownDungeon = ownResourceAction.getDungeonLvlEffect();
		if (ownDungeon > 0) {
			this.cardSum += ownDungeon * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownDungeon * QUANTIFIER.LOW.value();
		}
		
		int enemyDungeon = enemyResourceAction.getDungeonLvlEffect();
		if (enemyDungeon > 0) {
			this.cardSum += enemyDungeon * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyDungeon * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMagicLab = ownResourceAction.getMagicLabLvlEffect();
		if (ownMagicLab > 0) {
			this.cardSum += ownMagicLab * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownMagicLab * QUANTIFIER.LOW.value();
		}
		
		int enemyMagicLab = enemyResourceAction.getMagicLabLvlEffect();
		if (enemyMagicLab > 0) {
			this.cardSum += enemyMagicLab * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyMagicLab * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMine = ownResourceAction.getMineLvlEffect();
		if (ownMine > 0) {
			this.cardSum += ownMine * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownMine * QUANTIFIER.LOW.value();
		}
		
		int enemyMine = enemyResourceAction.getMineLvlEffect();
		if (enemyMine > 0) {
			this.cardSum += enemyMine * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyMine * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownBrick = ownResourceAction.getBrickEffect();
		if (ownBrick > 0) {
			this.cardSum += ownBrick * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownBrick * QUANTIFIER.LOW.value();
		}
		
		int enemyBrick = enemyResourceAction.getBrickEffect();
		if (enemyBrick > 0) {
			this.cardSum += enemyBrick * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyBrick * QUANTIFIER.HIGH.value() * -1;
		}
		
		int ownCrystal = ownResourceAction.getCrystalEffect();
		if (ownCrystal > 0) {
			this.cardSum += ownCrystal * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownCrystal * QUANTIFIER.LOW.value();
		}
		
		int enemyCrystal = enemyResourceAction.getCrystalEffect();
		if (enemyCrystal > 0) {
			this.cardSum += enemyCrystal * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyCrystal * QUANTIFIER.HIGH.value() * -1;
		}
		
		int ownMonster = ownResourceAction.getMonsterEffect();
		if (ownMonster > 0) {
			this.cardSum += ownMonster * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownMonster * QUANTIFIER.LOW.value();
		}
		
		int enemyMonster = enemyResourceAction.getMonsterEffect();
		if (enemyMonster > 0) {
			this.cardSum += enemyMonster * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyMonster * QUANTIFIER.HIGH.value() * -1;
		}
		
		this.cardSum += ownResourceAction.getDamage() * QUANTIFIER.NULL.value();
		this.cardSum += enemyResourceAction.getDamage() * QUANTIFIER.MEDIUM.value();
		
		this.addComplexCards();
		this.subtractCosts();
	}
	
	private void towerBuilding() {
		this.cardSum = 0;
		
		ResourceAction ownResourceAction = this.card.getOwnResourceAction();
		ResourceAction enemyResourceAction = this.card.getEnemyResourceAction();
		
		int ownTower = ownResourceAction.getTowerEffect();
		if (ownTower > 0) {
			this.cardSum += ownTower * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownTower * QUANTIFIER.HIGH.value();
		}
		
		int enemyTower = enemyResourceAction.getTowerEffect();
		if (enemyTower > 0) {
			this.cardSum += enemyTower * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyTower * QUANTIFIER.HIGH.value() * -1;
		}
		
		int ownWall = ownResourceAction.getWallEffect();
		if (ownWall > 0) {
			this.cardSum += ownWall * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownWall * QUANTIFIER.MEDIUM.value();
		}
		
		int enemyWall = enemyResourceAction.getWallEffect();
		if (enemyWall > 0) {
			this.cardSum += enemyWall * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyWall * QUANTIFIER.HIGH.value() * -1;
		}
		
		int ownDungeon = ownResourceAction.getDungeonLvlEffect();
		if (ownDungeon > 0) {
			this.cardSum += ownDungeon * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownDungeon * QUANTIFIER.LOW.value();
		}
		
		int enemyDungeon = enemyResourceAction.getDungeonLvlEffect();
		if (enemyDungeon > 0) {
			this.cardSum += enemyDungeon * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyDungeon * QUANTIFIER.HIGH.value() * -1;
		}
		
		int ownMagicLab = ownResourceAction.getMagicLabLvlEffect();
		if (ownMagicLab > 0) {
			this.cardSum += ownMagicLab * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownMagicLab * QUANTIFIER.LOW.value();
		}
		
		int enemyMagicLab = enemyResourceAction.getMagicLabLvlEffect();
		if (enemyMagicLab > 0) {
			this.cardSum += enemyMagicLab * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyMagicLab * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMine = ownResourceAction.getMineLvlEffect();
		if (ownMine > 0) {
			this.cardSum += ownMine * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownMine * QUANTIFIER.LOW.value();
		}
		
		int enemyMine = enemyResourceAction.getMineLvlEffect();
		if (enemyMine > 0) {
			this.cardSum += enemyMine * QUANTIFIER.LOW.value();
		} else {
			this.cardSum += enemyMine * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownBrick = ownResourceAction.getBrickEffect();
		if (ownBrick > 0) {
			this.cardSum += ownBrick * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownBrick * QUANTIFIER.LOW.value();
		}
		
		int enemyBrick = enemyResourceAction.getBrickEffect();
		if (enemyBrick > 0) {
			this.cardSum += enemyBrick * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyBrick * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownCrystal = ownResourceAction.getCrystalEffect();
		if (ownCrystal > 0) {
			this.cardSum += ownCrystal * QUANTIFIER.MEDIUM.value();
		} else {
			this.cardSum += ownCrystal * QUANTIFIER.LOW.value();
		}
		
		int enemyCrystal = enemyResourceAction.getCrystalEffect();
		if (enemyCrystal > 0) {
			this.cardSum += enemyCrystal * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyCrystal * QUANTIFIER.MEDIUM.value() * -1;
		}
		
		int ownMonster = ownResourceAction.getMonsterEffect();
		if (ownMonster > 0) {
			this.cardSum += ownMonster * QUANTIFIER.HIGH.value();
		} else {
			this.cardSum += ownMonster * QUANTIFIER.LOW.value();
		}
		
		int enemyMonster = enemyResourceAction.getMonsterEffect();
		if (enemyMonster > 0) {
			this.cardSum += enemyMonster * QUANTIFIER.NULL.value();
		} else {
			this.cardSum += enemyMonster * QUANTIFIER.HIGH.value() * -1;
		}
		
		this.cardSum += ownResourceAction.getDamage() * QUANTIFIER.LOW.value();
		this.cardSum += enemyResourceAction.getDamage() * QUANTIFIER.HIGH.value();
		
		this.addComplexCards();
		this.subtractCosts();
	}
	
	private void addComplexCards() {
		this.cardSum += (int)(this.card.getCostBrick() * Math.PI);
		this.cardSum += (int)(this.card.getCostCrystal() * Math.E);
		this.cardSum += (int)(this.card.getCostMonsters() * 1.337);
	}
	
	private void subtractCosts() {
		this.cardSum -= (int)(this.card.getCostBrick() * 0.5);
		this.cardSum -= (int)(this.card.getCostCrystal() * 0.5);
		this.cardSum -= (int)(this.card.getCostMonsters() * 0.5);
	}
}
