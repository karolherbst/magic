package herbstJennrichLehmannRitter.engine.model.impl;

import herbstJennrichLehmannRitter.engine.model.ResourceBuilding;

public abstract class AbstractResourceBuilding implements ResourceBuilding {

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
	public void addLevel(int levels) {
		if (levels < 0) {
			reduceLevel(-levels);
		} else {
			this.level += levels;
		}
	}
	
	@Override
	public void reduceLevel(int levels){
		if (levels > 0) {
			addLevel(-levels);
		} else {
			this.level -= levels;
			if (this.level < 0) {
				this.level = 0;
			}
		}
	}

	@Override
	public int getStock() {
		return this.stock;
	}

	@Override
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public void addStock(int stocks){
		if (stocks < 0) {
			reduceStock(-stocks);
		} else {
			this.stock += stocks;
		}
	}
	
	@Override
	public void reduceStock(int stocks){
		if (stocks > 0) {
			reduceStock(-stocks);
		} else {
			this.stock -= stocks;
			if (this.stock < 0) {
				this.stock = 0;
			}
		}
	}
}
