package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
public class PlayGameGUI {

	/**
	 * Implementation des Spiels
	 */
	
	
	private Shell shell;
	private final Display display;
//	private Button exitButton;
	private Button playerCardOneButton;
	private Button playerCardTwoButton;
	private Button playerCardThreeButton;
	private Button playerCardFourButton;
	private Button playerCardFiveButton;
	private Button playerCardSixButton;
	private Button playerPlayingCardOneButton;
	private Button playerPlayingCardTwoButton;
//	private Label enemyLabel;
//	private Label playerLabel;
	private Label enemyDungeonLevelLabel;
	private Label enemyDungeonRessourcesLabel;
	private Label enemyLabLevelLabel;
	private Label enemyLabRessourcesLabel;
	private Label enemyMineLevelLabel;
	private Label enemyMineRessourcesLabel;
	private Label enemyTowerLevelLabel;
	private Label enemyWallLevelLabel;
	private Label enemyCardOneLabel;
	private Label enemyCardTwoLabel;
	private Label enemyCardThreeLabel;
	private Label enemyCardFourLabel;
	private Label enemyCardFiveLabel;
	private Label enemyCardSixLabel;
	private Label enemyPlayingCardOneLabel;
	private Label enemyPlayingCardTwoLabel;
	private Label enemyCemeteryLabel;
	private Label enemyDeckLabel;
	private Label playerDungeonLevelLabel;
	private Label playerDungeonRessourcesLabel;
	private Label playerLabLevelLabel;
	private Label playerLabRessourcesLabel;
	private Label playerMineLevelLabel;
	private Label playerMineRessourcesLabel;
	private Label playerTowerLevelLabel;
	private Label playerWallLevelLabel;
	private Label playerCemeteryLabel;
	private Label playerDeckLabel;
	
	
	
	public PlayGameGUI(Display parent) {
		this.display = parent;
		initShell();
		initMenuBar();
//		initPlayerLabel();
		initPlayerDeckLabel();
		initPlayerCemeteryLabel();
		initPlayerDungeonLevelLabel();
		initPlayerDungeonRessourcesLabel();
		initPlayerMineLevelLabel();
		initPlayerMineRessourcesLabel();
		initPlayerLabLevelLabel();
		initPlayerLabRessourcesLabel();
		initPlayerTowerLevelLabel();
		initPlayerWallLevelLabel();
		initPlayerCardOneButton();
		initPlayerCardTwoButton();
		initPlayerCardThreeButton();
		initPlayerCardFourButton();
		initPlayerCardFiveButton();
		initPlayerCardSixButton();
		initPlayerPlayingCardOneButton();
		initPlayerPlayingCardTwoButton();
//		initEnemyLabel();
		initEnemyDeckLabel();
		initEnemyCemeteryLabel();
		initEnemyDungeonLevelLabel();
		initEnemyDungeonRessourcesLabel();
		initEnemyMineLevelLabel();
		initEnemyMineRessourcesLabel();
		initEnemyLabLevelLabel();
		initEnemyLabRessourcesLabel();
		initEnemyTowerLevelLabel();
		initEnemyWallLevelLabel();
		initEnemyCardOneLabel();
		initEnemyCardTwoLabel();
		initEnemyCardThreeLabel();
		initEnemyCardFourLabel();
		initEnemyCardFiveLabel();
		initEnemyCardSixLabel();
		initEnemyPlayingCardOneLabel();
		initEnemyPlayingCardTwoLabel();
//		initExitButton();
	}	

	

	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spiel");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
		this.shell.pack();
		this.shell.setSize(1024, 768);
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	private void initMenuBar() {
		Menu menuBar = new Menu(this.shell, SWT.BAR);
		MenuItem fileMenuHead = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHead.setText("Menü");
		
		Menu menuMenu = new Menu(this.shell, SWT.DROP_DOWN);
		fileMenuHead.setMenu(menuMenu);
		MenuItem menuItemExit = new MenuItem(menuMenu, SWT.PUSH);
		menuItemExit.setText("Beenden");
		menuItemExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Exit Game hier einbauen, müsste so richtig sein, oder?
//				shell.close();
				PlayGameGUI.this.shell.setVisible(false);
			}
		});
		
		this.shell.setMenuBar(menuBar);
		
	}
	
//	private void initEnemyLabel() {
//		FormData formData = new FormData();
//		formData.left = new FormAttachment(0, 1000, 5);
//		formData.top =  new FormAttachment(0, 1000, 2);
//		this.enemyLabel = new Label(this.shell, SWT.CENTER);
//		this.enemyLabel.setText("Gegner:");
//		this.enemyLabel.setLayoutData(formData);
//	}
	
