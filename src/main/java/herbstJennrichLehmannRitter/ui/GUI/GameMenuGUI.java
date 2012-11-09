package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
public class GameMenuGUI {

	/**
	 * Implementation Menü Spielauswahl
	 */
	private Shell shell;
	private final Display display;
	private Label nameTextLabel;
	private Text nameTextField;
	private Label selectionTextLabel;
	private Button startHostButton;
	private Button startClientButton;
	private Button startLocalButton;
	private Button backButton;
	
	private MainMenuGUI mainMenuGUI;
	
	public GameMenuGUI(Display parent, MainMenuGUI mainMenuGUI) {
		this.display = parent;
		this.mainMenuGUI = mainMenuGUI;
		initShell();
		initNameTextLabel();
		initNameTextField();
		initSelectionTextLabel();
		initStartHostButton();
		initStartClientButton();
		initStartLocalButton();
		initBackButton();
		this.shell.pack();
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
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
		this.nameTextField.setText(this.mainMenuGUI.getPlayerName());
		this.nameTextField.setLayoutData(gridData);
		this.nameTextField.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				Text changedText = (Text)e.widget;
				mainMenuGUI.setPlayerName(changedText.getText());
			}
		});
	}
	
	private void initSelectionTextLabel() {
	    GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalSpan = 3;
		
		this.selectionTextLabel = new Label(this.shell, SWT.FILL);
		this.selectionTextLabel.setText("Wählen Sie ihre Spieloption aus:");
		this.selectionTextLabel.setBackground(this.shell.getBackground());
		this.selectionTextLabel.setLayoutData(gridData);		
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
				HostMenuGUI hostMenuGUI = new HostMenuGUI(display, mainMenuGUI);
				hostMenuGUI.open();
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
				ClientMenuGUI clientMenuGUI = new ClientMenuGUI(display);
				clientMenuGUI.open();
			}
		});
	}
	
	private void initStartLocalButton() {
		this.startLocalButton= new Button(this.shell, SWT.NONE);
		this.startLocalButton.setText("Lokales Spiel starten");
		this.startLocalButton.setToolTipText("Ein Spiel gegen die KI starten");
		this.startLocalButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.startLocalButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlayGameGUI playGameGUI = new PlayGameGUI(display, mainMenuGUI, Globals.getLocalGameServer());
				playGameGUI.open();
			}
		});
	}
	
	private void initBackButton() {
		this.backButton = new Button(this.shell, SWT.NONE);
		this.backButton.setText("Zurück");
		this.backButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER,
				true, false));
		this.backButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GameMenuGUI.this.shell.setVisible(false);
			}
		});
	}
}
