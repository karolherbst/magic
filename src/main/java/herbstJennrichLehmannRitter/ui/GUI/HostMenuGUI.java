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
import org.eclipse.swt.widgets.Shell;

/**	Description of HostMenuGUI Class
 * Implementation of the Game as Host with IP-Adress being shown
 */

public class HostMenuGUI {
	
	private Shell shell;
	private final Display display;
	private Button exitButton;
	private Label wartenLabel;
	private Timer timer;
	
	private GameServer gameServer;
	private MainMenuGUI mainMenuGUI;
	private PlayGameGUI playGameGUI;

	public HostMenuGUI(Display parent, MainMenuGUI mainMenuGUI){
		this.display = parent;
		this.mainMenuGUI = mainMenuGUI;
		
		initGUI();
	}
	
	private void initGUI() {
		initShell();
		initWartenLabel();
		initExitButton();
		this.shell.pack();
		
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
		
		this.shell.addListener(SWT.Close, this.onCloseListener);
	}
	
	public void setPlayGameGUI(PlayGameGUI playGameGUI) {
		this.playGameGUI = playGameGUI;
	}
	
	private Listener onCloseListener = new Listener() {
		@Override
		public void handleEvent(Event event) {
			cancelTimer();
			HostMenuGUI.this.shell.setVisible(false);
			try {
				HostMenuGUI.this.gameServer.unregister(HostMenuGUI.this.mainMenuGUI.getClientUserInterface());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			Globals.stopRemoteServer();
		}
	};
	
	public void open() {
		if (this.shell.isDisposed()) {
			initGUI();
		}
		
		if (this.shell.isVisible()) {
			this.shell.forceActive();
			return;
		}
		this.mainMenuGUI.getClientUserInterface().setHostMenuGUI(this);
		this.gameServer = this.mainMenuGUI.getGameServer();
		try {
			this.gameServer.register(this.mainMenuGUI.getClientUserInterface());
		} catch (RemoteException e) {
			e.getLocalizedMessage();
		}
		
		this.shell.open();
		try {
			Globals.startRemoteServer();
		} catch (RemoteException e) {
		}
		
		this.timer = new Timer();
		this.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				HostMenuGUI.this.display.asyncExec(new Runnable() {
					@Override
					public void run() {
						String text = "Leider hat sich keiner mit dir verbunden!\n";
						text += "Hast du keine Freunde?\n";
						text += "Dann musst wohl lokal Spielen!\n";
						text += "www.facebook.de kann dir helfen";
						displayMessageBox(text);
						HostMenuGUI.this.shell.close();
					}
				});
			}
		}, 3000000);
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
	}
	
	private void initWartenLabel() {
		String text = "";
		
		try {
			text += "Ihre IP-Adresse ist:\n";
			text += lookupIpAddress(); 
			text += "\n";
		} catch (SocketException e) {
			text += "Ihre IP-Adresse ist unbekannt. Bitte prüfen Sie, ob Sie mit dem Netzwerk verbunden sind.\n";
		}
		text += "\nWarte auf Client...";
		
		this.wartenLabel = new Label(this.shell, SWT.CENTER);
		this.wartenLabel.setText(text);
		this.wartenLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.wartenLabel.setBounds(this.shell.getClientArea());
	}
	
	private void cancelTimer() {
		this.timer.cancel();
	}

	public void cancelTimerAndOpenPlayGameGUI() {
		cancelTimer();
		this.shell.setVisible(false);
		try {
			this.mainMenuGUI.getGameServer().start(this.mainMenuGUI.getGameType());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		this.playGameGUI.open();
	}
	
	public void displayMessageBox(String text) {
		MessageBox msgBox = new MessageBox(this.shell);
		msgBox.setMessage(text);
		msgBox.open();
		if (this.timer != null) {
			this.timer.purge();
		}
		this.shell.setVisible(false);
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
		this.exitButton = new Button(this.shell, SWT.NONE);
		this.exitButton.setText("Abbrechen");
		this.exitButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HostMenuGUI.this.shell.close();
			}
		});
	}
}
