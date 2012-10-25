package herbstJennrichRitterLehmann.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class ChooseDeckGUI {

	/**
	 * @param args
	 */
	private Shell shell;
	private final Display display;
	private Button btnBack;
	private List lstUser;
	private List lstSystem;

	
	
	public ChooseDeckGUI(Display parent){
		this.display = parent;
		initShell();
		initBtnBack();
		initlstUser();
	}

	private void initlstUser() {
		this.lstUser = new List(shell, SWT.MULTI | SWT.BORDER | SWT.V_SCROLL);
		lstUser.setItems(new String[] { "Muff", "(.) (.)"});
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		gridData.verticalSpan = 4;
		int listHeight = lstUser.getItemHeight() * 12;
		Rectangle trim = lstUser.computeTrim(0, 0, 0, listHeight);
		gridData.heightHint = trim.height;
		lstUser.setLayoutData(gridData);
	}

	private void initBtnBack() {
		this.btnBack = new Button(shell, SWT.NONE);
		this.btnBack.setText("Zurück");
		this.btnBack.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
			});
		
	}

	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Starte Spiel als Client");
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		shell.setLayout(gridLayout);
	}
}
