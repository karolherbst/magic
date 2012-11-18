package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.server.GameServer;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;

/**	Description of HostMenuGUI Class
 * Implementation of the Game as Host with IP-Adress being shown
 */

public class HostMenuGUI extends AbstractMagicGUIElement {
	
	private Button exitButton;
	private Label wartenLabel;
	private Timer timer;
	
	private GameServer gameServer;
	private MainMenuGUI mainMenuGUI;
	private PlayGameGUI playGameGUI;

	public HostMenuGUI(Display parent, MainMenuGUI mainMenuGUI){
		super(parent);
		this.mainMenuGUI = mainMenuGUI;
		initGUI();
	}
	
	@Override
	protected void onInitGUI() {
		initWartenLabel();
		initExitButton();
	}
	
	public void setPlayGameGUI(PlayGameGUI playGameGUI) {
		this.playGameGUI = playGameGUI;
	}
	
	@Override
	protected Listener getOnCloseListener() {
		return new Listener() {
			@Override
			public void handleEvent(Event event) {
				cancelTimer();
				try {
					HostMenuGUI.this.gameServer.unregister();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				Globals.stopRemoteServer();
			}
		};
	}
	
	@Override
	protected void onOpen() {
		this.mainMenuGUI.getClientUserInterface().setHostMenuGUI(this);
		this.gameServer = this.mainMenuGUI.getGameServer();
		try {
			this.gameServer.register(this.mainMenuGUI.getClientUserInterface());
		} catch (RemoteException e) {
			e.getLocalizedMessage();
		}
		
		try {
			Globals.startRemoteServer();
		} catch (RemoteException e) {
		}
		
		this.timer = new Timer();
		this.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						String text = "Leider hat sich keiner mit dir verbunden!\n";
						text += "Hast du keine Freunde?\n";
						text += "Dann musst wohl lokal Spielen!\n";
						text += "www.facebook.de kann dir helfen";
						displayMessageBox(text);
						getShell().close();
					}
				});
			}
		}, 60000);
	}
	
	@Override
	protected void onInitShell() {
		getShell().setText("Spielauswahl");
		getShell().setLayout(new GridLayout(1, false));
	}
	
	private void initWartenLabel() {
		String text = "";
		
		try {
			text += "Ihre IP-Adresse ist:\n";
			text += lookupIpAddress(); 
			text += "\n";
		} catch (SocketException e) {
			text += "Ihre IP-Adresse ist unbekannt. " +
					"Bitte prüfen Sie, ob Sie mit dem Netzwerk verbunden sind.\n";
		}
		text += "\nWarte auf Client...";
		
		this.wartenLabel = new Label(getShell(), SWT.CENTER);
		this.wartenLabel.setText(text);
		this.wartenLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.wartenLabel.setBounds(getShell().getClientArea());
	}
	
	private void cancelTimer() {
		this.timer.cancel();
	}

	public void cancelTimerAndOpenPlayGameGUI() {
		cancelTimer();
		try {
			this.mainMenuGUI.getGameServer().start(this.mainMenuGUI.getGameType());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.playGameGUI.open();
		this.playGameGUI.nextTurnEnemy();
	}
	
	public void displayMessageBox(String text) {
		MessageBox msgBox = new MessageBox(getShell());
		msgBox.setMessage(text);
		msgBox.open();
		if (this.timer != null) {
			this.timer.purge();
		}
		getShell().setVisible(false);
	}
	
	private static String lookupIpAddress() throws SocketException {
		Collection<String> allIPs = new ArrayList<String>();  
		Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
		for (NetworkInterface netinterface : Collections.list(networkInterfaces)) {
			for (InetAddress ipAdress : Collections.list(netinterface.getInetAddresses())) {
				String ip = ipAdress.toString();
				if (!ip.contains("/127.0.0.1") && !ip.contains("/fe80") && !ip.contains("/0:0:0")) {
					allIPs.add(ip.replace("/", "").toString());
				}
			}
		}
		return allIPs.toString().replace("[", "").replace("]", "");
	}

	private void initExitButton() {
		this.exitButton = new Button(getShell(), SWT.NONE);
		this.exitButton.setText("Abbrechen");
		this.exitButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getShell().close();
			}
		});
	}
}
