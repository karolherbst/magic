package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class ChooseDeckGUI {

	/**
	 * @param args
	 */
	private Shell shell;
	private final Display display;
	private Button button_LR;
	private Button button_RL;
	private Button button_new;
	private Button button_open;
	private Button button_save;
	private Button button_reset;
	private Button button_exit;
	private List lstUser;
	private List lstSystem;

	
	
	public ChooseDeckGUI(Display parent){
		this.display = parent;
		initShell();
		initButtonNew();
		initButtonOpen();
		initButtonSave();
		initButtonReset();
		initButtonExit();
		initButtonLR();
		initButtonRL();
		initlstSystem();
		initlstUser();
		
	}

	private void initButtonOpen() {
		this.button_open = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_openData = new FormData();
		button_openData.left =  new FormAttachment(0, 1000, 112);
		button_openData.top =  new FormAttachment(0, 1000, 12);
		button_openData.width = 90;
		button_openData.height = 28;
		this.button_open.setLayoutData(button_openData);
		this.button_open.setText("Öffnen");	
	}

	private void initButtonExit() {
		this.button_exit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_exitData = new FormData();
		button_exitData.left =  new FormAttachment(0, 1000, 660);
		button_exitData.top =  new FormAttachment(0, 1000, 490);
		button_exitData.width = 90;
		button_exitData.height = 28;
		this.button_exit.setLayoutData(button_exitData);
		this.button_exit.setText("Beenden");
		this.button_exit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChooseDeckGUI.this.shell.setVisible(false);
			}
			});
		
	}

	private void initButtonReset() {
		this.button_reset = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_resetData = new FormData();
		button_resetData.left =  new FormAttachment(0, 1000, 340);
		button_resetData.top =  new FormAttachment(0, 1000, 490);
		button_resetData.width = 90;
		button_resetData.height = 28;
		this.button_reset.setLayoutData(button_resetData);
		this.button_reset.setText("Reset");
	}

	private void initButtonSave() {
		this.button_save = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_SaveData = new FormData();
		button_SaveData.left =  new FormAttachment(0, 1000, 12);
		button_SaveData.top =  new FormAttachment(0, 1000, 490);
		button_SaveData.width = 90;
		button_SaveData.height = 28;
		this.button_save.setLayoutData(button_SaveData);
		this.button_save.setText("Speichern");
		
	}

	private void initButtonNew() {
		this.button_new = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_newData = new FormData();
		button_newData.left =  new FormAttachment(0, 1000, 12);
		button_newData.top =  new FormAttachment(0, 1000, 12);
		button_newData.width = 90;
		button_newData.height = 28;
		this.button_new.setLayoutData(button_newData);
		this.button_new.setText("Neu");
		
	}

	private void initlstUser() {
		FormData lstUserData = new FormData();
		lstUserData.left =  new FormAttachment(0, 1000, 414);
		lstUserData.top =  new FormAttachment(0, 1000, 50);
		lstUserData.width = 335;
		lstUserData.height = 420;
		this.lstUser = new List(this.shell, SWT.NONE);
		this.lstUser.setLayoutData(lstUserData);
		
	}

	private void initlstSystem() {
		FormData lstSystemData = new FormData();
		lstSystemData.left =  new FormAttachment(0, 1000, 12);
		lstSystemData.top =  new FormAttachment(0, 1000, 50);
		lstSystemData.width = 335;
		lstSystemData.height = 420;
		this.lstSystem = new List(this.shell, SWT.NONE);
		this.lstSystem.setLayoutData(lstSystemData);

		
	}

	private void initButtonRL() {
		this.button_RL = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_RLData = new FormData();
		button_RLData.left =  new FormAttachment(0, 1000, 358);
		button_RLData.top =  new FormAttachment(0, 1000, 164);
		button_RLData.width = 41;
		button_RLData.height = 28;
		this.button_RL.setLayoutData(button_RLData);
		this.button_RL.setText("<");
		
	}

	private void initButtonLR() {
		this.button_LR = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData button_LRData = new FormData();
		button_LRData.left =  new FormAttachment(0, 1000, 358);
		button_LRData.top =  new FormAttachment(0, 1000, 259);
		button_LRData.width = 41;
		button_LRData.height = 28;
		this.button_LR.setLayoutData(button_LRData);
		this.button_LR.setText(">");
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Deck erstellen");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
		this.shell.pack();			
		this.shell.setSize(761, 547);
	}
}
