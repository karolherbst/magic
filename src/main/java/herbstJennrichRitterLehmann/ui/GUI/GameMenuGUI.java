package herbstJennrichRitterLehmann.ui.GUI;

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
	private Button btnStartHost;
	private Button btnStartClient;
	private Button btnExit;
	
	//Subviews
	private HostMenuGUI hostMenuGUI;
	private ClientMenuGUI clientMenuGUI;
	
	
	public GameMenuGUI(Display parent) {
		this.display = parent;
		initShell();
		initBtnStartHost();
		initBtnStartClient();
		initBtnExit();
		
		this.hostMenuGUI = new HostMenuGUI(this.display);
		this.clientMenuGUI = new ClientMenuGUI(this.display);
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initBtnExit() {
		this.btnExit = new Button(shell, SWT.NONE);
		this.btnExit.setText("Zurück");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
	}


	private void initBtnStartClient() {
		this.btnStartClient= new Button(shell, SWT.NONE);
		this.btnStartClient.setText("Starte als Client");
		this.btnStartClient.setToolTipText("An einem Spiel teilnehmen");
		this.btnStartClient.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnStartClient.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				clientMenuGUI.open();
			}
		});
	}


	private void initBtnStartHost() {
		this.btnStartHost = new Button(shell, SWT.NONE);
		this.btnStartHost.setText("Starte als Host");
		this.btnStartHost.setToolTipText("Ein Spiel als Server starten");
		this.btnStartHost.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnStartHost.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				hostMenuGUI.open();
			}
		});
	}


	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 145);
	};

}