//	private void initPlayerLabel() {
//		FormData formData = new FormData();
//		formData.left = new FormAttachment(0, 1000, 5);
//		formData.top =  new FormAttachment(0, 1000, 350);
//		this.playerLabel = new Label(this.shell, SWT.CENTER);
//		this.playerLabel.setText("Spieler:");
//		this.playerLabel.setLayoutData(formData);
//	}
	
	
// Karten des Spielers
	
	
	private void initPlayerPlayingCardOneButton() {
		this.playerPlayingCardOneButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 195);
		formData.top =  new FormAttachment(0, 1000, 370);
		formData.width = 90;
		formData.height = 28;
		this.playerPlayingCardOneButton.setLayoutData(formData);
		this.playerPlayingCardOneButton.setText("Spielkarte 1");
//		this.playerPlayingCardOneButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerPlayingCardTwoButton() {
		this.playerPlayingCardTwoButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 290);
		formData.top =  new FormAttachment(0, 1000, 370);
		formData.width = 90;
		formData.height = 28;
		this.playerPlayingCardTwoButton.setLayoutData(formData);
		this.playerPlayingCardTwoButton.setText("Spielkarte 2");
//		this.playerPlayingCardTwoButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerCardOneButton() {
		this.playerCardOneButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 5);
		formData.top =  new FormAttachment(0, 1000, 400);
		formData.width = 90;
		formData.height = 28;
		this.playerCardOneButton.setLayoutData(formData);
		this.playerCardOneButton.setText("Karte 1");
//		this.playerCardOneButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerCardTwoButton() {
		this.playerCardTwoButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 100);
		formData.top =  new FormAttachment(0, 1000, 400);
		formData.width = 90;
		formData.height = 28;
		this.playerCardTwoButton.setLayoutData(formData);
		this.playerCardTwoButton.setText("Karte 2");
//		this.playerCardTwoButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerCardThreeButton() {
		this.playerCardThreeButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 195);
		formData.top =  new FormAttachment(0, 1000, 400);
		formData.width = 90;
		formData.height = 28;
		this.playerCardThreeButton.setLayoutData(formData);
		this.playerCardThreeButton.setText("Karte 3");
//		this.playerCardThreeButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerCardFourButton() {
		this.playerCardFourButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 290);
		formData.top =  new FormAttachment(0, 1000, 400);
		formData.width = 90;
		formData.height = 28;
		this.playerCardFourButton.setLayoutData(formData);
		this.playerCardFourButton.setText("Karte 4");
//		this.playerCardFourButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerCardFiveButton() {
		this.playerCardFiveButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 385);
		formData.top =  new FormAttachment(0, 1000, 400);
		formData.width = 90;
		formData.height = 28;
		this.playerCardFiveButton.setLayoutData(formData);
		this.playerCardFiveButton.setText("Karte 5");
//		this.playerCardFiveButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initPlayerCardSixButton() {
		this.playerCardSixButton = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 480);
		formData.top =  new FormAttachment(0, 1000, 400);
		formData.width = 90;
		formData.height = 28;
		this.playerCardSixButton.setLayoutData(formData);
		this.playerCardSixButton.setText("Karte 6");
//		this.playerCardSixButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	

//	Karten des Gegners
	
	
	private void initEnemyPlayingCardOneLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 195);
		formData.top =  new FormAttachment(0, 1000, 175);
		formData.width = 90;
		formData.height = 28;
		this.enemyPlayingCardOneLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyPlayingCardOneLabel.setText("1. gespielte Karte");
		this.enemyPlayingCardOneLabel.setLayoutData(formData);
//		this.playerPlayingCardOneButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyPlayingCardTwoLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 290);
		formData.top =  new FormAttachment(0, 1000, 175);
		formData.width = 90;
		formData.height = 28;
		this.enemyPlayingCardTwoLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyPlayingCardTwoLabel.setText("2. gespielte Karte");
		this.enemyPlayingCardTwoLabel.setLayoutData(formData);
//		this.playerPlayingCardTwoButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyCardOneLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 5);
		formData.top =  new FormAttachment(0, 1000, 50);
		formData.width = 90;
		formData.height = 28;
		this.enemyCardOneLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCardOneLabel.setText("1. Gegnerkarte");
		this.enemyCardOneLabel.setLayoutData(formData);
//		this.playerCardOneButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyCardTwoLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 100);
		formData.top =  new FormAttachment(0, 1000, 50);
		formData.width = 90;
		formData.height = 28;
		this.enemyCardTwoLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCardTwoLabel.setText("2. Gegnerkarte");
		this.enemyCardTwoLabel.setLayoutData(formData);
