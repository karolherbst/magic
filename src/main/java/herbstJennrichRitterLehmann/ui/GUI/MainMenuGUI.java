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
	private Button btnSartDemo;
	private Button btnExit;
	
	// subviews
	private GameMenuGUI gameMenuGUI;
	
	
	public MainMenuGUI() {
		this.display = new Display();
		initShell();
		initBtnStartGame();
		initBtnSartDemo();
		initBtnExit();
		
		this.gameMenuGUI = new GameMenuGUI(this.display);

		
		this.shell.open();
	}

	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.NONE);
		this.btnExit.setText("Beenden");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
	}

	private void initBtnSartDemo() {
		this.btnSartDemo = new Button(this.shell, SWT.NONE);
		this.btnSartDemo.setText("Starte Demo");
		this.btnSartDemo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
	}

	private void initBtnStartGame() {
		this.btnStartGame = new Button(this.shell, SWT.NONE);
		this.btnStartGame.setText("Starte Spiel");
		this.btnStartGame.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnStartGame.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				gameMenuGUI.open();
			}
		});

	}


	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shells++;
		this.shell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent d) {
				shells--;
			}
		});
		this.shell.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
			}
		});
		this.shell.setText("Hauptmenü");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 180);
	}


	private void keepOpen() {
		while (!allShellsDisposed()) {
			if (!this.display.readAndDispatch())
				this.display.sleep();
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
