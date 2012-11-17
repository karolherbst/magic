package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.server.RemoteObject;
import java.util.Collection;

public class RMIUserInterface extends RemoteObject implements UserInterface {

	private static final long serialVersionUID = -3976482349872923026L;
	
	private final UserInterface userInterface;
	
	public RMIUserInterface(UserInterface userInterface) {
		this.userInterface = userInterface;
	}
	
	@Override
	public void setData(Data data) {
		this.userInterface.setData(data);
	}

	@Override
	public void twoPlayerFound() {
		this.userInterface.twoPlayerFound();
	}

	@Override
	public void nextTurn() {
		this.userInterface.twoPlayerFound();
	}

	@Override
	public void playAnotherCard() {
		this.userInterface.playAnotherCard();
	}

	@Override
	public void enemyPlayedCard(Card card) {
		this.userInterface.enemyPlayedCard(card);
	}

	@Override
	public void onPlayCard(Card card) {
		this.userInterface.onPlayCard(card);
	}

	@Override
	public void onDiscardCard(Card card) {
		this.userInterface.onDiscardCard(card);
	}

	@Override
	public void youLost() {
		this.userInterface.youLost();
	}

	@Override
	public void youWon() {
		this.userInterface.youWon();
	}

	@Override
	public void abort(String reason) {
		this.userInterface.abort(reason);
	}

	@Override
	public String getName() {
		return this.userInterface.getName();
	}

	@Override
	public Collection<String> getCards() {
		return this.userInterface.getCards();
	}

}
