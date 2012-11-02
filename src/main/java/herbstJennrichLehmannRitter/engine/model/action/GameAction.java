package herbstJennrichLehmannRitter.engine.model.action;


public interface GameAction {

	public boolean checkIfIHaveWonTheGame();
	public boolean checkIfIHaveLooseTheGame();
	public boolean checkIfTheGameIsUndecided();
}
