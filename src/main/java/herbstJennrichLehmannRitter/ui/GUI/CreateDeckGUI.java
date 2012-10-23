package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
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
public class CreateDeckGUI extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Button buttonNew;
	private Button buttonOpen;
	private Button buttonSave;
	private Button buttonReset;
	private Button buttonRightLeft;
	private Button buttonLeftRight;
	private List listBoxGameDeck;
	private List listBoxOwnDeck;
	private Button buttonExit;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public CreateDeckGUI(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(680, 480);
			{
				buttonRightLeft = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonRightLeftLData = new FormData();
				buttonRightLeftLData.left =  new FormAttachment(0, 1000, 314);
				buttonRightLeftLData.top =  new FormAttachment(0, 1000, 154);
				buttonRightLeftLData.width = 41;
				buttonRightLeftLData.height = 28;
				buttonRightLeft.setLayoutData(buttonRightLeftLData);
				buttonRightLeft.setText("<");
			}
			{
				FormData listBoxGameDeckLData = new FormData();
				listBoxGameDeckLData.left =  new FormAttachment(0, 1000, 373);
				listBoxGameDeckLData.top =  new FormAttachment(0, 1000, 52);
				listBoxGameDeckLData.width = 282;
				listBoxGameDeckLData.height = 362;
				listBoxGameDeck = new List(dialogShell, SWT.NONE);
				listBoxGameDeck.setLayoutData(listBoxGameDeckLData);
			}
			{
				FormData listBoxOwnDeckLData = new FormData();
				listBoxOwnDeckLData.left =  new FormAttachment(0, 1000, 24);
				listBoxOwnDeckLData.top =  new FormAttachment(0, 1000, 52);
				listBoxOwnDeckLData.width = 272;
				listBoxOwnDeckLData.height = 362;
				listBoxOwnDeck = new List(dialogShell, SWT.NONE);
				listBoxOwnDeck.setLayoutData(listBoxOwnDeckLData);
			}
			{
				buttonExit = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonExitLData = new FormData();
				buttonExitLData.left =  new FormAttachment(0, 1000, 590);
				buttonExitLData.top =  new FormAttachment(0, 1000, 426);
				buttonExitLData.width = 78;
				buttonExitLData.height = 28;
				buttonExit.setLayoutData(buttonExitLData);
				buttonExit.setText("Beenden");
			}
			{
				buttonReset = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonResetLData = new FormData();
				buttonResetLData.left =  new FormAttachment(0, 1000, 296);
				buttonResetLData.top =  new FormAttachment(0, 1000, 426);
				buttonResetLData.width = 77;
				buttonResetLData.height = 28;
				buttonReset.setLayoutData(buttonResetLData);
				buttonReset.setText("Reset");
			}
			{
				buttonSave = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonSaveLData = new FormData();
				buttonSaveLData.left =  new FormAttachment(0, 1000, 12);
				buttonSaveLData.top =  new FormAttachment(0, 1000, 426);
				buttonSaveLData.width = 84;
				buttonSaveLData.height = 28;
				buttonSave.setLayoutData(buttonSaveLData);
				buttonSave.setText("Speichern");
			}
			{
				buttonOpen = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonOpenLData = new FormData();
				buttonOpenLData.left =  new FormAttachment(0, 1000, 81);
				buttonOpenLData.top =  new FormAttachment(0, 1000, 12);
				buttonOpenLData.width = 68;
				buttonOpenLData.height = 28;
				buttonOpen.setLayoutData(buttonOpenLData);
				buttonOpen.setText("Öffnen");
			}
			{
				buttonNew = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonNewLData = new FormData();
				buttonNewLData.left =  new FormAttachment(0, 1000, 12);
				buttonNewLData.top =  new FormAttachment(0, 1000, 12);
				buttonNewLData.width = 63;
				buttonNewLData.height = 28;
				buttonNew.setLayoutData(buttonNewLData);
				buttonNew.setText("Neu");
			}
			{
				buttonLeftRight = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData button1LData = new FormData();
				button1LData.left =  new FormAttachment(0, 1000, 314);
				button1LData.top =  new FormAttachment(0, 1000, 260);
				button1LData.width = 41;
				button1LData.height = 28;
				buttonLeftRight.setLayoutData(button1LData);
				buttonLeftRight.setText(">");
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
