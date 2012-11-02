package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class ChooseDeckGUI {

	/**
	 * @param args
	 */
	private Shell shell;
	private final Display display;
	private Button btnSystemToUser;
	private Button btnUserToSystem;
	private Button btnNew;
	private Button btnOpen;
	private Button btnSave;
	private Button btnExit;
	private Label labelUser;
	private Label labelSystem;
	private List lstSystem;
	private List lstUser;
	
	public ChooseDeckGUI(Display parent){
		this.display = parent;
		initShell();
		initButtonNew();
		initButtonOpen();
		initButtonSave();
		initButtonExit();
		initSystemLabel();
		initlstSystem();
		initUserLabel();
		initlstUser();
		initButtonSystemToUser();
		initButtonUserToSystem();
	}
	

	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Deck erstellen");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
		this.shell.pack();			
		this.shell.setSize(761, 547);
	}

	private void initButtonNew() {
		this.btnNew = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnNewData = new FormData();
		btnNewData.left =  new FormAttachment(0, 1000, 12);
		btnNewData.top =  new FormAttachment(0, 1000, 12);
		btnNewData.width = 90;
		btnNewData.height = 28;
		this.btnNew.setLayoutData(btnNewData);
		this.btnNew.setText("Neu");
		this.btnNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChooseDeckGUI.this.lstSystem.removeAll();
				ChooseDeckGUI.this.lstUser.removeAll();
				loadSystemDeck();
				sortLists();
			}
		});
	}

	private void initButtonOpen() {
		this.btnOpen = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnOpenData = new FormData();
		btnOpenData.left =  new FormAttachment(0, 1000, 112);
		btnOpenData.top =  new FormAttachment(0, 1000, 12);
		btnOpenData.width = 90;
		btnOpenData.height = 28;
		this.btnOpen.setLayoutData(btnOpenData);
		this.btnOpen.setText("Öffnen");	
		this.btnOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				loadUserDeck();
			}
		});
	}

	private void initButtonSave() {
		this.btnSave = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnSaveData = new FormData();
		btnSaveData.left =  new FormAttachment(0, 1000, 12);
		btnSaveData.top =  new FormAttachment(0, 1000, 490);
		btnSaveData.width = 90;
		btnSaveData.height = 28;
		this.btnSave.setLayoutData(btnSaveData);
		this.btnSave.setText("Speichern");
		this.btnSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveUserDeck();
			}
		});
	}

	private void initButtonExit() {
		this.btnExit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnExitData = new FormData();
		btnExitData.left =  new FormAttachment(0, 1000, 660);
		btnExitData.top =  new FormAttachment(0, 1000, 490);
		btnExitData.width = 90;
		btnExitData.height = 28;
		this.btnExit.setLayoutData(btnExitData);
		this.btnExit.setText("Beenden");
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ArrayList<String> cardNames = new ArrayList<String>();
				Collections.addAll(cardNames, lstUser.getItems());
				if (cardNames.isEmpty()) {
					Globals.getGameCardFactory().createDefaultDeck();
				} else {
					Globals.getGameCardFactory().createCardsFromNames(cardNames);
				}
				ChooseDeckGUI.this.shell.setVisible(false);
			}
		});
	}

	private void initSystemLabel() {
		FormData systemLabelData = new FormData();
		systemLabelData.left = new FormAttachment(0, 1000, 125);
		systemLabelData.top =  new FormAttachment(0, 1000, 40);
		this.labelSystem = new Label(this.shell, SWT.CENTER);
		this.labelSystem.setText("Alle Karten:");
		this.labelSystem.setLayoutData(systemLabelData);
	}
	
	private void initCardList(final List list) {
		list.addSelectionListener(new SelectionListener() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				// nothing to do here
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selectedItems = list.getSelection();
				if (selectedItems.length == 1) {
					ShowCardDetailGUI showCardDetailGUI = new ShowCardDetailGUI(ChooseDeckGUI.this.display, false,
							Globals.getGameCardFactory().createCard(selectedItems[0]));
					showCardDetailGUI.open();
				}
			}
		});
	}

	private void initlstSystem() {
		FormData lstSystemData = new FormData();
		lstSystemData.left =  new FormAttachment(0, 1000, 12);
		lstSystemData.top =  new FormAttachment(0, 1000, 60);
		lstSystemData.width = 320;
		lstSystemData.height = 420;
		this.lstSystem = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		this.lstSystem.setLayoutData(lstSystemData);
		this.lstSystem.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.CR) {
					moveCardsToOtherList(ChooseDeckGUI.this.lstSystem, ChooseDeckGUI.this.lstUser);
					sortLists();
				}
			}
		});
		initCardList(this.lstSystem);
	}

	private void initUserLabel() {
		FormData userLabelData = new FormData();
		userLabelData.left = new FormAttachment(0, 1000, 550);
		userLabelData.top =  new FormAttachment(0, 1000, 40);
		this.labelUser = new Label(this.shell, SWT.CENTER);
		this.labelUser.setText("User Deck:");
		this.labelUser.setLayoutData(userLabelData);
	}

	private void initlstUser() {
		FormData lstUserData = new FormData();
		lstUserData.left =  new FormAttachment(0, 1000, 430);
		lstUserData.top =  new FormAttachment(0, 1000, 60);
		lstUserData.width = 335;
		lstUserData.height = 420;
		this.lstUser = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		this.lstUser.setLayoutData(lstUserData);
		this.lstUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.CR) {
					moveCardsToOtherList(ChooseDeckGUI.this.lstUser, ChooseDeckGUI.this.lstSystem);
					sortLists();
				}
			}
		});
		initCardList(this.lstUser);
	}
	
	private void initButtonUserToSystem() {
		this.btnUserToSystem = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnRLData = new FormData();
		btnRLData.left =  new FormAttachment(0, 1000, 358);
		btnRLData.top =  new FormAttachment(0, 1000, 164);
		btnRLData.width = 41;
		btnRLData.height = 28;
		this.btnUserToSystem.setLayoutData(btnRLData);
		this.btnUserToSystem.setText("<");
		this.btnUserToSystem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(ChooseDeckGUI.this.lstUser, ChooseDeckGUI.this.lstSystem);
				sortLists();
			}
		});
	}

	private void initButtonSystemToUser() {
		this.btnSystemToUser = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnLRData = new FormData();
		btnLRData.left =  new FormAttachment(0, 1000, 358);
		btnLRData.top =  new FormAttachment(0, 1000, 259);
		btnLRData.width = 41;
		btnLRData.height = 28;
		this.btnSystemToUser.setLayoutData(btnLRData);
		this.btnSystemToUser.setText(">");
		this.btnSystemToUser.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(ChooseDeckGUI.this.lstSystem, ChooseDeckGUI.this.lstUser);
				sortLists();
			}
		});
	}
	
	private void loadSystemDeck() {
		Collection<String> cardNames = Globals.getGameCardFactory().getAllPossibleCardNames();
		for(String cardName : cardNames) {
			this.lstSystem.add(cardName);
		}
	}
	
	private void loadUserDeck() {
		FileDialog fileDialog = new FileDialog(this.shell, SWT.OPEN);
		String[] fileExtNames = { "XML-Dateien" };
		String[] fileExt = { "*.xml" };
		fileDialog.setFilterNames(fileExtNames);
		fileDialog.setFilterExtensions(fileExt);
		String fileName = fileDialog.open();
		if (fileName != null) {
			try {
				InputStreamReader source = new InputStreamReader(new FileInputStream(fileName));
				Collection<Card> cards = Globals.getGameCardFactory().loadFromXml(source);
				for(Card card : cards) {
					this.lstUser.add(card.getName());
				}
			} catch (Exception e) {
				MessageBox msgBox = new MessageBox(shell, SWT.ICON_ERROR);
				msgBox.setMessage(e.getLocalizedMessage());
				msgBox.open();
			}
		}
	}
	
	private void saveUserDeck() {
		FileDialog fileDialog = new FileDialog(this.shell, SWT.SAVE);
		String[] fileExtNames = { "XML-Dateien" };
		String[] fileExt = { "*.xml" };
		fileDialog.setFilterNames(fileExtNames);
		fileDialog.setFilterExtensions(fileExt);
		String fileName = fileDialog.open();
		if (fileName != null) {
			try {
				FileWriter fileWriter = new FileWriter(new File(fileName));
				ArrayList<String> cardNames = new ArrayList<String>();
				Collections.addAll(cardNames, lstUser.getItems());
				Globals.getGameCardFactory().saveToXml(cardNames, fileWriter);
			} catch (Exception e) {
				MessageBox msgBox = new MessageBox(shell, SWT.ICON_ERROR);
				msgBox.setMessage(e.getLocalizedMessage());
				msgBox.open();
			}
		}
	}

	
	public void open() {
		this.shell.open();
	}
	
	private void sortLists() {
		sortList(this.lstSystem);
		sortList(this.lstUser);
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
