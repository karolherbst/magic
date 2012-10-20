package herbstJennrichLehmannRitter.server.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.impl.DataImpl;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

public class GameServerImpl implements GameServer {
	//TODO was bedeutet diese Warnung?
	private Data data = new DataImpl();
	private List<UserInterface> userInterfaces = new ArrayList<UserInterface>();

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void playCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void discardCard(Card card) {
		// TODO: HILFE - ich komme hier nicht weiter... (siehe mehrzeiliges Kommentar)
		/**
		 * Ich (Sebastian) möchte die Karte vom handDeck entfernen und auf das cemeteryDeck packen.
		 * Dazu habe ich in der PlayerImpl 2 Methode: removeCardFromHandDeck und addCardToCemeteryDeck geschrieben.
		 * 
		 * Da ich aber über this.data nur auf das Interface von Player zugreifen kann (in DataImpl steht
		 * private Player ownPlayer; und private Player enemyPlayer;), kann ich nicht auf die Methode zugreifen.
		 * Ich würde nun in der DataImpl die obigen Zeile auf private PlayerImpl ändern. 
		 * Kann ich das so einfach? Damit müsste ich im Interface Data das Package PlayerImpl importieren. Das 
		 * finde ich irgendwie nicht schön. Gibt es eine andere, bessere und schänere Alternative? 
	     */
//		this.data.getOwnPlayer().removeCardFromHandDeck(card);
//		this.data.getOwnPlayer().addCardToCemeteryDeck(card);
	}

	@Override
	public void getAllPossibleCards() {
		// TODO Auto-generated method stub

	}

	@Override
	public synchronized void register(UserInterface userInterface) throws RemoteException {
		// TODO Karol: Bitte hier mal drüberschauen - ist das so richtig?
		if( userInterface != null ) {
			this.userInterfaces.add(userInterface);
		}
	}

	@Override
	public void unregister(UserInterface userInterface) throws RemoteException {
		// TODO Karol: Bitte hier mal drüberschauen - ist das so richtig?
		if( userInterface != null) {
			this.userInterfaces.remove(userInterface);
		}
	}
	
}
