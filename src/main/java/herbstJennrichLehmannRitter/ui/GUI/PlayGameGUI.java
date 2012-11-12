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
		
		this.mainMenuGUI.getClientUserInterface().setPlayGameGUI(this);
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Magic");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
		this.shell.pack();
		this.shell.setSize(1024, 750);
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
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
		//TODO: Spielregel a la Message Box?
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
	
	private void howToButtonPressed (SelectionEvent e){
		MessageBox messageBox = new MessageBox(this.shell, SWT.ICON_INFORMATION);
		messageBox.getStyle();
		messageBox.setMessage("(.) (.) -> Brüste für die Welt!");
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
		this.playerDungeon = new RessourceFields("Verlies", 10, 642);
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
		this.playerMagicLab = new RessourceFields("Zauberlabor", 220, 642);
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
		this.playerMine = new RessourceFields("Steinbruch", 430, 642);
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
	
	private void initEnemyDungeon() {
		this.enemyDungeon = new RessourceFields("Verlies", 10, 25);
	}
	public void setEnemyDungeonLevel(int level) {
		this.enemyDungeon.setLevel(level);
	}
	public void setEnemyDungeonStock(int stock) {
		this.enemyDungeon.setStock(stock);
	}

	private void initEnemyMagicLab() {
		this.enemyMagicLab = new RessourceFields("Zauberlabor", 220, 25);
	}
	public void setEnemyMagicLabLevel(int level) {
		this.enemyMagicLab.setLevel(level);
	}
	public void setEnemyMagicLabStock(int stock) {
		this.enemyMagicLab.setStock(stock);
	}
	
	private void initEnemyMine() {
		this.enemyMine = new RessourceFields("Steinbruch", 430, 25);
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

	private void initPlayerChoosenCards() {
		this.playerChoosenCard = new CardFields(457, 388, false, false);
	}
	
	public void playerPlayedCard(String name) {
		this.removeCardFromDeck(this.playerCards, name);
		this.playerChoosenCard.setCardName(name);
		this.playerChoosenCard.setVisible(true);
	}
	
	public void playerDiscardCard(String name) {
		this.removeCardFromDeck(this.playerCards, name);
	}
	
	private void removeCardFromDeck(ArrayList<CardFields> cardFields, String name) {
		int i = 0;
		for (CardFields cardField: cardFields) {
			if( cardField.getCardName() == name) {
				System.out.println("Remove Card " + name + " from Position:" + i);
				cardField.setCardName("");
				cardField.setVisible(false);
				break;
			}
			i++;
		}
	}
	
	private void initEnemyChoosenCards() {
		this.enemyChoosenCards = new CardFields(457, 235, false, false);
	}
	
	public void setEnemyChoosenCardName(String name) {
		if (name != null) {
			this.enemyChoosenCards.setCardName(name);
			this.enemyChoosenCards.setVisible(true);
		} else {
			this.enemyChoosenCards.setVisible(false);
		}
	}
	
	private void initPlayerName() {
		this.playerName = new NameFields(this.mainMenuGUI.getPlayerName(), 366);
	}
	
	private void initEnemyName() {
		this.enemyName = new NameFields(this.mainMenuGUI.getEnemyName(), 3);
	}
	
	public void nextTurn() {
		if (this.playerName.getPlayerIsActive()) {
			this.changePlayer(this.playerName, this.enemyName, "ist am Zug");
			this.playerChoosenCard.setVisible(false);
		} else {
			this.changePlayer(this.enemyName, this.playerName, "ist am Zug");
		}
	}
	
	public void playAnotherCard() {
		if (this.playerName.getPlayerIsActive()) {
			this.changePlayer(this.enemyName, this.playerName, "ist am Zug");
		} else {
			this.changePlayer(this.playerName, this.enemyName, "ist am Zug");
		}
	}
	
	private void changePlayer(NameFields playerOne, NameFields playerTwo, String message) {
		playerOne.deactivatePlayer();
		playerTwo.activePlayer(message);
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
			this.nameLabel.setBounds(0, 5, 110, 30);
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
						PlayGameGUI.this, Globals.getGameCardFactory().createCard(getCardName()));
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
		
		public RessourceFields(String headline,int positionFromLeft, int positionFromTop) {
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
				stockLabel.setText("Ressource");
				stockLabel.setSize(60, 30);
				stockLabel.setBounds(12, 38, 60, 15);
			}
			{	
				this.stockValue = new Label(ressourceComp, SWT.NONE);
				this.stockValue.setText(String.valueOf(0));
				this.stockValue.setBounds(80, 38, 60, 15);
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
		private boolean playerIsActive = false;
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
		
		public void activePlayer(final String text) {
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					nameLabel.setBackground(new Color(display, 150, 0, 0));
					nameLabel.setForeground(new Color(display, 255, 255, 255));
					nameLabel.setText(playerName + ' ' + text);
					playerIsActive = true;
				}
			});
		}
		
		public void deactivatePlayer() {
			display.asyncExec(new Runnable() {
				@Override
				public void run() {
					nameLabel.setBackground(shell.getBackground());
					nameLabel.setForeground(new Color(display, 0, 0, 0));
					nameLabel.setText(playerName);
					playerIsActive = false;
				}
			});
		}
		
		public boolean getPlayerIsActive() {
			return this.playerIsActive;
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
