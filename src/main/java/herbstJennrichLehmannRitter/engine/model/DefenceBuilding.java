package herbstJennrichLehmannRitter.engine.model;

/**	Description of DefenceBuilding Class
 * Interface for Tower and Wall
 */

public interface DefenceBuilding extends Building {

	public int getActualPoints();
	public void setActualPoints(int points);
	
	public void addPoints(int points);
	public int applyDamage(int damage);
}
