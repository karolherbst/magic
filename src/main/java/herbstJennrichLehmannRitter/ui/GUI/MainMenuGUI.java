package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
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
	
	private GameMenuGUI gameMenuGUI;
	private ChooseDeckGUI chooseDeckGUI;
	private PlayGameGUI playGameGUI;
	
	private String playerName = "Spieler";
	private String enemyName = "Computer";
	
	public MainMenuGUI() {
		this.display = new Display();
		initShell();
		initStartGameButton();
		initStartDemoButton();
		initChooseDeckButton();
		initExitButton();
		this.shell.pack();
		setShellLocationCenteredToScreen(this.display, this.shell);
		
		this.chooseDeckGUI = new ChooseDeckGUI(this.display);
		this.gameMenuGUI = new GameMenuGUI(this.display, this);
		this.shell.open();
	}
	
	public static void main(String[] args) {
		MainMenuGUI mainMenuGUI = new MainMenuGUI();
		mainMenuGUI.keepOpen();
		
		Globals.stopRemoteServer();
	}
	
	public PlayGameGUI getPlayGameGUI() {
		return this.playGameGUI;
	}
	
	public GameMenuGUI getGameMenuGui() {
		return this.gameMenuGUI;
	}
	
	public ChooseDeckGUI getChoosenCardGui() {
		return this.chooseDeckGUI;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	public void setPlayerName(String name) {
		this.playerName = name;
	}
	
	public String getEnemyName() {
		return this.enemyName;
	}
	public void setEnemyName(String name) {
		this.enemyName = name;
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shells++;
		this.shell.setText("Hauptmenü");
		this.shell.setLayout(new GridLayout(1, false));
		
		this.shell.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent d) {
				MainMenuGUI.this.shells--;
			}
		});
		this.shell.addListener(SWT.Close, new Listener() {
			@Override
			public void handleEvent(Event event) {
			}
		});
	}

	private void initChooseDeckButton() {
		this.chooseDeckButton = new Button(this.shell, SWT.NONE);
		this.chooseDeckButton.setText("Deck erstellen");
		this.chooseDeckButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.chooseDeckButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.chooseDeckGUI.open();
			}
		});
		
	}

	private void initExitButton() {
		this.exitButton = new Button(this.shell, SWT.NONE);
		this.exitButton.setText("Beenden");
		this.exitButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.shell.dispose();
			}
		});
	}

	private void initStartDemoButton() {
		this.startDemoButton = new Button(this.shell, SWT.NONE);
		this.startDemoButton.setText("Starte Demo");
		this.startDemoButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.startDemoButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlayGameGUI playGameGUI = new PlayGameGUI(display, MainMenuGUI.this, Globals.getLocalGameServer());
				playGameGUI.open();
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
				MainMenuGUI.this.gameMenuGUI.open();
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
