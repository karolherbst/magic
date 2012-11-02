package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.model.Card;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
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
	private final Card card;
	private Label lblCardName;
	private StyledText cardTypeName;
	private StyledText lblCardType;
	private StyledText cardCostsName;
	private StyledText lblCardCosts;
	private StyledText cardEffectsName;
	private StyledText cardEnemyEffectsName;
	private StyledText lblCardEnemyEffects;
	private StyledText cardOwnEffectsName;
	private StyledText lblCardOwnEffects;
	private Button btnExit;
	private Button btnDiscard;
	private Button btnUse;
	
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
		initLabelCardEffectsName();
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
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Kartendetails");
		this.shell.setLayout(new FormLayout());
		this.shell.setSize(400, 450);
	}
	
	private void initLabelCardName() {		
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 100);
		LabelData.top =  new FormAttachment(0, 1000, 15);
		LabelData.width = 200;
		this.lblCardName = new Label(this.shell, SWT.CENTER);
		this.lblCardName.setText(this.card.getName().toString());
		Font font = new Font(this.display, "Arial", 14, SWT.BOLD);
		this.lblCardName.setFont(font);
		this.lblCardName.setLayoutData(LabelData);
	}

	private void initLabelCardTypeName() {
		this.createCategorieText(this.cardTypeName, "Kartentyp:", true, 40, 0);
	}

	private void initLabelCardType() {
		this.createCardText(this.lblCardType, this.card.getCardType().toString(), 40, 0);
	}
	
	private void initLabelCardCostsName() {
		this.createCategorieText(this.cardCostsName, "Kosten:", true, 65, 0);
	}
	
	private void initLabelCardCosts() {
		this.createCardText(this.lblCardCosts, this.card.getCostDescription().replace(", ", "\n"), 65, 0);
	}
	
	private void initLabelCardEffectsName() {
		this.createCategorieText(this.cardEffectsName, "Effekte:", true, 130, 0);
	}
	
	private void initLabelCardOwnEffectsName() {
		this.createCategorieText(this.cardOwnEffectsName, "Eigene:", false, 150, 50);
	}
	
	private void initLabelCardOwnEffects() {
		this.createCardText(this.lblCardOwnEffects, this.card.getOwnEffectDescription(), 150, 50);
	}

	private void initLabelCardEnemyEffectsName() {
		this.createCategorieText(this.cardEnemyEffectsName, "Gegner:", false, 210, 50);
	}
	private void initLabelCardEnemyEffects() {
		this.createCardText(this.lblCardEnemyEffects, this.card.getEnemyEffectDescription(), 210, 50);
	}

	private void initBtnExit() {
		this.btnExit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnExitData = new FormData();
		btnExitData.top =  new FormAttachment(0, 1000, 390);
		btnExitData.left =  new FormAttachment(0, 1000, 275);
		btnExitData.width = 100;
		btnExitData.height = 30;
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
		btnData.top =  new FormAttachment(0, 1000, 390);
		btnData.left =  new FormAttachment(0, 1000, 25);
		btnData.width = 100;
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
		btnData.top =  new FormAttachment(0, 1000, 390);
		btnData.left =  new FormAttachment(0, 1000, 150);
		btnData.width = 100;
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
	
	private void createCategorieText(StyledText field, String text, boolean underline, int positionFromTop, int fieldHeight) {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 30);
		formData.top =  new FormAttachment(0, 1000, positionFromTop);
		formData.width = 90;
		if (fieldHeight != 0) {
			formData.height = fieldHeight;
		}
		
		field = new StyledText(this.shell, SWT.LEFT);
		field.setText(text);
		
		StyleRange styledRange = new StyleRange();
		styledRange.start = 0;
		styledRange.length = field.getText().length();
		styledRange.underline = underline;
		
		field.setBackground(this.shell.getBackground());
		field.setStyleRange(styledRange);
		field.setLayoutData(formData);
	}
	
	private void createCardText(StyledText field, String text, int postitionFromTop, int fieldHeight) {
		FormData formData = new FormData();
		formData.top =  new FormAttachment(0, 1000, postitionFromTop);
		formData.left = new FormAttachment(0, 1000, 120);
		formData.width = 270;
		if (fieldHeight != 0) {
			formData.height = fieldHeight;
		}
		
		field = new StyledText(this.shell, SWT.LEFT);
		field.setText(text);
		field.setBackground(this.shell.getBackground());
		field.setLayoutData(formData);
	}	
}
