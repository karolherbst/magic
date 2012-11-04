package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
public class PlayGameGUI {

	/**
	 * Implementation des Spiels
	 */
	
	
	private Shell shell;
	private final Display display;
	private Button btnExit;
	
	
	
	public PlayGameGUI(Display parent) {
		this.display = parent;
		initShell();
		initBtnExit();
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.NONE);
		this.btnExit.setText("Schließen");
		this.btnExit.setLayoutData(new GridData(GridData.FILL, GridData.END,
				true, true));
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlayGameGUI.this.shell.setVisible(false);
			}
		});
	}

	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spiel");
		this.shell.setLayout(new GridLayout(6, false));
		this.shell.setSize(1024, 600);
	}

}
