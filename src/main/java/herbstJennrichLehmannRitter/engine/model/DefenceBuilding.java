package herbstJennrichLehmannRitter.engine.model;

/**
 * 
 * Interface für den Turm und die Mauer
 *
 */
public interface DefenceBuilding extends Building {

	public int getActualPoints();
	public void setActualPoints(int points);
	
	public void addPoints(int points);
	public int applyDamage(int damage);
}
