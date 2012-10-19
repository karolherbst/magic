package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

/**
*
* Implementation des Ressourcengebäudes Zauberlabors.<br />
* Speichert das Level und den Ressourcenstand des Zauberlabors.
*
*/
public class MagicLabImpl implements ResourceBuilding {
	
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
