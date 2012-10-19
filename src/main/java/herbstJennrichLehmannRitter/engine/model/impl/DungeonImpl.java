package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

/**
 *
 * Implementation des Ressourcengebäudes Verlies.<br />
 * Speichert das Level und den Ressourcenstand des Verlies.
 *
 */
public class DungeonImpl implements ResourceBuilding {

	private int level;
	private int stock;
	
	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int getStock() {
		return this.stock;
	}

	@Override
	public void setStock(int stock) {
		this.stock = stock;
	}

}
