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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class HostMenuGUI {

	/**
	 * Menü des Hosts
	 */
	
	private Shell shell;
	private final Display display;
	private Button exitButton;
	private Label modeLabel;
	private Label wartenLabel;
	private Timer timer;
	
	private GameServer gameServer;
	private MainMenuGUI mainMenuGUI;

	public HostMenuGUI(Display parent, MainMenuGUI mainMenuGUI){
		this.display = parent;
		this.mainMenuGUI = mainMenuGUI;
		initShell();
		initWartenLabel();
		initModeLabel();
		initExitButton();
		this.shell.pack();
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
		
		this.mainMenuGUI.getClientUserInterface().setHostMenuGUI(this);
		
		this.gameServer = Globals.getLocalGameServer();
		try {
			this.gameServer.register(this.mainMenuGUI.getClientUserInterface());
		} catch (RemoteException e) {
			//FIXME: Karol, Catch Remote Exception richtig so?
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	private void initModeLabel() {
		String text = "Modusauswahl";
		this.modeLabel = new Label(this.shell, SWT.CENTER);
		this.modeLabel.setText(text);
		this.modeLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.modeLabel.setBounds(this.shell.getClientArea());
		
	}

	public void open() {
		this.shell.open();
		
		this.timer = new Timer();
		this.timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				display.asyncExec(new Runnable() {
					@Override
					public void run() {
						try {
							gameServer.unregister(mainMenuGUI.getClientUserInterface());
						} catch (RemoteException e) {
							System.out.println(e.getLocalizedMessage());
						}
					}
				});
			}
		}, 30000);
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
	}
	
	private void initWartenLabel() {
		String text = "";
		
		try {
			text += "Ihre IP-Adresse ist:\n";
			text += this.lookupIpAddress(); 
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
	
	public void cancelTimerAndOpenPlayGameGUI() {
		this.timer.cancel();
		PlayGameGUI playGameGUI = new PlayGameGUI(display, this.mainMenuGUI);
		playGameGUI.open();
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
	
	private String lookupIpAddress() throws SocketException {
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
				HostMenuGUI.this.shell.setVisible(false);
				Globals.stopRemoteServer();
			}
		});
	}
}
