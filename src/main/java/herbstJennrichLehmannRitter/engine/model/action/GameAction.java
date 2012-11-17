package herbstJennrichLehmannRitter.engine.model.action;


/**	Description of GameAction Class
 * Contains the booleans to check who has won or lost the game.
 */

public interface GameAction {

	public boolean checkIfIHaveWonTheGame();
	public boolean checkIfIHaveLooseTheGame();
	public boolean checkIfTheGameIsUndecided();
}
