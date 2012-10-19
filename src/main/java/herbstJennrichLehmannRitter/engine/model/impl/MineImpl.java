package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

/**
*
* Implementation des Ressourcengebäudes Mine.<br />
* Speichert das Level und den Ressourcenstand der Mine.
*
*/
public class MineImpl implements ResourceBuilding {
	
	private int level;
	private int stock;

	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getStock() {
		return this.stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

}
