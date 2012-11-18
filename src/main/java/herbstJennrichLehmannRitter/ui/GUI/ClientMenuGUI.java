package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.server.NetworkServer;
import herbstJennrichLehmannRitter.server.impl.NetworkServerWrapper;
import herbstJennrichLehmannRitter.ui.impl.ClientUserInterface;
import herbstJennrichLehmannRitter.ui.impl.RMIUserInterfaceImpl;

import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

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

/**	Description of ClientMenuGUI Class
 * Implementation of the Game as Client with the possibility to enter an IP-Adress
 */

public class ClientMenuGUI {

	
	private Shell shell;
	private final Display display;
	private Text ipTextField;
	private Label ipTextLabel;
	private Button connectButton;
	private Button backButton;
	
	private MainMenuGUI mainMenuGUI;
	private Timer timer;
	private PlayGameGUI playGameGUI;
	
	public ClientMenuGUI(Display parent, MainMenuGUI mainMenuGUI) {
		this.display = parent;
		this.mainMenuGUI = mainMenuGUI;
		initShell();
		initIpTextLabel();
		initIpTextField();
		initConnectButton();
		initBackButton();
		this.shell.pack();
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Starte Spiel als Client");
		this.shell.setLayout(new GridLayout(2, false));
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
				final NetworkServer gameServer = Globals.getRemoteServer(ClientMenuGUI.this.ipTextField.getText(),
						ClientMenuGUI.this.shell);
				ClientMenuGUI.this.timer = new Timer();
				
				ClientUserInterface clientUserInterface = new ClientUserInterface();
				try {
					final RMIUserInterfaceImpl rmi = new RMIUserInterfaceImpl(clientUserInterface);
					ClientMenuGUI.this.timer.schedule(new TimerTask() {
						@Override
						public void run() {
							ClientMenuGUI.this.display.asyncExec(new Runnable() {
								@Override
								public void run() {
									try {
										gameServer.unregister();
									} catch (RemoteException e) {
										System.out.println(e.getLocalizedMessage());
									}
								}
							});
						}
					}, 3000000);
					ClientMenuGUI.this.mainMenuGUI.setGameServer(new NetworkServerWrapper(gameServer));
					
					PlayGameGUI playGameGUI = new PlayGameGUI(ClientMenuGUI.this.display, 
							clientUserInterface, new NetworkServerWrapper(gameServer));
					
					ClientMenuGUI.this.playGameGUI = playGameGUI;
					
					clientUserInterface.setMainMenuGUI(ClientMenuGUI.this.mainMenuGUI);
					clientUserInterface.setClientMenuGUI(ClientMenuGUI.this);
					clientUserInterface.setPlayGameGUI(ClientMenuGUI.this.playGameGUI);
					
					gameServer.register(rmi);
				} catch (RemoteException e1) {
				} catch (NullPointerException e2) {
					ClientMenuGUI.this.shell.setVisible(false);
				}
			}
		});
	}

	public void cancelTimerAndOpenPlayGameGUI() {
		this.timer.cancel();
		this.playGameGUI.setPlayerName(ClientMenuGUI.this.mainMenuGUI.getPlayerName());
		this.playGameGUI.setEnemyName("Gegner");
		this.playGameGUI.open();
	}	
}
