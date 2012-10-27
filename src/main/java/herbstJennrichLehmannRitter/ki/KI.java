package herbstJennrichLehmannRitter.ki;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.UserInterface;

public class KI implements UserInterface {

	@Override
	public void setData(Data data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playAnotherCard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enemeyPlayedCard(Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void youLost() {
		System.out.println("KI: you a sooo gay you motherfucker, you cheated you sucker!");
	}

	@Override
	public void youWon() {
		System.out.println("KI: HAHA! you are so weak you looser!");
	}

	@Override
	public void abort() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "super KI3000";
	}

}
