package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.model.Card;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;


/**
 * Karten Details aus dem Deck-Creator
 */

public class ShowCardDetailGUI {
	
	private Shell shell;
	private final Display display;
	private boolean isUsedDuringGamePlay;
	private Label lblCardName;
	private Label lblCardTypeName;
	private Label lblCardType;
	private Label lblCardCostsName;
	private Label lblCardCosts;
	private Label lblCardEffectsName;
	private Label lblCardEffects;
	private Button btnExit;
	private Button btnDiscard;
	private Button btnUse;
	private final Card card;
	
	public ShowCardDetailGUI(Display parent, boolean isUsedDuringGamePlay, Card card) {
		this.display = parent;
		this.isUsedDuringGamePlay = isUsedDuringGamePlay;
		this.card = card;
		initShell();
		initLabelCardName();
		initLabelCardTypeName();
		initLabelCardType();
		initLabelCardCostsName();
		initLabelCardCosts();
		initLabelCardOwnEffectsName();
		initLabelCardOwnEffects();
		initLabelCardEnemyEffectsName();
		initLabelCardEnemyEffects();
		initBtnExit();
		if (this.isUsedDuringGamePlay == true) {
			initBtnDiscard();
			initBtnUse();
		}
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Kartendetails");
		this.shell.setLayout(new FormLayout());
		this.shell.setSize(300, 277);
	}
	
	private void initLabelCardName() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 100);
		LabelData.top =  new FormAttachment(0, 1000, 15);
		this.lblCardName = new Label(this.shell, SWT.CENTER);
		this.lblCardName.setText(this.card.getName().toString());
		this.lblCardName.setLayoutData(LabelData);
	}

	private void initLabelCardTypeName() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 27);
		LabelData.top =  new FormAttachment(0, 1000, 40);
		this.lblCardTypeName = new Label(this.shell, SWT.LEFT);
		this.lblCardTypeName.setText("Kartentyp:");
		this.lblCardTypeName.setLayoutData(LabelData);
	}

	private void initLabelCardType() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 110);
		LabelData.top =  new FormAttachment(0, 1000, 40);
		this.lblCardType = new Label(this.shell, SWT.LEFT);
		this.lblCardType.setText(this.card.getCardType().toString());
		this.lblCardType.setLayoutData(LabelData);
	}
	private void initLabelCardCostsName() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 27);
		LabelData.top =  new FormAttachment(0, 1000, 65);
		this.lblCardCostsName = new Label(this.shell, SWT.LEFT);
		this.lblCardCostsName.setText("Kosten:");
		this.lblCardCostsName.setLayoutData(LabelData);
	}
	private void initLabelCardCosts() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 110);
		LabelData.top =  new FormAttachment(0, 1000, 65);
		this.lblCardCosts = new Label(this.shell, SWT.LEFT);
		this.lblCardCosts.setText(this.card.getCostDescription().replace(", ", "\n"));
		this.lblCardCosts.setLayoutData(LabelData);
	}
	private void initLabelCardOwnEffectsName() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 27);
		LabelData.top =  new FormAttachment(0, 1000, 130);
		this.lblCardEffectsName = new Label(this.shell, SWT.LEFT);
		this.lblCardEffectsName.setText("Effekte:");
		this.lblCardEffectsName.setLayoutData(LabelData);
	}
	private void initLabelCardOwnEffects() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 110);
		LabelData.top =  new FormAttachment(0, 1000, 130);
		LabelData.width = 180;
		this.lblCardEffects = new Label(this.shell, SWT.WRAP | SWT.BORDER);
		//TODO Karol, bitte hier mal richtig machen! Danke Sebastian & Sönke
		this.lblCardEffects.setText(this.card.getOwnEffectDescription());
		this.lblCardEffects.setLayoutData(LabelData);
	}

	private void initLabelCardEnemyEffectsName() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 27);
		LabelData.top =  new FormAttachment(0, 1000, 160);
		this.lblCardEffectsName = new Label(this.shell, SWT.LEFT);
		this.lblCardEffectsName.setText("Gegner Effekte:");
		this.lblCardEffectsName.setLayoutData(LabelData);
	}
	private void initLabelCardEnemyEffects() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 110);
		LabelData.top =  new FormAttachment(0, 1000, 160);
		LabelData.width = 180;
		this.lblCardEffects = new Label(this.shell, SWT.WRAP | SWT.BORDER);
		//TODO Karol, bitte hier mal richtig machen! Danke Sebastian & Sönke
		this.lblCardEffects.setText(this.card.getEnemyEffectDescription());
		this.lblCardEffects.setLayoutData(LabelData);
	}

	
	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnExitData = new FormData();
		btnExitData.left =  new FormAttachment(0, 1000, 205);
		btnExitData.top =  new FormAttachment(0, 1000, 220);
		btnExitData.width = 75;
		btnExitData.height = 28;
		this.btnExit.setLayoutData(btnExitData);
		this.btnExit.setText("Zurück");
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ShowCardDetailGUI.this.shell.setVisible(false);
			}
		});
	}
	
	private void initBtnDiscard() {
		this.btnDiscard = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnData = new FormData();
		btnData.left =  new FormAttachment(0, 1000, 15);
		btnData.top =  new FormAttachment(0, 1000, 220);
		btnData.width = 85;
		btnData.height = 28;
		this.btnDiscard.setLayoutData(btnData);
		this.btnDiscard.setText("Verwerfen");
		this.btnDiscard.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO Was hier?
			}
		});
	}
	
	private void initBtnUse() {
		this.btnUse = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnData = new FormData();
		btnData.left =  new FormAttachment(0, 1000, 110);
		btnData.top =  new FormAttachment(0, 1000, 220);
		btnData.width = 85;
		btnData.height = 28;
		this.btnUse.setLayoutData(btnData);
		this.btnUse.setText("Spielen");
		this.btnUse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//TODO Was hier?
			}
		});
	}

	public void open() {
		this.shell.open();
	}
	
}
