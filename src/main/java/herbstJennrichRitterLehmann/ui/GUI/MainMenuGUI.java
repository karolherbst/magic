package herbstJennrichRitterLehmann.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
public class MainMenuGUI {

	/**
	 * Implementation Hauptmenü
	 * TODO: Event neues Fenster anderer Klasse öffnen!
	 */
	
	private static MainMenuGUI mainMenuGUI;
	
	private int shells = 0;
	private Shell shell;
	private Display display;
	private Button btnStartGame;
	private Button btnStartDemo;
	private Button btnChooseDeck;
	private Button btnExit;
	
	// subviews
	private GameMenuGUI gameMenuGUI;
	private ChooseDeckGUI chooseDeckGUI;
	private PlayGameGUI playGameGUI;
	
	
	public MainMenuGUI() {
		this.display = new Display();
		initShell();
		initBtnStartGame();
		initBtnStartDemo();
		initBtnChooseDeck();
		initBtnExit();
		
		this.gameMenuGUI = new GameMenuGUI(this.display);
		this.chooseDeckGUI = new ChooseDeckGUI(this.display);
		this.playGameGUI = new PlayGameGUI(this.display);

		
		this.shell.open();
	}

	private void initBtnChooseDeck() {
		this.btnChooseDeck = new Button(this.shell, SWT.NONE);
		this.btnChooseDeck.setText("Deck erstellen");
		this.btnChooseDeck.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnChooseDeck.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.chooseDeckGUI.open();
			}
		});
		
	}

	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.NONE);
		this.btnExit.setText("Beenden");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.shell.dispose();
			}
		});
	}

	private void initBtnStartDemo() {
		this.btnStartDemo = new Button(this.shell, SWT.NONE);
		this.btnStartDemo.setText("Starte Demo");
		this.btnStartDemo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnStartDemo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.playGameGUI.open();
			}
		});
	}

	private void initBtnStartGame() {
		this.btnStartGame = new Button(this.shell, SWT.NONE);
		this.btnStartGame.setText("Starte Spiel");
		this.btnStartGame.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnStartGame.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainMenuGUI.this.gameMenuGUI.open();
			}
		});

	}


	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shells++;
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
		this.shell.setText("Hauptmenü");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 180);
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

	public static void main(String[] args) {
		mainMenuGUI = new MainMenuGUI();
		mainMenuGUI.keepOpen();
	}
}
