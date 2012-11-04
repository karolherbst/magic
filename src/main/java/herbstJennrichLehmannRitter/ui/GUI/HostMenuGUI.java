package herbstJennrichLehmannRitter.ui.GUI;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
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
	private Label wartenLabel;
	
	public HostMenuGUI(Display parent){
		this.display = parent;
		initShell();
		initWartenLabel();
		initExitButton();
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spielauswahl");
		this.shell.setLayout(new GridLayout(1, false));
		this.shell.setSize(220, 140);
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	private void initWartenLabel() {
		String text = "";
		try {
			text += "Ihre IP-Adresse ist:\n";
			text += InetAddress.getLocalHost().getHostAddress();
			text += "\n";
		} catch (UnknownHostException e) {
			text += "Ihre IP-Adresse ist unbekannt. Bitte prüfen Sie, ob Sie mit dem Internet verbunden sind.\n";
		}
		text += "\nWarte auf Client...";
		
		this.wartenLabel = new Label(this.shell, SWT.CENTER);
		this.wartenLabel.setText(text);
		this.wartenLabel.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.wartenLabel.setBounds(this.shell.getClientArea());
	}

	private void initExitButton() {
		this.exitButton = new Button(this.shell, SWT.NONE);
		this.exitButton.setText("Abbrechen");
		this.exitButton.setLayoutData(new GridData(GridData.FILL, GridData.CENTER, true, false));
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				HostMenuGUI.this.shell.setVisible(false);
			}
		});
	}	
}
