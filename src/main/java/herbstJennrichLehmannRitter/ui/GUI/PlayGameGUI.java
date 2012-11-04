package herbstJennrichLehmannRitter.ui.GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
public class PlayGameGUI {

	/**
	 * Implementation des Spiels
	 */
	
	
	private Shell shell;
	private final Display display;
	private Button btnExit;
	private Button btnCardOne;
	private Button btnCardTwo;
	private Button btnCardThree;
	private Button btnCardFour;
	private Button btnCardFive;
	private Button btnCardSix;
	private Button btnPlayingCardOne;
	private Button btnPlayingCardTwo;
	private Label Enemy;
	private Label Player;
	private Label EnemyDungeonLevel;
	private Label EnemyDungeonRessources;
	private Label EnemyLabLevel;
	private Label EnemyLabRessources;
	private Label EnemyMineLevel;
	private Label EnemyMineRessources;
	private Label EnemyTowerLevel;
	private Label EnemyWallLevel;
	private Label PlayerDungeonLevel;
	private Label PlayerDungeonRessources;
	private Label PlayerLabLevel;
	private Label PlayerLabRessources;
	private Label PlayerMineLevel;
	private Label PlayerMineRessources;
	private Label PlayerTowerLevel;
	private Label PlayerWallLevel;
	
	
	
	public PlayGameGUI(Display parent) {
		this.display = parent;
		initShell();
		initBtnExit();
	}
	

	private void initShell() {
		this.shell = new Shell(SWT.TITLE | SWT.CLOSE);
		this.shell.setText("Spiel");
		this.shell.setLayout(new FormLayout());
		this.shell.layout();
		this.shell.pack();
		this.shell.setSize(1024, 600);
	}
	
	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.PUSH | SWT.NONE);
		FormData btnExitData = new FormData();
		btnExitData.left =  new FormAttachment(0, 2, 2);
		btnExitData.top =  new FormAttachment(0, 1000, 540);
		btnExitData.width = 1010;
		btnExitData.height = 30;
		this.btnExit.setLayoutData(btnExitData);
		this.btnExit.setText("Spiel beenden");
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PlayGameGUI.this.shell.setVisible(false);
			}
		});
	}

	public void open() {
		this.shell.open();
	}
	
	

}
