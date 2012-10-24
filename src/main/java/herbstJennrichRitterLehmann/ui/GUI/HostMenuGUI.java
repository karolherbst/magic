package herbstJennrichRitterLehmann.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

public class HostMenuGUI {

	/**
	 * Menü des Hosts
	 */
	
	private Shell shell;
	private static Display display;
	private Button btnExit;
	private Label lblWfC;
	
	public HostMenuGUI(){
		initShell();
		initLblWfC();
		initBtnExit();
		shell.open();
		 while (!shell.isDisposed()) {
	          if (!display.readAndDispatch()) {
	            display.sleep();
	          }
	      }	
	}
	
	private void initLblWfC() {
		this.lblWfC = new Label(shell, SWT.CENTER);
		this.lblWfC.setText("Warte auf Client");
		this.lblWfC.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.lblWfC.setBounds(shell.getClientArea());
		
	}

	private void initBtnExit() {
		this.btnExit = new Button(shell, SWT.NONE);
		this.btnExit.setText("Abbrechen");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
		});
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 100);
	};
	
	public static void main(String[] args) {
		display = new Display();
		new HostMenuGUI();
	}
}