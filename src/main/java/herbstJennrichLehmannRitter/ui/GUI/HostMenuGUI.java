package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HostMenuGUI {

	/**
	 * Menü des Hosts
	 */
	
	private Shell shell;
	private final Display display;
	private Button btnExit;
	private Label lblWfC;
	

	
	
	public HostMenuGUI(Display parent){
		this.display = parent;
		initShell();
		initLblWfC();
		initBtnExit();
	}
	
	
	public void open() {
		this.shell.open();
	}
	
	private void initLblWfC() {
		this.lblWfC = new Label(this.shell, SWT.CENTER);
		this.lblWfC.setText("Warte auf Client");
		this.lblWfC.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.lblWfC.setBounds(this.shell.getClientArea());
		
	}

	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.NONE);
		this.btnExit.setText("Abbrechen");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HostMenuGUI.this.shell.setVisible(false);
			}
		});
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 100);
	}
	
}
