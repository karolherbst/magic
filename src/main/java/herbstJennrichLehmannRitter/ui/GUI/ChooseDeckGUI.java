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

/**	Description of ChooseDeckGUI Class
 * GUI for choosing and creating a new deck
 */

public class ChooseDeckGUI {
 
	private Shell shell;
	private final Display display;
	private Button systemToUserButton;
	private Button userToSystemButton;
	private Button newButton;
	private Button openButton;
	private Button saveButton;
	private Button exitButton;
	private List systemList;
	private List userList;
	private Collection<String> playerCards;
	private MainMenuGUI mainMenuGui;
	private boolean cardDetailIsOpen = false;
	
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
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Deck erstellen");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
	}
	
	private void initPlayersDeck() {
		this.playerCards = new ArrayList<String>();
	}
	
	public Collection<String> getPlayersCards() {
		return this.playerCards;
	}
	
	public void setCardDetailIsOpen(boolean bool) {
		this.cardDetailIsOpen  = bool;
	}


	private void initNewButton() {
		this.newButton = createButton("Neu", 12, 12, 90, 28);
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
		this.openButton = createButton("Öffnen", 112, 12, 90, 28);
		this.openButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				loadUserDeck();
			}
		});
	}

	private void initSaveButton() {
		this.saveButton = createButton("Speichern", 12, 490, 90, 28);
		this.saveButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				saveUserDeck();
			}
		});
	}

	private void initExitButton() {
		this.exitButton = createButton("Beenden", 660, 490, 90, 28);
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Collections.addAll(ChooseDeckGUI.this.playerCards, ChooseDeckGUI.this.userList.getItems());
				if (ChooseDeckGUI.this.userList.getItemCount() < 50) {
					ChooseDeckGUI.this.mainMenuGui.setPlayerCards(
							Globals.getGameCardFactory().getAllPossibleCardNames());
				} else {
					ChooseDeckGUI.this.mainMenuGui.setPlayerCards(
							Arrays.asList(ChooseDeckGUI.this.userList.getItems()));
				}
				ChooseDeckGUI.this.shell.setVisible(false);
			}
		});
	}
	
	private void initSystemLabel() {
		createLabel("Alle Karten: ", 125, 40);
	}
	
	private void initSystemList() {
		this.systemList = createList(12, 60);
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
	
	private void initCardList(final List list) {
		list.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				String[] selectedItems = list.getSelection();
				if (selectedItems.length == 1 && ChooseDeckGUI.this.cardDetailIsOpen == false) {
					ShowCardDetailGUI showCardDetailGUI = new ShowCardDetailGUI(ChooseDeckGUI.this.display, 
							null, ChooseDeckGUI.this, 
							Globals.getGameCardFactory().createCard(selectedItems[0]));
					showCardDetailGUI.open();
					ChooseDeckGUI.this.cardDetailIsOpen = true;
				}
			}
		});
	}

	private void initUserLabel() {
		createLabel("User Deck: ", 550, 40);
	}

	private void initUserList() {
		this.userList = createList(430, 60);
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
		this.userToSystemButton = createButton("<", 358, 164, 41, 28);
		this.userToSystemButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				moveCardsToOtherList(ChooseDeckGUI.this.userList, ChooseDeckGUI.this.systemList);
				sortLists();
			}
		});
	}

	private void initSystemToUserButton() {
		this.systemToUserButton = createButton(">", 358, 259, 41, 28);
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
				this.userList.removeAll();
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
	
	private Button createButton(String text, int x, int y, int width, int height) {
		Button button = new Button(ChooseDeckGUI.this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, x);
		formData.top =  new FormAttachment(0, 1000, y);
		formData.width = width;
		formData.height = height;
		button.setLayoutData(formData);
		button.setText(text);
		
		return button;
	}

	private void createLabel(String text, int x, int y) {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, x);
		formData.top =  new FormAttachment(0, 1000, y);
		
		Label label = new Label(this.shell, SWT.CENTER);
		label.setText(text);
		label.setLayoutData(formData);
	}
	
	private List createList(int x, int y) {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, x);
		formData.top =  new FormAttachment(0, 1000, y);
		formData.width = 320;
		formData.height = 420;
		List list = new List(this.shell, SWT.NONE | SWT.MULTI | SWT.V_SCROLL);
		list.setLayoutData(formData);
		
		return list; 
	}

	private void sortLists() {
		sortList(this.systemList);
		sortList(this.userList);
	}
	
	private static void sortList(List list) {
		String[] items = list.getItems();
		Arrays.sort(items);
		list.setItems(items);
	}

	private static void moveCardsToOtherList(List sourceList, List targetList) {
		if (!sourceList.getSelection().toString().isEmpty()) {
			String[] selectedCard = sourceList.getSelection();
			for (int i=0;i< selectedCard.length; i++) {
				targetList.add(selectedCard[i]);
				sourceList.remove(selectedCard[i]);
			}
		}
	}
}
