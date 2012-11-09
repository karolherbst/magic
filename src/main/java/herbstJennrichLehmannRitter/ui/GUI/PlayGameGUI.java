package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.server.GameServer;

import java.util.ArrayList;
import java.util.Collection;

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
	
	private GameServer gameServer;
	protected String text;
	private GameMessage gameMessage;
	private MainMenuGUI mainMenuGUI;
	
	public PlayGameGUI(Display parent, MainMenuGUI mainMenuGUI, GameServer gameServer) {
		this.display = parent;
		this.gameServer = gameServer;
		this.mainMenuGUI = mainMenuGUI;
		initShell();
		this.gameMessage = new GameMessage();
		initMenuBar();
		initPlayerName();
		initPlayerDungeon();
		initPlayerMagicLab();
		initPlayerMine();
		initEnemyDungeon();
		initPlayerWall();
		initPlayerTower();
		initEnemyName();
		initEnemyMagicLab();
		initEnemyMine();
		initEnemyWall();
		initEnemyTower();
		initPlayerCards();
		initEnemyCards();
		initPlayerChoosenCards();
		initEnemyChoosenCards();
		horizontalLine();
	}
	
	//TODO: Sichtbarmachen, wer gerade dran ist

	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Magic");
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
				PlayGameGUI.this.shell.setVisible(false);
			}
		});
		this.shell.setMenuBar(menuBar);
		
	}
	
	private void horizontalLine() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 10);
		formData.top =  new FormAttachment(0, 1000, 370);
		formData.width = 1004;
		Label line = new Label(this.shell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
		line.setLayoutData(formData);
	}
	
	private void initPlayerDungeon() {
		this.playerDungeon = new RessourceFields("Verlies", 10, 676, 42, 41);
	}
	
	public void setPlayerDungeonLevel(int level) {
		this.playerDungeon.setLevel(level);
	}
	
	public void setPlayerDungeonStock(int stock) {
		this.playerDungeon.setStock(stock);
	}
	
	private void initPlayerMagicLab() {
		this.playerMagicLab = new RessourceFields("Zauberlabor", 220, 676, 40, 39);
	}
	
	public void setPlayerMagicLabLevel(int level) {
		this.playerMagicLab.setLevel(level);
	}
	
	public void setPlayerMagicLabStock(int stock) {
		this.playerMagicLab.setStock(stock);
	}

	private void initPlayerMine() {
		this.playerMine = new RessourceFields("Steinbruch", 430, 676, 17, 66);
	}

	public void setPlayerMineLevel(int level) {
		this.playerMine.setLevel(level);
	}
	
	public void setPlayerMineStock(int stock) {
		this.playerMine.setStock(stock);
	}
	
	private void initPlayerWall() {
		this.playerWall = new DefenceBuildingFields("Mauer", 640, 676, 25);
	}
	
	public void setPlayerWall(int level) {
		this.playerWall.setLevel(level);
	}
	
	private void initPlayerTower(){
		this.playerTower = new DefenceBuildingFields("Turm", 830, 676, 50);
	}

	public void setPlayerTower(int level) {
		this.playerTower.setLevel(level);
	}
	
	private void initEnemyDungeon() {
		this.enemyDungeon = new RessourceFields("Verlies", 10, 20, 42, 41);
	}
	
	public void setEnemyDungeonLevel(int level) {
		this.enemyDungeon.setLevel(level);
	}
	
	public void setEnemyDungeonStock(int stock) {
		this.enemyDungeon.setStock(stock);
	}

	private void initEnemyMagicLab() {
		this.enemyMagicLab = new RessourceFields("Zauberlabor", 220, 20, 40, 39);
	}
	
	public void setEnemyMagicLabLevel(int level) {
		this.enemyMagicLab.setLevel(level);
	}
	
	public void setEnemyMagicLabStock(int stock) {
		this.enemyMagicLab.setStock(stock);
	}
	
	private void initEnemyMine() {
		this.enemyMine = new RessourceFields("Steinbruch", 430, 20, 17, 66);
	}
	
	public void setEnemyMineLevel(int level) {
		this.enemyMine.setLevel(level);
	}
	
	public void setEnemyMineStock(int stock) {
		this.enemyMine.setStock(stock);
	}
	
	private void initEnemyWall() {
		this.enemyWall = new DefenceBuildingFields("Mauer", 640, 20, 25);
	}
	
	public void setEnemyWall(int level) {
		this.enemyWall.setLevel(level);
	}
	
	private void initEnemyTower(){
		this.enemyTower = new DefenceBuildingFields("Turm", 830, 20, 50);
	}
	
	public void setEnemyTower(int level) {
		this.enemyTower.setLevel(level);
	}
	
	private void initPlayerCards() {
		int x = 157;
		int y = 540;
		this.playerCards = new ArrayList<CardFields>();
		for (int i=0; i<6; i++) {
			this.playerCards.add(new CardFields((x+(120*i)), y, true, true));
		}
	}
	
	public void setPlayerCardName(int index, String name) {
		this.playerCards.get(index).setCardName(name);
	}
	
	private void initEnemyCards() {
		int x = 157;
		int y = 86;
		this.enemyCards = new ArrayList<CardFields>();
		for (int i=0; i<6; i++) {
			this.enemyCards.add(new CardFields((x+(120*i)), y, true, true));
		}
	}

	private void initPlayerChoosenCards() {
		this.playerChoosenCard = new CardFields(457, 390, false, false);
	}
	
	public void setPlayerChoosenCardName(String name) {
		if (name != null) {
			this.playerChoosenCard.setCardName(name);
			this.playerChoosenCard.setVisible(true);
		} else {
			this.playerChoosenCard.setVisible(false);
		}

	}
	
	public Collection<String> getPlayerCards() {
		Collection<String> cards = new ArrayList<String>();
		for (CardFields cardfield : this.playerCards) {
			cards.add(cardfield.getCardName());
		}
		return cards;
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
		new NameFields(this.mainMenuGUI.getPlayerName(), 372);
	}
	
	private void initEnemyName() {
		new NameFields(this.mainMenuGUI.getEnemyName(), 3);
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
			cardData.height = 130;
			cardData.width = 110;

			this.cardComp = new Composite(shell, SWT.BORDER);
			if (isVisible) {
				this.cardComp.setVisible(true);
			} else {
				this.cardComp.setVisible(false);
			}
			this.cardComp.setLayoutData(cardData);
			
			this.nameLabel = new Label(this.cardComp, SWT.CENTER);
			this.nameLabel.setBounds(0, 20, 110, 15);
			
			if (isClickable) {
				this.cardComp.addMouseListener(new MouseAdapter() {
						@Override
					   public void mouseDown(MouseEvent e) {
							if (!getCardName().isEmpty()) {
								ShowCardDetailGUI showCardDetailGUI = new ShowCardDetailGUI(display, true, 
										Globals.getGameCardFactory().createCard(getCardName()));
								showCardDetailGUI.open();
							}
					   }
				});
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
		
		public DefenceBuildingFields(String headline,int positionFromLeft, int positionFromTop, int level){
			FormData canvasData = new FormData();
			canvasData.left =  new FormAttachment(0, 1000, positionFromLeft);
			canvasData.top =  new FormAttachment(0, 1000, positionFromTop);
			canvasData.width = 180;
			canvasData.height = 60;
			
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
				this.levelValue.setText(String.valueOf(level));
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
		
		public RessourceFields(String headline,int positionFromLeft, int positionFromTop, int level, int stock) {
			FormData canvasData = new FormData();
			canvasData.left =  new FormAttachment(0, 1000, positionFromLeft);
			canvasData.top =  new FormAttachment(0, 1000, positionFromTop);
			canvasData.width = 200;
			canvasData.height = 60;
			
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
				this.levelValue.setText(String.valueOf(level));
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
				this.stockValue.setText(String.valueOf(stock));
				this.stockValue.setBounds(80, 38, 60, 15);
			}
		}
		
		public void setLevel(int level) {
			this.levelValue.setText(String.valueOf(level));
		}
		
		public void setStock(int stock) {
			this.stockValue.setText(String.valueOf(stock));
		}
	}
	
	private class NameFields {
		public NameFields(String name, int positionFromTop) {
			FormData nameData = new FormData();
			nameData.left =  new FormAttachment(0, 1000, 10);
			nameData.top =  new FormAttachment(0, 1000, positionFromTop);
			nameData.width = 1004;
			nameData.height = 20;
			
			Label nameLabel = new Label(shell, SWT.CENTER);
			nameLabel.setText(name);
			nameLabel.setLayoutData(nameData);
			nameLabel.pack();
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
