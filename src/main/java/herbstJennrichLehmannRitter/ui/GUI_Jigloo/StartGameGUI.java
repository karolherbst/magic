package herbstJennrichLehmannRitter.ui.GUI_Jigloo;

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
public class StartGameGUI extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Button buttonStartGameHost;
	private Button buttonStartGameClient;
	private Button buttonBack;
	private Button buttonStartKI;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public StartGameGUI(Shell parent, int style) {
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
				buttonStartGameHost = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonStartLData = new FormData();
				buttonStartLData.left =  new FormAttachment(0, 1000, 38);
				buttonStartLData.top =  new FormAttachment(0, 1000, 25);
				buttonStartLData.width = 134;
				buttonStartLData.height = 28;
				buttonStartGameHost.setLayoutData(buttonStartLData);
				buttonStartGameHost.setText("Starte Spiel als Host");
			}
			{
				buttonStartGameClient = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.left =  new FormAttachment(0, 1000, 38);
				button1LData.top =  new FormAttachment(0, 1000, 59);
				button1LData.width = 134;
				button1LData.height = 28;
				buttonStartGameClient.setLayoutData(button1LData);
				buttonStartGameClient.setText("Teilnehmen");
			}
			{
				buttonBack = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData button1LData1 = new FormData();
				button1LData1.left =  new FormAttachment(0, 1000, 38);
				button1LData1.top =  new FormAttachment(0, 1000, 127);
				button1LData1.width = 134;
				button1LData1.height = 28;
				buttonBack.setLayoutData(button1LData1);
				buttonBack.setText("Zurück");
			}
			{
				buttonStartKI = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData button1LData2 = new FormData();
				button1LData2.left =  new FormAttachment(0, 1000, 38);
				button1LData2.top =  new FormAttachment(0, 1000, 93);
				button1LData2.width = 134;
				button1LData2.height = 28;
				buttonStartKI.setLayoutData(button1LData2);
				buttonStartKI.setText("gegen Computer");
			}
			dialogShell.setLocation(getParent().toDisplay(200, 200));
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
