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
	public void addLevel(int level) {
		
	}
	
	@Override
	public void reduceLevel(int level){
		
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
	public void addStock(int stock){
		
	}
	
	@Override
	public void reduceStock(int stock){
		
	}
}
