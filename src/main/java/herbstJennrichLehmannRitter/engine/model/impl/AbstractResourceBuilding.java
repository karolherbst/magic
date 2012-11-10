package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

public abstract class AbstractResourceBuilding implements ResourceBuilding {

	private int level = 1;
	private int stock = 15;
	
	@Override
	public int getLevel() {
		return this.level;
	}

	@Override
	public void setLevel(int level) {
		if (level < 1) {
			this.level = 1;
		} else {
			this.level = level;
		}
	}
	
	@Override
	public void addLevel(int levels) {
		setLevel(this.level + levels);
	}
	
	@Override
	public void reduceLevel(int levels){
		setLevel(this.level - levels);
	}

	@Override
	public int getStock() {
		return this.stock;
	}

	@Override
	public void setStock(int stock) {
		if (stock < 0) {
			this.stock = 0;
		} else {
			this.stock = stock;
		}
	}
	
	@Override
	public void addStock(int stocks){
		setStock(this.stock + stocks);
	}
	
	@Override
	public void reduceStock(int stocks){
		setStock(this.stock - stocks);
	}
}
