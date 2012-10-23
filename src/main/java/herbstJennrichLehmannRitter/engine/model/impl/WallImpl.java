/**
 * 
 */
package herbstJennrichLehmannRitter.engine.model.impl;


/**
 * In der Implementierung der Mauer werden die aktuellen Punkte der Mauer für das jeweilige 
 * Spielerobjekt gespeichert. 
 *
 */
public class WallImpl extends AbstractDefenceBuilding {

	public WallImpl() {
		super(10);
	}
	
	@Override
	public String getName() {
		return "Mauer";
	}

}
