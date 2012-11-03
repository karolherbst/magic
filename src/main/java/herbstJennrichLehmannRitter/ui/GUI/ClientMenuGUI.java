package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Data;
import herbstJennrichLehmannRitter.engine.model.impl.DataImpl;
import herbstJennrichLehmannRitter.ui.UserInterface;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
public class ClientMenuGUI {

	/**
	 * Implementation des Spiels als Client mit der Eingabe der IP-Adresse
	 */
	
	private Shell shell;
	//FIXME: We never use the display, why is it implemented? See also the other GUI classes (Sebastian)
	private final Display display;
	private Text ipTextField;
	private Label ipTextLabel;
	private Text nameTextField;
	private Label nameTextLabel;
	private Button connectButton;
	private Button backButton;
	
	public ClientMenuGUI(Display parent) {
		this.display = parent;
		initShell();
		initNameTextLabel();
		initNameTextField();
		initIpTextLabel();
		initIpTextField();
		initConnectButton();
		initBackButton();
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Starte Spiel als Client");
		this.shell.setLayout(new GridLayout(2, false));
		this.shell.setSize(250, 150);
	}

	private void initNameTextLabel() {
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		
		this.nameTextLabel = new Label(this.shell, SWT.FILL);
		this.nameTextLabel.setText("Bitte geben Sie ihren Namen an:");
		this.nameTextLabel.setBackground(this.shell.getBackground());
		this.nameTextLabel.setLayoutData(gridData);
	}
	
	private void initNameTextField() {
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		
		this.nameTextField = new Text(this.shell, SWT.FILL);
		this.nameTextField.setLayoutData(gridData);
	}	
	
	private void initIpTextLabel() {
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		
		this.ipTextLabel = new Label(this.shell, SWT.FILL);
		this.ipTextLabel.setText("Bitte geben Sie die IP vom Server an:");
		this.ipTextLabel.setBackground(this.shell.getBackground());
		this.ipTextLabel.setLayoutData(gridData);
	}	
	
	private void initIpTextField() {
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		
		this.ipTextField = new Text(this.shell, SWT.FILL);
		this.ipTextField.setLayoutData(gridData);
	}

	private void initBackButton() {
		this.backButton = new Button(this.shell, SWT.NONE);
		this.backButton.setText("Zurück");
		this.backButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		this.backButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ClientMenuGUI.this.shell.setVisible(false);
			}
		});
	}


	private void initConnectButton() {
		this.connectButton = new Button(this.shell, SWT.NONE);
		this.connectButton.setText("Verbinden");
		this.connectButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
		this.connectButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//FIXME: Ich (Sebastian) bin zu blöd um mir das Data zu holen... wo zum Teufel bekomme ich das her...
				Data data = new DataImpl();
				data.getOwnPlayer().setName(nameTextField.getText());
				//FIXME: no enclosing => weil UserInterface nicht statisch... also wo bekomme ich nun schon wieder userInterface her... 
//				UserInterface.this.setData(data);
			}
		});
	}	
}
