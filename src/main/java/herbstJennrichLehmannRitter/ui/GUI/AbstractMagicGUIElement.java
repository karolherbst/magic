package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

/**	Description of AbstractMagicGUIElement Class
 * Abstract class for the GUI
 */

public abstract class AbstractMagicGUIElement {
	
	private Shell shell;
	private final Display display;
	
	public AbstractMagicGUIElement(Display parent) {
		this.display = parent;
		initShell();
	}
	
	final public void open() {
		if (this.shell.isDisposed()) {
			initShell();
			initGUI();
		}
		
		if (this.shell.isVisible()) {
			this.shell.forceActive();
			return;
		}
		this.shell.open();
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
		onOpen();
	}
	
	final protected Shell getShell() {
		return this.shell;
	}
	
	final protected Display getDisplay() {
		return this.display;
	}
	
	protected Listener getOnCloseListener() {
		return null;
	}
	
	final protected void initGUI() {
		onInitGUI();
		this.shell.pack();
		
		Listener onCloseListener = getOnCloseListener();
		
		if (onCloseListener != null) {
			this.shell.addListener(SWT.Close, onCloseListener);
		}
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | additionShellFlags());
		onInitShell();
	}
	
	abstract protected void onInitShell();
	abstract protected void onInitGUI();
	
	protected void onOpen() {
		// can be extended
	}
	
	protected int additionShellFlags() {
		// can be extended
		return 0;
	}
}