//		this.playerCardTwoButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyCardThreeLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 195);
		formData.top =  new FormAttachment(0, 1000, 50);
		formData.width = 90;
		formData.height = 28;
		this.enemyCardThreeLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCardThreeLabel.setText("3. Gegnerkarte");
		this.enemyCardThreeLabel.setLayoutData(formData);
//		this.playerCardThreeButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyCardFourLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 290);
		formData.top =  new FormAttachment(0, 1000, 50);
		formData.width = 90;
		formData.height = 28;
		this.enemyCardFourLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCardFourLabel.setText("4. Gegnerkarte");
		this.enemyCardFourLabel.setLayoutData(formData);
//		this.playerCardFourButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyCardFiveLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 385);
		formData.top =  new FormAttachment(0, 1000, 50);
		formData.width = 90;
		formData.height = 28;
		this.enemyCardFiveLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCardFiveLabel.setText("5. Gegnerkarte");
		this.enemyCardFiveLabel.setLayoutData(formData);
//		this.playerCardFiveButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	private void initEnemyCardSixLabel() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 480);
		formData.top =  new FormAttachment(0, 1000, 50);
		formData.width = 90;
		formData.height = 28;
		this.enemyCardSixLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCardSixLabel.setText("6. Gegnerkarte");
		this.enemyCardSixLabel.setLayoutData(formData);
//		this.playerCardSixButton.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				ChooseDeckGUI.this.systemList.removeAll();
//				ChooseDeckGUI.this.userList.removeAll();
//				loadSystemDeck();
//				sortLists();
	}
	
	
//	Spieler Ressourcen und Level Label
	
	
	private void initPlayerDeckLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 914);
		formData.top =  new FormAttachment(0, 1000, 538);
		formData.width = 100;
		formData.height = 166;
		this.playerDeckLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.playerDeckLabel.setText("Deck des Spielers");
		this.playerDeckLabel.setLayoutData(formData);
	}
	
	private void initPlayerCemeteryLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 914);
		formData.top =  new FormAttachment(0, 1000, 370);
		formData.width = 100;
		formData.height = 166;
		this.playerCemeteryLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.playerCemeteryLabel.setText("Kartenfriedhof des Spielers");
		this.playerCemeteryLabel.setLayoutData(formData);
	}
	
	
	private void initPlayerDungeonLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 5);
		formData.top =  new FormAttachment(0, 1000, 680);
		formData.width = 222;
		formData.height = 15;
		this.playerDungeonLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerDungeonLevelLabel.setText("Dungeonlevel: ");
		this.playerDungeonLevelLabel.setLayoutData(formData);
	}
	
	private void initPlayerDungeonRessourcesLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 5);
		formData.top =  new FormAttachment(0, 1000, 700);
		formData.width = 222;
		formData.height = 15;
		this.playerDungeonRessourcesLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerDungeonRessourcesLabel.setText("Dungeonressourcen: ");
		this.playerDungeonRessourcesLabel.setLayoutData(formData);
	}
	
	private void initPlayerMineLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 232);
		formData.top =  new FormAttachment(0, 1000, 680);
		formData.width = 222;
		formData.height = 15;
		this.playerMineLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerMineLevelLabel.setText("Steinbruchlevel: ");
		this.playerMineLevelLabel.setLayoutData(formData);
	}
	
	private void initPlayerMineRessourcesLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 232);
		formData.top =  new FormAttachment(0, 1000, 700);
		formData.width = 222;
		formData.height = 15;
		this.playerMineRessourcesLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerMineRessourcesLabel.setText("Steinbruchressourcen: ");
		this.playerMineRessourcesLabel.setLayoutData(formData);
	}
	
	private void initPlayerLabLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 459);
		formData.top =  new FormAttachment(0, 1000, 680);
		formData.width = 222;
		formData.height = 15;
		this.playerLabLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerLabLevelLabel.setText("Zauberlaborlevel: ");
		this.playerLabLevelLabel.setLayoutData(formData);
	}

	private void initPlayerLabRessourcesLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 459);
		formData.top =  new FormAttachment(0, 1000, 700);
		formData.width = 222;
		formData.height = 15;
		this.playerLabRessourcesLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerLabRessourcesLabel.setText("Zauberlaborressourcen: ");
		this.playerLabRessourcesLabel.setLayoutData(formData);
	}
	
	private void initPlayerTowerLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 686);
		formData.top =  new FormAttachment(0, 1000, 680);
		formData.width = 222;
		formData.height = 15;
		this.playerTowerLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerTowerLevelLabel.setText("Turmleben: ");
		this.playerTowerLevelLabel.setLayoutData(formData);		
	}

	private void initPlayerWallLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 686);
		formData.top =  new FormAttachment(0, 1000, 700);
		formData.width = 222;
		formData.height = 15;
		this.playerWallLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.playerWallLevelLabel.setText("Mauerleben: ");
		this.playerWallLevelLabel.setLayoutData(formData);		
	}
	
	
