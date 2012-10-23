package herbstJennrichLehmannRitter.ui.GUI;
import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
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
public class GameClientGUI extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Text textBoxHostAdress;
	private Text textBoxHeadline;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	
	public GameClientGUI(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			
			
			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(250, 100);
			{
				textBoxHeadline = new Text(dialogShell, SWT.MULTI | SWT.WRAP);
				FormData textBoxHeadlineLData = new FormData();
				textBoxHeadlineLData.left =  new FormAttachment(0, 1000, 12);
				textBoxHeadlineLData.top =  new FormAttachment(0, 1000, 19);
				textBoxHeadlineLData.width = 224;
				textBoxHeadlineLData.height = 13;
				textBoxHeadline.setLayoutData(textBoxHeadlineLData);
				textBoxHeadline.setText("Bitte IP-Adresse des Servers angeben");
				textBoxHeadline.setEditable(false);
				textBoxHeadline.setBackground(SWTResourceManager.getColor(184, 184, 184));
			}
			{
				textBoxHostAdress = new Text(dialogShell, SWT.NONE);
				FormData textBoxHostAdressLData = new FormData();
				textBoxHostAdressLData.left =  new FormAttachment(0, 1000, 12);
				textBoxHostAdressLData.top =  new FormAttachment(0, 1000, 38);
				textBoxHostAdressLData.width = 224;
				textBoxHostAdressLData.height = 19;
				textBoxHostAdress.setLayoutData(textBoxHostAdressLData);
				textBoxHostAdress.setText("127.0.0.1");
				textBoxHostAdress.setToolTipText("IP-Adresse des Servers eingeben");
				textBoxHostAdress.setFont(SWTResourceManager.getFont("Lucida Grande", 16, 0, false, false));
				textBoxHostAdress.setDoubleClickEnabled(false);
				textBoxHostAdress.setDragDetect(false);
				textBoxHostAdress.setOrientation(SWT.HORIZONTAL);
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
