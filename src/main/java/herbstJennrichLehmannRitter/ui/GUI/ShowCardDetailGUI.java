package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;


/**
 * Karten Details aus dem Deck-Creator
 */

public class ShowCardDetailGUI {
	
	private Shell shell;
	private final Display display;
	private Table cardTable;
	private Button btnExit;
	

	public ShowCardDetailGUI(Display parent) {
		this.display = parent;
		initShell();
		initCardTable();
		initBtnExit();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Kartendetails");
		this.shell.setLayout(new FormLayout());
		this.shell.setSize(378, 277);
	}
	
	private void initBtnExit() {
		btnExit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnExitData = new FormData();
		btnExitData.left =  new FormAttachment(0, 1000, 282);
		btnExitData.top =  new FormAttachment(0, 1000, 100);
		btnExitData.width = 69;
		btnExitData.height = 28;
		btnExit.setLayoutData(btnExitData);
		btnExit.setText("Zurück");
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ShowCardDetailGUI.this.shell.setVisible(false);
			}
		});
	}

	private void initCardTable() {
		FormData cardTableData = new FormData();
		cardTableData.left =  new FormAttachment(0, 1000, 27);
		cardTableData.top =  new FormAttachment(0, 1000, 21);
		cardTableData.width = 197;
		cardTableData.height = 198;
		cardTable = new Table(this.shell, SWT.NONE);
		cardTable.setLayoutData(cardTableData);
	}
	
	public void open(String card) {
		this.shell.open();
	}

}
