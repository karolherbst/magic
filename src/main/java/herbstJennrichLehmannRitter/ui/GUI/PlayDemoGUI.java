package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class PlayDemoGUI {

	/**
	 * Implementation des Spiels
	 */
	
	
	private Shell shell;
	private final Display display;
	private Button btnExit;
	private Button btnEnemyOne;
	
	
	
	public PlayDemoGUI(Display parent) {
		this.display = parent;
		initShell();
		initBtnExit();
		initBtnEnemyOne();
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.NONE);
		this.btnExit.setText("Zurück");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.END,
				true, true));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlayDemoGUI.this.shell.setVisible(false);
			}
		});
	}
	
	private void initBtnEnemyOne() {
		this.btnEnemyOne = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnEnemyOneData = new FormData();
		btnEnemyOneData.left =  new FormAttachment(0, 1000, 12);
		btnEnemyOneData.top =  new FormAttachment(0, 1000, 12);
		btnEnemyOneData.width = 90;
		btnEnemyOneData.height = 28;
	
	}

	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spiel");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(1024, 600);
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}

}
