package herbstJennrichLehmannRitter.ui.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.ui.RMIUsertInterface;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.RemoteException;
import java.util.Collection;

/**	Description of RMIUserInterfaceWrapper Class
 * This class implements the UserInterface and wraps the RMIUserInterfaceImpl
 */

public class RMIUserInterfaceWrapper implements UserInterface {

	private static final long serialVersionUID = 9141975062331394016L;
	
	final RMIUsertInterface rmi;
	
	public RMIUserInterfaceWrapper(RMIUsertInterface rmi) {
		this.rmi = rmi;
	}
	
	@Override
	public void setData(Data data) {
		try {
			this.rmi.setData(data);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void twoPlayerFound() {
		try {
			this.rmi.twoPlayerFound();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void nextTurn() {
		try {
			this.rmi.nextTurn();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void playAnotherCard() {
		try {
			this.rmi.playAnotherCard();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void enemyPlayedCard(Card card) {
		try {
			this.rmi.enemyPlayedCard(card);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onPlayCard(Card card) {
		try {
			this.rmi.onPlayCard(card);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onDiscardCard(Card card) {
		try {
			this.rmi.onDiscardCard(card);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void youLost() {
		try {
			this.rmi.youLost();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void youWon() {
		try {
			this.rmi.youWon();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void abort(String reason) {
		try {
			this.rmi.abort(reason);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String getName() {
		try {
			return this.rmi.getName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public Collection<String> getCards() {
		try {
			return this.rmi.getCards();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
