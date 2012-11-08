package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
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
	
	public PlayGameGUI(Display parent) {
		this.display = parent;
		initShell();
		initMenuBar();
		initPlayerDungeon();
		initPlayerMagicLab();
		initPlayerMine();
		initEnemyDungeon();
		initPlayerWall();
		initPlayerTower();
		initEnemyMagicLab();
		initEnemyMine();
		initEnemyWall();
		initEnemyTower();
		horizontalLine();
		playerCardOne();
		playerCardTwo();
		
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
				PlayGameGUI.this.shell.setVisible(false);
			}
		});
		
		this.shell.setMenuBar(menuBar);
		
	}
	
	private void horizontalLine() {
		FormData formData = new FormData();
		formData.left =  new FormAttachment(0, 1000, 10);
		formData.top =  new FormAttachment(0, 1000, 374);
		formData.width = 1004;
		formData.height = 20;
		Label line = new Label(this.shell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
		line.setLayoutData(formData);
	}
	
	private void initPlayerDungeon() {
		this.createRessourceFields("Verlies", 10, 676, 42, 41);
	}
	
	private void initPlayerMagicLab() {
		this.createRessourceFields("Zauberlabor", 220, 676, 40, 39);
	}
	
	private void initPlayerMine() {
		this.createRessourceFields("Steinbruch", 430, 676, 17, 66);
	}
	
	private void initPlayerWall() {
		this.createDefenceFields("Mauer", 640, 676, 25);
	}
	
	private void initPlayerTower(){
		this.createDefenceFields("Turm", 830, 676, 50);
	}
	
	private void initEnemyDungeon() {
		this.createRessourceFields("Verlies", 10, 10, 42, 41);
	}
	
	private void initEnemyMagicLab() {
		this.createRessourceFields("Zauberlabor", 220, 10, 40, 39);
	}
	
	private void initEnemyMine() {
		this.createRessourceFields("Steinbruch", 430, 10, 17, 66);
	}
	
	private void initEnemyWall() {
		this.createDefenceFields("Mauer", 640, 10, 25);
		
	}
	
	private void initEnemyTower(){
		this.createDefenceFields("Turm", 830, 10, 50);
	}
	
	private void playerCardOne() {
		this.createCard("Der gemeine Karol spielt Java", 10, 540);
	}
	
	private void playerCardTwo() {
		this.createCard("Karte 2", 120, 540);
	}
	
	private void createCard(String cardName, int positionFromLeft, int positionFromTop) {
		FormData cardData = new FormData();
		cardData.left = new FormAttachment(0, 800, positionFromLeft);
		cardData.top = new FormAttachment(0, 800, positionFromTop);
		cardData.height = 130;
		cardData.width = 100;
		
		Canvas cardCanvas = new Canvas(this.shell, SWT.BORDER);
		cardCanvas.setLayoutData(cardData);
		
		Label nameLabel = new Label(cardCanvas, SWT.CENTER);
		nameLabel.setText(cardName);
		nameLabel.setBounds(0, 20, 130, 15);
	}
	
	private void createDefenceFields(String headline,int positionFromLeft, int positionFromTop, int level){
		FormData canvasData = new FormData();
		canvasData.left =  new FormAttachment(0, 1000, positionFromLeft);
		canvasData.top =  new FormAttachment(0, 1000, positionFromTop);
		canvasData.width = 180;
		canvasData.height = 60;
		
		Canvas playerCanvas = new Canvas(this.shell, SWT.BORDER);
		playerCanvas.setLayoutData(canvasData);
		{
			Label headlineLabel = new Label(playerCanvas, SWT.CENTER);
			headlineLabel.setText(headline);
			headlineLabel.setBounds(10, 2, 160, 15);
		}
		{
			Label levelLabel = new Label(playerCanvas, SWT.NONE);
			levelLabel.setText("Stufe");
			levelLabel.setBounds(12, 20, 60, 15);
		}
		{	
			Label levelValue = new Label(playerCanvas, SWT.NONE);
			levelValue.setText(String.valueOf(level));
			levelValue.setBounds(80, 20, 60, 15);
		}
		
	}
	
	private void createRessourceFields(String headline,int positionFromLeft, int positionFromTop, int level, int stock) {
		FormData canvasData = new FormData();
		canvasData.left =  new FormAttachment(0, 1000, positionFromLeft);
		canvasData.top =  new FormAttachment(0, 1000, positionFromTop);
		canvasData.width = 200;
		canvasData.height = 60;
		
		Canvas playerCanvas = new Canvas(this.shell, SWT.BORDER);
		playerCanvas.setLayoutData(canvasData);
		{
			Label headlineLabel = new Label(playerCanvas, SWT.CENTER);
			headlineLabel.setText(headline);
			headlineLabel.setBounds(10, 2, 180, 15);
		}
		{
			Label levelLabel = new Label(playerCanvas, SWT.NONE);
			levelLabel.setText("Stufe");
			levelLabel.setBounds(12, 20, 60, 15);
		}
		{	
			Label levelValue = new Label(playerCanvas, SWT.NONE);
			levelValue.setText(String.valueOf(level));
			levelValue.setBounds(80, 20, 60, 15);
		}
		{
			Label stockLabel = new Label(playerCanvas, SWT.NONE);
			stockLabel.setText("Ressource");
			stockLabel.setSize(60, 30);
			stockLabel.setBounds(12, 38, 60, 15);
		}
		{	
			Label stockValue = new Label(playerCanvas, SWT.NONE);
			stockValue.setText(String.valueOf(stock));
			stockValue.setBounds(80, 38, 60, 15);
		}
	}

	public void open() {
		this.shell.open();
	}
}
