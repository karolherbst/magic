package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class MainGUI extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Button buttonExit;
	private Button buttonStartDemo;
	private Button buttonStartGame;
	private Button buttonCreateDeck;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public MainGUI(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(215, 204);
			{
				buttonExit = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonExitLData = new FormData();
				buttonExitLData.left =  new FormAttachment(0, 1000, 37);
				buttonExitLData.top =  new FormAttachment(0, 1000, 127);
				buttonExitLData.width = 134;
				buttonExitLData.height = 28;
				buttonExit.setLayoutData(buttonExitLData);
				buttonExit.setText("Beenden");
			}
			{
				buttonCreateDeck = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonStartKILData = new FormData();
				buttonStartKILData.left =  new FormAttachment(0, 1000, 37);
				buttonStartKILData.top =  new FormAttachment(0, 1000, 93);
				buttonStartKILData.width = 134;
				buttonStartKILData.height = 28;
				buttonCreateDeck.setLayoutData(buttonStartKILData);
				buttonCreateDeck.setText("Deck erstellen");
			}
			{
				buttonStartDemo = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonStartGameClientLData = new FormData();
				buttonStartGameClientLData.left =  new FormAttachment(0, 1000, 37);
				buttonStartGameClientLData.top =  new FormAttachment(0, 1000, 59);
				buttonStartGameClientLData.width = 134;
				buttonStartGameClientLData.height = 28;
				buttonStartDemo.setLayoutData(buttonStartGameClientLData);
				buttonStartDemo.setText("Demo");
			}
			{
				buttonStartGame = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonStartGameHostLData = new FormData();
				buttonStartGameHostLData.left =  new FormAttachment(0, 1000, 37);
				buttonStartGameHostLData.top =  new FormAttachment(0, 1000, 25);
				buttonStartGameHostLData.width = 134;
				buttonStartGameHostLData.height = 28;
				buttonStartGame.setLayoutData(buttonStartGameHostLData);
				buttonStartGame.setText("Starte Spiel");
			}
			dialogShell.setLocation(getParent().toDisplay(100, 100));
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
