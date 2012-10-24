package herbstJennrichRitterLehmann.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
public class MainMenuGUI {

	/**
	 * Implementation Hauptmenü
	 * TODO: Event neues Fenster anderer Klasse öffnen!
	 */
	
	private static int shells = 0;
	private Shell shell;
	private static Display display;
	private Button btnStartGame;
	private Button btnSartDemo;
	private Button btnNewWindow;
	private Button btnExit;
	
	public MainMenuGUI() {
		initShell();
		initBtnStartGame();
		initBtnStartDemo();
		initBtnNewWindow();
		initBtnExit();
		shell.open();
	}

	private void initBtnNewWindow() {
		this.btnNewWindow = new Button(shell, SWT.NONE);
		this.btnNewWindow.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnNewWindow.setText("(*) (.)");
		this.btnNewWindow.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new MainMenuGUI();
			}
		});
	}

	private void initBtnExit() {
		this.btnExit = new Button(shell, SWT.NONE);
		this.btnExit.setText("Beenden");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
			});
	}

	private void initBtnStartDemo() {
		this.btnSartDemo = new Button(shell, SWT.NONE);
		this.btnSartDemo.setText("Starte Demo");
		this.btnSartDemo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnSartDemo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
	}

	private void initBtnStartGame() {
		this.btnStartGame = new Button(shell, SWT.NONE);
		this.btnStartGame.setText("Starte Spiel");
		this.btnStartGame.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnStartGame.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				GameMenuGUI GameMenu = new GameMenuGUI();
				
			}
		});

	}


	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		shells++;
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
	};


	private static void keepOpen() {
		while (!allShellsDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private static boolean allShellsDisposed() {
		return shells == 0;
	}

	public static void main(String[] args) {
		display = new Display();
		new MainMenuGUI();
		keepOpen();
	}
}
