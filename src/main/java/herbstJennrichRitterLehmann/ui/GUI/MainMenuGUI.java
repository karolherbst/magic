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
	 * Implementation Hauptmenue
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
		initBtnSartDemo();
		initBtnNewWindow();
		initBtnExit();
		shell.open();
	}

	private void initBtnNewWindow() {
		btnNewWindow = new Button(shell, SWT.NONE);
		btnNewWindow.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		btnNewWindow.setText("(.)(.)");
		btnNewWindow.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new MainMenuGUI();
			}
		});

	}

	private void initBtnExit() {
		btnExit = new Button(shell, SWT.NONE);
		btnExit.setText("Beenden");
		btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		btnExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
			});
	}

	private void initBtnSartDemo() {
		btnSartDemo = new Button(shell, SWT.NONE);
		btnSartDemo.setText("Starte Demo");
		btnSartDemo.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		btnSartDemo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}

		});
	}

	private void initBtnStartGame() {
		btnStartGame = new Button(shell, SWT.NONE);
		btnStartGame.setText("Starte Spiel");
		btnStartGame.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnStartGame.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
	}


	private void initShell() {
		shell = new Shell(SWT.TITLE | SWT.CLOSE);
		shells++;
		shell.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent d) {
				shells--;
			}
		});
		shell.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
			}
		});
		shell.setText("Hauptmenü");
		shell.setLayout(new GridLayout(1, false));
		shell.setSize(220, 180);
		
	};


	private static void startLoop() {
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
		startLoop();
	}
}
