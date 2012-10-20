package herbstJennrichLehmannRitter.server.impl;

import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.service.GameService;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class GameServerImpl implements GameServer {

	private List<UserInterface> userInterfaces = new ArrayList<UserInterface>();
	
	private final GameService gameService;
	
	public GameServerImpl(GameService gameService) {
		this.gameService = gameService;
	}

	@Override
	public void start() {
		this.gameService.start();
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
