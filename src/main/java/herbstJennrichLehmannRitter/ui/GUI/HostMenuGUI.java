package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class HostMenuGUI {

	/**
	 * Menü des Hosts
	 */
	
	private Shell shell;
	private final Display display;
	private Button exitButton;
	private Label modeLabel;
	private Combo gameModeBox;
	private Label wartenLabel;

	public HostMenuGUI(Display parent){
		this.display = parent;
		initShell();
		initWartenLabel();
		initModeLabel();
		initGameModeBox();
		initExitButton();
		this.shell.pack();
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	private void initModeLabel() {
		String text = "Modusauswahl";
		this.modeLabel = new Label(this.shell, SWT.CENTER);
		this.modeLabel.setText(text);
		this.modeLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.modeLabel.setBounds(this.shell.getClientArea());
		
	}

	private void initGameModeBox() {
		this.gameModeBox = new Combo (this.shell , SWT.READ_ONLY);
		String modes[] = { "Turmbau", "Sammelwut"};
		this.gameModeBox.setItems(modes);
		this.gameModeBox.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		
	}

	public void open() {
		this.shell.open();
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
		
		//TODO TODO wie erkenne ich, ob der andere Spieler sich verbunden hat?
		//TODO Implementation GameServer
		try {
			Globals.startRemoteServer();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public String getGameMode(){
		return this.gameModeBox.getText();
	}
}
