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
public class ClientMenuGUI {

	/**
	 * Implementation des Spiels als Client mit der Eingabe der IP-Adresse
	 */
	
	private Shell shell;
	private final Display display;
	private Button btnEntryCorrect;
	private Button btnBack;
	private Text txtIpBox;
	
	public ClientMenuGUI(Display parent) {
		this.display = parent;
		initShell();
		initIpBox();
		initBtnEntryCorrect();
		initBtnBack();
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initIpBox() {
	    this.txtIpBox = new Text(shell, SWT.FILL);
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		this.txtIpBox.setLayoutData(gridData);
	}

	private void initBtnBack() {
		this.btnBack = new Button(shell, SWT.NONE);
		this.btnBack.setText("Zurück");
		this.btnBack.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.btnBack.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.dispose();
			}
			});
	}



	private void initBtnEntryCorrect() {
		this.btnEntryCorrect = new Button(shell, SWT.NONE);
		this.btnEntryCorrect.setText("OK");
		this.btnEntryCorrect.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
			}
		});
		this.btnEntryCorrect.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
	}


	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Starte Spiel als Client");
		this.shell.setLayout(new GridLayout(2, false));
		this.shell.setSize(250, 85);
	};
	
}
