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
	private Button systemToUserButton;
	private Button userToSystemButton;
	private Button newButton;
	private Button openButton;
	private Button saveButton;
	private Button exitButton;
	private Label userLabel;
	private Label systemLabel;
	private List systemList;
	private List userList;
	private Collection<String> playerCards;
	private MainMenuGUI mainMenuGui;
	
	public ChooseDeckGUI(Display parent, MainMenuGUI mainMenuGUI){
		this.display = parent;
		this.mainMenuGui = mainMenuGUI;
		initShell();
		initNewButton();
		initOpenButton();
		initSaveButton();
		initExitButton();
		initSystemLabel();
		initSystemList();
		initUserLabel();
		initUserList();
		initSystemToUserButton();
		initUserToSystemButton();
		this.shell.pack();
		initPlayersDeck();
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	private void initPlayersDeck() {
		this.playerCards = new ArrayList<String>();
//		for (Card card: Globals.getGameCardFactory().createDefaultDeck()) {
//			this.playerCards.add(card.getName().toString());
//		}
	}
	
	public Collection<String> getPlayersCards() {
		return this.playerCards;

	}

	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Deck erstellen");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
	}

	private void initNewButton() {
		this.newButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 12);
		formData.top =  new FormAttachment(0, 1000, 12);
		formData.width = 90;
		formData.height = 28;
		this.newButton.setLayoutData(formData);
		this.newButton.setText("Neu");
		this.newButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ChooseDeckGUI.this.systemList.removeAll();
				ChooseDeckGUI.this.userList.removeAll();
				loadSystemDeck();
				sortLists();
			}
		});
	}

	private void initOpenButton() {
		this.openButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 112);
		formData.top =  new FormAttachment(0, 1000, 12);
		formData.width = 90;
		formData.height = 28;
		this.openButton.setLayoutData(formData);
		this.openButton.setText("Öffnen");	
		this.openButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				loadUserDeck();
			}
		});
	}

	private void initSaveButton() {
		this.saveButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 12);
		formData.top =  new FormAttachment(0, 1000, 490);
		formData.width = 90;
		formData.height = 28;
		this.saveButton.setLayoutData(formData);
		this.saveButton.setText("Speichern");
		this.saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveUserDeck();
			}
		});
	}

	private void initExitButton() {
		this.exitButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 660);
		formData.top =  new FormAttachment(0, 1000, 490);
		formData.width = 90;
		formData.height = 28;
		this.exitButton.setLayoutData(formData);
		this.exitButton.setText("Beenden");
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Collections.addAll(ChooseDeckGUI.this.playerCards, ChooseDeckGUI.this.userList.getItems());
				mainMenuGui.setPlayerCards(Arrays.asList(ChooseDeckGUI.this.userList.getItems()));
				ChooseDeckGUI.this.shell.setVisible(false);
			}
		});
	}

	private void initSystemLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 125);
		formData.top =  new FormAttachment(0, 1000, 40);
		this.systemLabel = new Label(this.shell, SWT.CENTER);
		this.systemLabel.setText("Alle Karten:");
		this.systemLabel.setLayoutData(formData);
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
					ShowCardDetailGUI showCardDetailGUI = new ShowCardDetailGUI(ChooseDeckGUI.this.display, null,
							Globals.getGameCardFactory().createCard(selectedItems[0]));
					showCardDetailGUI.open();
				}
			}
		});
	}

	private void initSystemList() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 12);
		formData.top =  new FormAttachment(0, 1000, 60);
		formData.width = 320;
		formData.height = 420;
		this.systemList = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		this.systemList.setLayoutData(formData);
		this.systemList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.CR) {
					moveCardsToOtherList(ChooseDeckGUI.this.systemList, ChooseDeckGUI.this.userList);
					sortLists();
				}
			}
		});
		initCardList(this.systemList);
	}

	private void initUserLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 550);
		formData.top =  new FormAttachment(0, 1000, 40);
		this.userLabel = new Label(this.shell, SWT.CENTER);
		this.userLabel.setText("User Deck:");
		this.userLabel.setLayoutData(formData);
	}

	private void initUserList() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 430);
		formData.top =  new FormAttachment(0, 1000, 60);
		formData.width = 335;
		formData.height = 420;
		this.userList = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		this.userList.setLayoutData(formData);
		this.userList.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.CR) {
					moveCardsToOtherList(ChooseDeckGUI.this.userList, ChooseDeckGUI.this.systemList);
					sortLists();
				}
			}
		});
		initCardList(this.userList);
	}
	
	private void initUserToSystemButton() {
		this.userToSystemButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 358);
		formData.top =  new FormAttachment(0, 1000, 164);
		formData.width = 41;
		formData.height = 28;
		this.userToSystemButton.setLayoutData(formData);
		this.userToSystemButton.setText("<");
		this.userToSystemButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(ChooseDeckGUI.this.userList, ChooseDeckGUI.this.systemList);
				sortLists();
			}
		});
	}

	private void initSystemToUserButton() {
		this.systemToUserButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 358);
		formData.top =  new FormAttachment(0, 1000, 259);
		formData.width = 41;
		formData.height = 28;
		this.systemToUserButton.setLayoutData(formData);
		this.systemToUserButton.setText(">");
		this.systemToUserButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(ChooseDeckGUI.this.systemList, ChooseDeckGUI.this.userList);
				sortLists();
			}
		});
	}
	
	private void loadSystemDeck() {
		Collection<String> cardNames = Globals.getGameCardFactory().getAllPossibleCardNames();
		for(String cardName : cardNames) {
			this.systemList.add(cardName);
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
					this.userList.add(card.getName());
				}
			} catch (Exception e) {
					MessageBox msgBox = new MessageBox(this.shell, SWT.ICON_ERROR);
					if (e.getLocalizedMessage() != null) {
						msgBox.setMessage(e.getLocalizedMessage());
					} else {
						msgBox.setMessage("Die XML Datei ist leer!");
					}
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
				Collections.addAll(cardNames, this.userList.getItems());
				Globals.getGameCardFactory().saveToXml(cardNames, fileWriter);
			} catch (Exception e) {
				MessageBox msgBox = new MessageBox(this.shell, SWT.ICON_ERROR);
				msgBox.setMessage(e.getLocalizedMessage());
				msgBox.open();
			}
		}
	}

	
	public void open() {
		this.shell.open();
	}
	
	private void sortLists() {
		sortList(this.systemList);
		sortList(this.userList);
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
