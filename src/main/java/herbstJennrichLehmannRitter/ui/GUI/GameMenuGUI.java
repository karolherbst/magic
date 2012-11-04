package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class GameMenuGUI {

	/**
	 * Implementation Menü Spielauswahl
	 */
	
	
	private Shell shell;
	private final Display display;
	private Button startHostButton;
	private Button startClientButton;
	private Button exitButton;
	
	//Subviews
	private HostMenuGUI hostMenuGUI;
	private ClientMenuGUI clientMenuGUI;
	
	
	public GameMenuGUI(Display parent) {
		this.display = parent;
		initShell();
		initStartHostButton();
		initStartClientButton();
		initExitButton();
		
		this.hostMenuGUI = new HostMenuGUI(this.display);
		this.clientMenuGUI = new ClientMenuGUI(this.display);
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initExitButton() {
		this.exitButton = new Button(this.shell, SWT.NONE);
		this.exitButton.setText("Zurück");
		this.exitButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GameMenuGUI.this.shell.setVisible(false);
			}
		});
	}


	private void initStartClientButton() {
		this.startClientButton= new Button(this.shell, SWT.NONE);
		this.startClientButton.setText("Starte als Client");
		this.startClientButton.setToolTipText("An einem Spiel teilnehmen");
		this.startClientButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.startClientButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GameMenuGUI.this.clientMenuGUI.open();
			}
		});
	}


	private void initStartHostButton() {
		this.startHostButton = new Button(this.shell, SWT.NONE);
		this.startHostButton.setText("Starte als Host");
		this.startHostButton.setToolTipText("Ein Spiel als Server starten");
		this.startHostButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.startHostButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GameMenuGUI.this.hostMenuGUI.open();
			}
		});
	}


	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 145);
	}

}
