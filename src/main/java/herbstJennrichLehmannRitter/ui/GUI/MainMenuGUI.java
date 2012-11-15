package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.enums.GameType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.ki.KI;
import herbstJennrichLehmannRitter.server.GameServer;
import herbstJennrichLehmannRitter.ui.UserInterface;
import herbstJennrichLehmannRitter.ui.impl.ClientUserInterface;
import herbstJennrichLehmannRitter.ui.impl.DemoUserInterface;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
public class MainMenuGUI {

	private int shells = 0;
	private Shell shell;
	private Display display;
	private Button startGameButton;
	private Button startDemoButton;
	private Button chooseDeckButton;
	private Button exitButton;
	private Combo gameTypeBox;
	
	private String playerName = "Spieler";
	private String enemyName = "Computer";
	private GameType gameType = GameType.TOWER_BUILDING;
	private Collection<String> playerCards = new ArrayList<String>();
	private Collection<String> enemyCards = new ArrayList<String>();
	private UserInterface clientUserInterface = new ClientUserInterface();
	private GameServer gameServer;
	
	public MainMenuGUI() {
		MainMenuGUI.this.display = new Display();
		initShell();
		initStartGameButton();
		initStartDemoButton();
		initChooseDeckButton();
		initGameTypeBox();
		initExitButton();
		MainMenuGUI.this.shell.pack();
		setShellLocationCenteredToScreen(MainMenuGUI.this.display, MainMenuGUI.this.shell);
		MainMenuGUI.this.shell.open();
		getClientUserInterface().setMainMenuGUI(MainMenuGUI.this);
		
		Collection<Card> cards = Globals.getGameCardFactory().createDefaultDeck();
		for (Card card:cards) {
			MainMenuGUI.this.playerCards.add(card.getName());
			MainMenuGUI.this.enemyCards.add(card.getName());
		}
	}
	
	public static void main(String[] args) {
		MainMenuGUI mainMenuGUI = new MainMenuGUI();
		mainMenuGUI.keepOpen();
		
		Globals.stopRemoteServer();
	}
	
	public ClientUserInterface getClientUserInterface() {
		return (ClientUserInterface)MainMenuGUI.this.clientUserInterface;
	}
	
	public String getPlayerName() {
		return MainMenuGUI.this.playerName;
	}
	public void setPlayerName(String name) {
		MainMenuGUI.this.playerName = name;
	}
	
	public String getEnemyName() {
		return MainMenuGUI.this.enemyName;
	}
	public void setEnemyName(String name) {
		MainMenuGUI.this.enemyName = name;
	}
	
	public Collection<String> getPlayerCards() {
		return this.playerCards;
	}
	public void setPlayerCards(Collection<String> cards) {
		this.playerCards = cards;
	}
	
	public Collection<String> getEnemyCards() {
		return this.enemyCards;
	}
	public void setEnemyCards(Collection<String> cards) {
		this.enemyCards = cards;
	}
	
	public GameType getGameType() {
		return this.gameType;
	}
	public void setGameServer(GameServer gameServer) {
		this.gameServer = gameServer;
	}
	public GameServer getGameServer() {
		return this.gameServer;
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shells++;
		this.shell.setText("Hauptmenü");
		this.shell.setLayout(new GridLayout(1, false));
		
		this.shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent d) {
				MainMenuGUI.this.shells--;
			}
		});
	}

	private void initChooseDeckButton() {
		MainMenuGUI.this.chooseDeckButton = new Button(MainMenuGUI.this.shell, SWT.NONE);
		MainMenuGUI.this.chooseDeckButton.setText("Deck erstellen");
		MainMenuGUI.this.chooseDeckButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		MainMenuGUI.this.chooseDeckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChooseDeckGUI chooseDeckGUI = new ChooseDeckGUI(MainMenuGUI.this.display, MainMenuGUI.this);
				chooseDeckGUI.open();
			}
		});
		
	}

	private void initExitButton() {
		MainMenuGUI.this.exitButton = new Button(MainMenuGUI.this.shell, SWT.NONE);
		MainMenuGUI.this.exitButton.setText("Beenden");
		MainMenuGUI.this.exitButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		MainMenuGUI.this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.shell.dispose();
			}
		});
	}
	
	private void initGameTypeBox() {
		MainMenuGUI.this.gameTypeBox = new Combo (MainMenuGUI.this.shell , SWT.READ_ONLY);
		for (GameType gt: GameType.values()) {
			MainMenuGUI.this.gameTypeBox.add(gt.toString(), gt.ordinal());
		}
		MainMenuGUI.this.gameTypeBox.select(this.gameType.ordinal());
		MainMenuGUI.this.gameTypeBox.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		MainMenuGUI.this.gameTypeBox.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				for (GameType gt: GameType.values()) {
					if (gt.toString().equals(MainMenuGUI.this.gameTypeBox.getText())) {
						MainMenuGUI.this.gameType = gt;
						break;
					}
				}
			}
		});
	}

	private void initStartDemoButton() {
		MainMenuGUI.this.startDemoButton = new Button(this.shell, SWT.NONE);
		MainMenuGUI.this.startDemoButton.setText("Starte Demo");
		MainMenuGUI.this.startDemoButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		MainMenuGUI.this.startDemoButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.gameServer = Globals.getLocalGameServer();

				PlayGameGUI playGameGUI = new PlayGameGUI(MainMenuGUI.this.display, MainMenuGUI.this);
				playGameGUI.open();

				DemoUserInterface demoUserInterface = new DemoUserInterface();
				demoUserInterface.setMainMenuGUI(MainMenuGUI.this);
				demoUserInterface.setPlayGameGUI(playGameGUI);
				
				KI.startBridgedKIOnServer(MainMenuGUI.this.gameServer, getPlayerName(), getClientUserInterface());
				KI.startBridgedKIOnServer(MainMenuGUI.this.gameServer, getEnemyName(), demoUserInterface);
			}
		});
	}

	private void initStartGameButton() {
		this.startGameButton = new Button(this.shell, SWT.NONE);
		this.startGameButton.setText("Starte Spiel");
		this.startGameButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.startGameButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GameMenuGUI gameMenuGUI = new GameMenuGUI(MainMenuGUI.this.display, MainMenuGUI.this);
				gameMenuGUI.open();
			}
		});

	}

	private void keepOpen() {
		while (!allShellsDisposed()) {
			if (!this.display.readAndDispatch()) {
				this.display.sleep();
			}
		}
		this.display.dispose();
	}

	private boolean allShellsDisposed() {
		return this.shells == 0;
	}
	
	public static void setShellLocationCenteredToScreen(Display display, Shell shell) {
		Monitor monitor = display.getPrimaryMonitor();
		Rectangle monitorBounds = monitor.getBounds();
		Rectangle shellBounds = shell.getBounds();
		int posX = monitorBounds.x + ((monitorBounds.width - shellBounds.width)/2);
		int posY = monitorBounds.y + ((monitorBounds.height - shellBounds.height)/2);
		
		shell.setLocation(posX, posY);
	}

}
