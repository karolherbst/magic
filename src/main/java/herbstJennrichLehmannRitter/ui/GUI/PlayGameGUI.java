package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class PlayGameGUI {

	/**
	 * Implementation der SpielGUI
	 */
	
	private Shell shell;
	private final Display display;
	private DefenceBuildingFields enemyTower;
	private DefenceBuildingFields enemyWall;
	private DefenceBuildingFields playerWall;
	private DefenceBuildingFields playerTower;
	private RessourceFields playerDungeon;
	private RessourceFields playerMagicLab;
	private RessourceFields playerMine;
	private RessourceFields enemyDungeon;
	private RessourceFields enemyMagicLab;
	private RessourceFields enemyMine;
	private ArrayList<CardFields> playerCards;
	private ArrayList<CardFields> enemyCards;
	private CardFields playerChoosenCard;
	private CardFields enemyChoosenCards;
	
	protected String text;
	private GameMessage gameMessage;
	private MainMenuGUI mainMenuGUI;
	private NameFields playerName;
	private NameFields enemyName;
	private boolean cardDetailIsOpen = false;
	
	public PlayGameGUI(Display parent, MainMenuGUI mainMenuGUI) {
		this.display = parent;
		this.mainMenuGUI = mainMenuGUI;
		initShell();
		this.gameMessage = new GameMessage();
		initMenuBar();
		initPlayerName();
		initPlayerDungeon();
		initPlayerMagicLab();
		initPlayerMine();
		initPlayerWall();
		initPlayerTower();
		initEnemyDungeon();
		initEnemyMagicLab();
		initEnemyMine();
		initEnemyWall();
		initEnemyTower();
		initPlayerCards();
		initEnemyCards();
		initPlayerChoosenCards();
		initEnemyChoosenCards();
		initEnemyName();
		horizontalLine();
		this.shell.pack();
		
		Rectangle shellBounds = this.shell.getBounds();
		this.shell.setSize(1024, (shellBounds.height+5));
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
		
		this.mainMenuGUI.getClientUserInterface().setPlayGameGUI(this);
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Magic");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
	}
	
	public void setCardDetailIsOpen(boolean bool) {
		this.cardDetailIsOpen = bool;
	}
	
	private void initMenuBar() {
		
		Menu menuBar = new Menu(this.shell, SWT.BAR);
		MenuItem fileMenuHead = new MenuItem(menuBar, SWT.CASCADE);
		fileMenuHead.setText("Menü");
		Menu menuMenu = new Menu(this.shell, SWT.DROP_DOWN);
		fileMenuHead.setMenu(menuMenu);
		MenuItem menuItemHowTo = new MenuItem(menuMenu, SWT.PUSH);
		menuItemHowTo.setText("Spielregeln");
		menuItemHowTo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				howToButtonPressed(e);
			}
		});
		MenuItem menuItemExit = new MenuItem(menuMenu, SWT.PUSH);
		menuItemExit.setText("Beenden");
		menuItemExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				exitButtonPressed(e);
			}
		});

		
		this.shell.setMenuBar(menuBar);
	
	}
	
	private void exitButtonPressed (SelectionEvent e) {
			try {
				mainMenuGUI.getGameServer().stop();
				mainMenuGUI.getGameServer().unregister(mainMenuGUI.getClientUserInterface());
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			PlayGameGUI.this.shell.setVisible(false);
	}
	
//	Quelle für Carriage Return: http://www.java2s.com/Code/JavaScript/Window-Browser/Acarriagereturninalertdialogbox.htm
	private void howToButtonPressed (SelectionEvent e){
		MessageBox messageBox = new MessageBox(this.shell, SWT.ICON_INFORMATION);
		messageBox.getStyle();
		String messageString = "Jeder Spieler beginnt mit dem Folgenden: Turm 25 Punkte, Mauer 10 Punkte, " +
				"Steinbruch, Zauberlabor, Verlies jeweils Stufe 1 und 15 Ressourcen. " +
				"Und 6 zufälligen Spielkarten aus seinem Kartenstapel. Es gibt zwei verschiedene Modi: " +
				"Turmbau und Sammelwut. " +
				"Ein Spieler gewinnt, wenn der gegnerische Turm 0 Punkte hat (beide Modi), " +
				"der eigene Turm 100 Punkte hat (Turmbau) oder von einer Sorte Ressourcen 400 Stück " +
				"gesammelt worden sind (Sammelwut). \rDas Spiel läuft in Runden ab. " +
				"Zum Anfang der Runde erhält der Spieler Ressourcen im Wert seiner aktuellen Stufen von Verlies, " +
				"Zauberlabor und Steinbruch. Dann kann der Spieler eine Karte auswählen und spielen oder verwerfen. " +
				"Gespielt werden kann die Karte nur, wenn er genügend Ressourcen besitzt, wenn ja, werden alle Aktionen " +
				"gleichzeitig ausgeführt. Im Anschluss wird die Karte auf den Friedhof gelegt und der Spieler zieht Karten " +
				"vom Deck, bis er wieder 6 Karten auf der Hand hat. Falls das Deck leer ist, wird der Friedhof neu gemischt. " +
				"Der andere Spieler ist am Zug. \rSchaden wird erst von der Mauer, danach vom Turm abgezogen, Mauerschaden nur " +
				"von der Mauer und Turmschaden immer vom Turm. Ressourcengebäude können Stufen gewinnen oder verlieren, dabei ist " +
				"die niedrigste Stufe Stufe 1. Ressourcenbestände können nicht unter 0 fallen.";
		messageBox.setMessage(messageString);
		messageBox.open();
		
	}
	
	private void horizontalLine() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 10);
		formData.top =  new FormAttachment(0, 1000, 362);
		formData.width = 1004;
		Label line = new Label(this.shell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
		line.setLayoutData(formData);
	}
	
	private void initPlayerDungeon() {
		this.playerDungeon = new RessourceFields("Verlies", "Monster", 10, 642);
	}
	public void setPlayerDungeonLevel(int level) {
		this.playerDungeon.setLevel(level);
	}
	public void setPlayerDungeonStock(int stock) {
		this.playerDungeon.setStock(stock);
	}
	public int getPlayerDungeonStock() {
		return this.playerDungeon.getStock();
	}
	
	private void initPlayerMagicLab() {
		this.playerMagicLab = new RessourceFields("Zauberlabor", "Kristall", 220, 642);
	}
	public void setPlayerMagicLabLevel(int level) {
		this.playerMagicLab.setLevel(level);
	}
	public void setPlayerMagicLabStock(int stock) {
		this.playerMagicLab.setStock(stock);
	}
	public int getPlayerMagicLabStock() {
		return this.playerMagicLab.getStock(); 
	}

	private void initPlayerMine() {
		this.playerMine = new RessourceFields("Steinbruch", "Ziegel", 430, 642);
	}
	public void setPlayerMineLevel(int level) {
		this.playerMine.setLevel(level);
	}
	public void setPlayerMineStock(int stock) {
		this.playerMine.setStock(stock);
	}
	public int getPlayerMineStock() {
		return this.playerMine.getStock();
	}
	
	private void initPlayerWall() {
		this.playerWall = new DefenceBuildingFields("Mauer", 640, 642);
	}
	public void setPlayerWall(int level) {
		this.playerWall.setLevel(level);
	}
	
	private void initPlayerTower(){
		this.playerTower = new DefenceBuildingFields("Turm", 830, 642);
	}
	public void setPlayerTower(int level) {
		this.playerTower.setLevel(level);
	}
	
	private void initPlayerCards() {
		int x = 157;
		int y = 515;
		this.playerCards = new ArrayList<CardFields>();
		for (int i=0; i<6; i++) {
			this.playerCards.add(new CardFields((x+(120*i)), y, true, true));
			this.playerCards.get(i).setCardName("");
			this.playerCards.get(i).setVisible(false);
		}
	}
	
	public void setPlayerHandCards(Collection<Card> cards) {
		ArrayList<String> cardFields = new ArrayList<String>();
		for (CardFields cardField: this.playerCards) {
			cardFields.add(cardField.getCardName());
			cardField.setVisible(true);
		}
		
		Iterator<Card> cardIterator = cards.iterator();
		Card card;
		do {
			card = cardIterator.next();
			if (cardFields.contains(card.getName())) {
				continue;
			}
			for (CardFields cardField: this.playerCards) {
				if (cardField.getCardName() == "") {
					cardField.setCardName(card.getName());
					break;
				}
			}
		} while (cardIterator.hasNext());
	}
	
	private void initPlayerChoosenCards() {
		this.playerChoosenCard = new CardFields(457, 388, false, false);
	}
	
	public void setPlayerChoosenCardName(String name) {
		if (name != null) {
			this.playerChoosenCard.setCardName(name);
			this.playerChoosenCard.setVisible(true);
		} else {
			this.playerChoosenCard.setVisible(false);
		}
	}

	public void playerPlayedCard(String name) {
		this.removeCardFromDeck(this.playerCards, name);
		this.playerChoosenCard.setCardName(name);
		this.playerChoosenCard.setVisible(true);
	}
	
	public void playerDiscardCard(String name) {
		this.removeCardFromDeck(this.playerCards, name);
	}	
	
	private void initEnemyDungeon() {
		this.enemyDungeon = new RessourceFields("Verlies", "Monster", 10, 25);
	}
	public void setEnemyDungeonLevel(int level) {
		this.enemyDungeon.setLevel(level);
	}
	public void setEnemyDungeonStock(int stock) {
		this.enemyDungeon.setStock(stock);
	}

	private void initEnemyMagicLab() {
		this.enemyMagicLab = new RessourceFields("Zauberlabor", "Kristall", 220, 25);
	}
	public void setEnemyMagicLabLevel(int level) {
		this.enemyMagicLab.setLevel(level);
	}
	public void setEnemyMagicLabStock(int stock) {
		this.enemyMagicLab.setStock(stock);
	}
	
	private void initEnemyMine() {
		this.enemyMine = new RessourceFields("Steinbruch", "Ziegel", 430, 25);
	}
	public void setEnemyMineLevel(int level) {
		this.enemyMine.setLevel(level);
	}
	public void setEnemyMineStock(int stock) {
		this.enemyMine.setStock(stock);
	}
	
	private void initEnemyWall() {
		this.enemyWall = new DefenceBuildingFields("Mauer", 640, 25);
	}
	public void setEnemyWall(int level) {
		this.enemyWall.setLevel(level);
	}
	
	private void initEnemyTower(){
		this.enemyTower = new DefenceBuildingFields("Turm", 830, 25);
	}
	public void setEnemyTower(int level) {
		this.enemyTower.setLevel(level);
	}
	

	private void initEnemyCards() {
		int x = 157;
		int y = 90;
		this.enemyCards = new ArrayList<CardFields>();
		for (int i=0; i<6; i++) {
			this.enemyCards.add(new CardFields((x+(120*i)), y, true, true));
		}
	}
	
	public void setEnemyHandCards(Collection<Card> cards) {
		ArrayList<String> cardFields = new ArrayList<String>();
		for (CardFields cardField: this.enemyCards) {
			cardFields.add(cardField.getCardName());
			cardField.setVisible(true);
		}
		
		Iterator<Card> cardIterator = cards.iterator();
		Card card;
		do {
			card = cardIterator.next();
			if (cardFields.contains(card.getName())) {
				continue;
			}
			for (CardFields cardField: this.enemyCards) {
				if (cardField.getCardName() == "") {
					cardField.setCardName(card.getName());
					break;
				}
			}
		} while (cardIterator.hasNext());
	}

	private void removeCardFromDeck(ArrayList<CardFields> cardFields, String name) {
		for (CardFields cardField: cardFields) {
			if( cardField.getCardName() == name) {
				cardField.setCardName("");
				cardField.setVisible(false);
				break;
			}
		}
	}
	
	private void initEnemyChoosenCards() {
		this.enemyChoosenCards = new CardFields(457, 227, false, false);
	}
	
	public void setEnemyChoosenCardName(String name) {
		if (name != null) {
			this.enemyChoosenCards.setCardName(name);
			this.enemyChoosenCards.setVisible(true);
		} else {
			this.enemyChoosenCards.setVisible(false);
		}
	}
	
	public void enemyPlayedCard(String name) {
		this.removeCardFromDeck(this.enemyCards, name);
		this.enemyChoosenCards.setCardName(name);
		this.enemyChoosenCards.setVisible(true);
	}
	
	public void enemyDiscardCard(String name) {
		this.removeCardFromDeck(this.enemyCards, name);
	}
	
	
	private void initPlayerName() {
		this.playerName = new NameFields(this.mainMenuGUI.getPlayerName(), 366);
	}
	
	private void initEnemyName() {
		this.enemyName = new NameFields(this.mainMenuGUI.getEnemyName(), 3);
	}
	
	public void nextTurnPlayer() {
		this.playerName.setPlayerActive("ist am Zug");
		this.enemyName.setPlayerInactive();
	}

	public void nextTurnEnemy() {
		this.enemyName.setPlayerActive("ist am Zug");
		this.playerName.setPlayerInactive();
	}
	
	public void playAnotherCardPlayer() {
		this.playAnotherCard(this.playerCards);
	}
	
	public void playAnotherCardEnemy() {
		this.playAnotherCard(this.enemyCards);
	}
	
	private void playAnotherCard(ArrayList<CardFields> cardFields) {
		for (CardFields cardField: cardFields) {
			if (cardField.getCardName() == "") {
				cardField.setVisible(false);
			}
		}
	}

	public void setGameStateToWon() {
		this.gameMessage.setTitleToWon();
	}

	public void setGameStateToLoose() {
		this.gameMessage.setTitleToLoose();
	}
	
	public void setGameStateToAbort(String reason) {
		this.gameMessage.setTitleToAbort(reason);
	}
	
	private class CardFields {
		private Label nameLabel;
		private Composite cardComp;
		
		private CardFields(int positionFromLeft, int positionFromTop, boolean isVisible, boolean isClickable) {
			FormData cardData = new FormData();
			cardData.left = new FormAttachment(0, 800, positionFromLeft);
			cardData.top = new FormAttachment(0, 800, positionFromTop);
			cardData.height = 120;
			cardData.width = 110;

			this.cardComp = new Composite(shell, SWT.BORDER);
			if (isVisible) {
				this.cardComp.setVisible(true);
			} else {
				this.cardComp.setVisible(false);
			}
			this.cardComp.setLayoutData(cardData);
			
			this.nameLabel = new Label(this.cardComp, SWT.CENTER | SWT.WRAP);
			this.nameLabel.setBounds(0, 5, 110, 35);
			if (isClickable) {
				this.cardComp.addMouseListener(new MouseAdapter() {
					@Override
				   public void mouseDown(MouseEvent e) {
						mousePressed(e);
				   }
				});
				this.nameLabel.addMouseListener(new MouseAdapter() {
					@Override
					   public void mouseDown(MouseEvent e) {
							mousePressed(e);
					   }
				});
			}
		}
		
		private void mousePressed(MouseEvent e) {
			if (!getCardName().isEmpty() && cardDetailIsOpen == false) {
				ShowCardDetailGUI showCardDetailGUI = new ShowCardDetailGUI(display, 
						PlayGameGUI.this, null, Globals.getGameCardFactory().createCard(getCardName()));
				showCardDetailGUI.open();
				cardDetailIsOpen = true;
			}
		  }
		
		
		public void setCardName(String cardName) {
			this.nameLabel.setText(cardName);
		}
		
		private String getCardName() {
			return this.nameLabel.getText();
		}
		
		public void setVisible(boolean isVisible) {
			this.cardComp.setVisible(isVisible);
		}
	}
	
	private class DefenceBuildingFields {
		private Label levelValue;
		
		public DefenceBuildingFields(String headline,int positionFromLeft, int positionFromTop){
			FormData canvasData = new FormData();
			canvasData.left =  new FormAttachment(0, 1000, positionFromLeft);
			canvasData.top =  new FormAttachment(0, 1000, positionFromTop);
			canvasData.width = 180;
			canvasData.height = 54;
			
			Composite defenceComp = new Composite(shell, SWT.BORDER);
			defenceComp.setLayoutData(canvasData);
			{
				Label headlineLabel = new Label(defenceComp, SWT.CENTER);
				headlineLabel.setText(headline);
				headlineLabel.setBounds(10, 2, 160, 15);
			}
			{
				Label levelLabel = new Label(defenceComp, SWT.NONE);
				levelLabel.setText("Stufe");
				levelLabel.setBounds(12, 20, 60, 15);
			}
			{	
				this.levelValue = new Label(defenceComp, SWT.NONE);
				this.levelValue.setText(String.valueOf(0));
				this.levelValue.setBounds(80, 20, 60, 15);
			}
		}
			
		public void setLevel(int level) {
			this.levelValue.setText(String.valueOf(level));
		}
	}
	
	private class RessourceFields {
		private Label levelValue;
		private Label stockValue;
		
		public RessourceFields(String headline, String resourceName, int positionFromLeft, int positionFromTop) {
			FormData canvasData = new FormData();
			canvasData.left =  new FormAttachment(0, 1000, positionFromLeft);
			canvasData.top =  new FormAttachment(0, 1000, positionFromTop);
			canvasData.width = 200;
			canvasData.height = 54;
			
			Composite ressourceComp = new Composite(shell, SWT.BORDER);
			ressourceComp.setLayoutData(canvasData);
			{
				Label headlineLabel = new Label(ressourceComp, SWT.CENTER);
				headlineLabel.setText(headline);
				headlineLabel.setBounds(10, 2, 180, 15);
			}
			{
				Label levelLabel = new Label(ressourceComp, SWT.NONE);
				levelLabel.setText("Stufe");
				levelLabel.setBounds(12, 20, 60, 15);
			}
			{	
				this.levelValue = new Label(ressourceComp, SWT.NONE);
				this.levelValue.setText(String.valueOf(0));
				this.levelValue.setBounds(80, 20, 60, 15);
			}
			{
				Label stockLabel = new Label(ressourceComp, SWT.NONE);
				stockLabel.setText(resourceName);
				stockLabel.setSize(60, 30);
				stockLabel.setBounds(12, 38, 60, 15);
			}
			{	
				this.stockValue = new Label(ressourceComp, SWT.NONE);
				this.stockValue.setText("unbekannt");
				this.stockValue.setBounds(80, 38, 80, 15);
			}
		}
		
		public void setLevel(int level) {
			this.levelValue.setText(String.valueOf(level));
		}
		
		public void setStock(int stock) {
			this.stockValue.setText(String.valueOf(stock));
		}
		
		public int getStock() {
			return Integer.valueOf(this.stockValue.getText().toString());
		}
	}
	
	private class NameFields {
		private Label nameLabel;
		private String playerName;
		
		public NameFields(String name, int positionFromTop) {
			this.playerName = name;
			
			FormData nameData = new FormData();
			nameData.left =  new FormAttachment(0, 1000, 10);
			nameData.top =  new FormAttachment(0, 1000, positionFromTop);
			nameData.width = 1004;
			nameData.height = 20;
			
			this.nameLabel = new Label(shell, SWT.CENTER | SWT.BORDER_SOLID);
			this.nameLabel.setText(this.playerName);
			this.nameLabel.setLayoutData(nameData);
			this.nameLabel.pack();
		}
		
		public void setPlayerActive(String text) {
			this.nameLabel.setBackground(new Color(display, 150, 0, 0));
			this.nameLabel.setForeground(new Color(display, 255, 255, 255));
			this.nameLabel.setText(playerName + ' ' + text);
		}
		
		public void setPlayerInactive() {
			this.nameLabel.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
			this.nameLabel.setForeground(Display.getDefault().getSystemColor(SWT.COLOR_WIDGET_FOREGROUND));
			this.nameLabel.setText(playerName);
		}
		
	}

	public void open() {
		this.shell.open();
	}
	
	private class GameMessage {
		private Canvas gameMessageCanv;
		private PaintEvent paintEvent;

		public GameMessage() {
			FormData gameMessageData = new FormData();
			gameMessageData.left = new FormAttachment(0, 1, 260);
			gameMessageData.top = new FormAttachment(0, 1, 150);
			gameMessageData.height = 500;
			gameMessageData.width = 500;
			
			this.gameMessageCanv = new Canvas(shell, SWT.BORDER);
			this.gameMessageCanv.setLayoutData(gameMessageData);
			this.gameMessageCanv.setVisible(false);
			this.gameMessageCanv.setBackground(new Color(display, 255, 255, 255));
		
			this.gameMessageCanv.addPaintListener(new PaintListener()  {
				public void paintControl(PaintEvent e) {
					paintEvent = e;
					
					paintEvent.gc.setFont(new Font(display, "Verdana", 28, SWT.BOLD));
				}
			});
		}
		
		public void setTitleToWon() {
			this.gameMessageCanv.addPaintListener(new PaintListener()  {
				public void paintControl(PaintEvent e) {
					paintEvent = e;
					
					paintEvent.gc.setForeground(new Color(display, 0, 200, 0));
					String text = "Sie haben gewonnen!";
					Point textSize = paintEvent.gc.textExtent(text);
					paintEvent.gc.drawText(text, (gameMessageCanv.getSize().x - textSize.x)/2, 
							(gameMessageCanv.getSize().y - textSize.y)/2);
				}
			});
			this.gameMessageCanv.setVisible(true);
		}
		
		public void setTitleToLoose() {
			this.gameMessageCanv.addPaintListener(new PaintListener()  {
				public void paintControl(PaintEvent e) {
					paintEvent = e;
					
					paintEvent.gc.setForeground(new Color(display, 200, 0, 0));
					String text = "Sie haben verloren!";
					Point textSize = paintEvent.gc.textExtent(text);
					paintEvent.gc.drawText(text, (gameMessageCanv.getSize().x - textSize.x)/2, 
							(gameMessageCanv.getSize().y - textSize.y)/2);
				}
			});
			this.gameMessageCanv.setVisible(true);
		}
		
		public void setTitleToAbort(final String text) {
			this.gameMessageCanv.addPaintListener(new PaintListener()  {
				public void paintControl(PaintEvent e) {
					paintEvent = e;
					
					paintEvent.gc.setForeground(new Color(display, 0, 0, 0));
					Point textSize = paintEvent.gc.textExtent(text);
					paintEvent.gc.drawText(text, (gameMessageCanv.getSize().x - textSize.x)/2, 
							(gameMessageCanv.getSize().y - textSize.y)/2);
				}
			});
			this.gameMessageCanv.setVisible(true);
		}
	}
}
