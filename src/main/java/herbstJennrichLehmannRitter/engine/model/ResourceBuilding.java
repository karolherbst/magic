package herbstJennrichLehmannRitter.engine.model;


/**
 * 
 * Interface für die Ressourcenbebäude.
 *
 */
public interface ResourceBuilding extends Building {
	
	public int getLevel();
	public void setLevel(int level);
	public void addLevel(int level);
	public void reduceLevel(int level);
	
	
	public int getStock();
	public void setStock(int stock);
	public void addStock(int stock);
	public void reduceStock(int stock);
}
