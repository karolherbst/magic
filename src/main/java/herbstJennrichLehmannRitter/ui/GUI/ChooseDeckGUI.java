package herbstJennrichLehmannRitter.ui.GUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.controller.GameEngineController;
import herbstJennrichLehmannRitter.engine.factory.GameCardFactory;
import herbstJennrichLehmannRitter.engine.factory.impl.GameCardFactoryImpl;
import herbstJennrichLehmannRitter.engine.model.Card;

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
	private Button buttonLR;
	private Button buttonRL;
	private Button buttonNew;
	private Button buttonOpen;
	private Button buttonSave;
	private Button buttonExit;
	private List lstSystem;
	private List lstUser;
	
	public ChooseDeckGUI(Display parent){
		this.display = parent;
		initShell();
		initButtonNew();
		initButtonOpen();
		initButtonSave();
		initButtonExit();
		initButtonLR();
		initButtonRL();
		initlstSystem();
		initlstUser();
	}

	private void initButtonOpen() {
		this.buttonOpen = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData buttonOpenData = new FormData();
		buttonOpenData.left =  new FormAttachment(0, 1000, 112);
		buttonOpenData.top =  new FormAttachment(0, 1000, 12);
		buttonOpenData.width = 90;
		buttonOpenData.height = 28;
		this.buttonOpen.setLayoutData(buttonOpenData);
		this.buttonOpen.setText("Öffnen");	
		this.buttonOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO Deck aus Datei öffnen und anzeigen
			}
		});
	}

	private void initButtonExit() {
		this.buttonExit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData buttonExitData = new FormData();
		buttonExitData.left =  new FormAttachment(0, 1000, 660);
		buttonExitData.top =  new FormAttachment(0, 1000, 490);
		buttonExitData.width = 90;
		buttonExitData.height = 28;
		this.buttonExit.setLayoutData(buttonExitData);
		this.buttonExit.setText("Beenden");
		this.buttonExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChooseDeckGUI.this.shell.setVisible(false);
			}
		});
	}

	private void initButtonSave() {
		this.buttonSave = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData buttonSaveData = new FormData();
		buttonSaveData.left =  new FormAttachment(0, 1000, 12);
		buttonSaveData.top =  new FormAttachment(0, 1000, 490);
		buttonSaveData.width = 90;
		buttonSaveData.height = 28;
		this.buttonSave.setLayoutData(buttonSaveData);
		this.buttonSave.setText("Speichern");
		this.buttonSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO Deck speichern
			}
		});
	}

	private void initButtonNew() {
		this.buttonNew = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData buttonNewData = new FormData();
		buttonNewData.left =  new FormAttachment(0, 1000, 12);
		buttonNewData.top =  new FormAttachment(0, 1000, 12);
		buttonNewData.width = 90;
		buttonNewData.height = 28;
		this.buttonNew.setLayoutData(buttonNewData);
		this.buttonNew.setText("Neu");
		this.buttonNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lstSystem.removeAll();
				lstUser.removeAll();
				loadSystemDeck();
			}
		});
	}

	private void initlstUser() {
		FormData lstUserData = new FormData();
		lstUserData.left =  new FormAttachment(0, 1000, 414);
		lstUserData.top =  new FormAttachment(0, 1000, 50);
		lstUserData.width = 335;
		lstUserData.height = 420;
		this.lstUser = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		this.lstUser.setLayoutData(lstUserData);
		
	}

	private void initlstSystem() {
		FormData lstSystemData = new FormData();
		lstSystemData.left =  new FormAttachment(0, 1000, 12);
		lstSystemData.top =  new FormAttachment(0, 1000, 50);
		lstSystemData.width = 335;
		lstSystemData.height = 420;
		this.lstSystem = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		this.lstSystem.setLayoutData(lstSystemData);
	}
	
	private void loadSystemDeck() {
		Collection<Card> cards = Globals.getLocalGameServer().getAllPossibleCards();
		for(Card card : cards) {
			this.lstSystem.add(card.getName().toString());
		}
	}

	private void initButtonRL() {
		this.buttonRL = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData buttonRLData = new FormData();
		buttonRLData.left =  new FormAttachment(0, 1000, 358);
		buttonRLData.top =  new FormAttachment(0, 1000, 164);
		buttonRLData.width = 41;
		buttonRLData.height = 28;
		this.buttonRL.setLayoutData(buttonRLData);
		this.buttonRL.setText("<");
		this.buttonRL.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(lstUser, lstSystem);
				sortLists();
			}
		});
	}

	private void initButtonLR() {
		this.buttonLR = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData buttonLRData = new FormData();
		buttonLRData.left =  new FormAttachment(0, 1000, 358);
		buttonLRData.top =  new FormAttachment(0, 1000, 259);
		buttonLRData.width = 41;
		buttonLRData.height = 28;
		this.buttonLR.setLayoutData(buttonLRData);
		this.buttonLR.setText(">");
		this.buttonLR.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(lstSystem, lstUser);
				sortLists();
			}
		});
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

	private void sortLists() {
		sortList(lstSystem);
		sortList(lstUser);
	}
	
	private void sortList(List list) {
		String[] items = list.getItems();
		Arrays.sort(items);
		list.setItems(items);
	}

	private void moveCardsToOtherList(List sourceList, List targetList) {
		if (!sourceList.getSelection().toString().isEmpty()) {
			String[] selectedCard = sourceList.getSelection();
			for (int i=0;i< selectedCard.length; i++) {
				targetList.add(selectedCard[i]);
				sourceList.remove(selectedCard[i]);
			}
		}
	}

}