// Gegner Ressourcen und Level Label
	
	
	private void initEnemyDeckLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 914);
		formData.top =  new FormAttachment(0, 1000, 2);
		formData.width = 100;
		formData.height = 166;
		this.enemyDeckLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyDeckLabel.setText("Deck des Gegners");
		this.enemyDeckLabel.setLayoutData(formData);
	}
	
	private void initEnemyCemeteryLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 914);
		formData.top =  new FormAttachment(0, 1000, 170);
		formData.width = 100;
		formData.height = 166;
		this.enemyCemeteryLabel = new Label(this.shell, SWT.CENTER | SWT.BORDER);
		this.enemyCemeteryLabel.setText("Kartenfriedhof des Gegners");
		this.enemyCemeteryLabel.setLayoutData(formData);
	}
	
	private void initEnemyDungeonLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 5);
		formData.top =  new FormAttachment(0, 1000, 2);
		formData.width = 222;
		formData.height = 15;
		this.enemyDungeonLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyDungeonLevelLabel.setText("Dungeonlevel: ");
		this.enemyDungeonLevelLabel.setLayoutData(formData);
	}
	
	private void initEnemyDungeonRessourcesLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 5);
		formData.top =  new FormAttachment(0, 1000, 25);
		formData.width = 222;
		formData.height = 15;
		this.enemyDungeonRessourcesLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyDungeonRessourcesLabel.setText("Dungeonressourcen: ");
		this.enemyDungeonRessourcesLabel.setLayoutData(formData);
	}
	
	private void initEnemyMineLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 232);
		formData.top =  new FormAttachment(0, 1000, 2);
		formData.width = 222;
		formData.height = 15;
		this.enemyMineLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyMineLevelLabel.setText("Steinbruchlevel: ");
		this.enemyMineLevelLabel.setLayoutData(formData);
	}
	
	private void initEnemyMineRessourcesLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 232);
		formData.top =  new FormAttachment(0, 1000, 25);
		formData.width = 222;
		formData.height = 15;
		this.enemyMineRessourcesLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyMineRessourcesLabel.setText("Steinbruchressourcen: ");
		this.enemyMineRessourcesLabel.setLayoutData(formData);
	}
	
	private void initEnemyLabLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 459);
		formData.top =  new FormAttachment(0, 1000, 2);
		formData.width = 222;
		formData.height = 15;
		this.enemyLabLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyLabLevelLabel.setText("Zauberlaborlevel: ");
		this.enemyLabLevelLabel.setLayoutData(formData);
	}

	private void initEnemyLabRessourcesLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 459);
		formData.top =  new FormAttachment(0, 1000, 25);
		formData.width = 222;
		formData.height = 15;
		this.enemyLabRessourcesLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyLabRessourcesLabel.setText("Zauberlaborressourcen: ");
		this.enemyLabRessourcesLabel.setLayoutData(formData);
	}
	
	private void initEnemyTowerLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 686);
		formData.top =  new FormAttachment(0, 1000, 2);
		formData.width = 222;
		formData.height = 15;
		this.enemyTowerLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyTowerLevelLabel.setText("Turmleben: ");
		this.enemyTowerLevelLabel.setLayoutData(formData);		
	}

	private void initEnemyWallLevelLabel() {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 686);
		formData.top =  new FormAttachment(0, 1000, 25);
		formData.width = 222;
		formData.height = 15;
		this.enemyWallLevelLabel = new Label(this.shell, SWT.LEFT | SWT.BORDER);
		this.enemyWallLevelLabel.setText("Mauerleben: ");
		this.enemyWallLevelLabel.setLayoutData(formData);		
	}

	public void open() {
		this.shell.open();
	}
	
//	private void initExitButton() {
//	this.exitButton = new Button(this.shell, SWT.PUSH | SWT.NONE);
//	FormData btnExitData = new FormData();
//	btnExitData.left =  new FormAttachment(0, 2, 2);
//	btnExitData.top =  new FormAttachment(0, 1000, 530);
//	btnExitData.width = 1010;
//	btnExitData.height = 30;
//	this.exitButton.setLayoutData(btnExitData);
//	this.exitButton.setText("Spiel beenden");
//	this.exitButton.addSelectionListener(new SelectionAdapter() {
//		@Override
//		public void widgetSelected(SelectionEvent e) {
//			PlayGameGUI.this.shell.setVisible(false);
//		}
//	});
//}

}
