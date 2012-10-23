package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
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
public class ChosenCardGUI extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Table tableCardContent;
	private Button buttonBack;
	private Button buttonThrow;
	private Button buttonChose;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public ChosenCardGUI(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(360, 480);
			{
				buttonBack = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonBackLData = new FormData();
				buttonBackLData.left =  new FormAttachment(0, 1000, 260);
				buttonBackLData.top =  new FormAttachment(0, 1000, 243);
				buttonBackLData.width = 88;
				buttonBackLData.height = 28;
				buttonBack.setLayoutData(buttonBackLData);
				buttonBack.setText("zurück");
			}
			{
				buttonThrow = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonThrowLData = new FormData();
				buttonThrowLData.left =  new FormAttachment(0, 1000, 260);
				buttonThrowLData.top =  new FormAttachment(0, 1000, 192);
				buttonThrowLData.width = 88;
				buttonThrowLData.height = 28;
				buttonThrow.setLayoutData(buttonThrowLData);
				buttonThrow.setText("verwerfen");
			}
			{
				buttonChose = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData buttonChoseLData = new FormData();
				buttonChoseLData.left =  new FormAttachment(0, 1000, 260);
				buttonChoseLData.top =  new FormAttachment(0, 1000, 140);
				buttonChoseLData.width = 88;
				buttonChoseLData.height = 28;
				buttonChose.setLayoutData(buttonChoseLData);
				buttonChose.setText("auswählen");
			}
			{
				FormData tableCardContentLData = new FormData();
				tableCardContentLData.left =  new FormAttachment(0, 1000, 12);
				tableCardContentLData.top =  new FormAttachment(0, 1000, 45);
				tableCardContentLData.width = 213;
				tableCardContentLData.height = 352;
				tableCardContent = new Table(dialogShell, SWT.NONE);
				tableCardContent.setLayoutData(tableCardContentLData);
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
