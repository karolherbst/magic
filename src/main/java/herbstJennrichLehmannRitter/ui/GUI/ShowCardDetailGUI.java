package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;
import herbstJennrichLehmannRitter.engine.model.Card;

import java.rmi.RemoteException;

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

/**	Description of HostMenuGUI Class
 * Implementation of the Show Card Detail GUI
 */

public class ShowCardDetailGUI {
	
	private Shell shell;
	private final Display display;
	private Label cardNameLabel;
	private Button exitButton;
	private Button discardButton;
	private Button playCardButton;
	
	private final Card card;
	private PlayGameGUI playGameGui;
	private ChooseDeckGUI chooseDeckGui;
	
	public ShowCardDetailGUI(Display parent, PlayGameGUI playGameGUI, ChooseDeckGUI chooseDeckGUI, Card card) {
		this.display = parent;
		this.playGameGui = playGameGUI;
		this.chooseDeckGui = chooseDeckGUI;
		this.card = card;
		initShell();
		initCardNameText();
		initCardTypeLabel();
		initCardTypeText();
		initCardCostsLabel();
		initCardCostsText();
		initCardEffectsLabel();
		initCardOwnEffectsLabel();
		initCardOwnEffectsText();
		initCardEnemyEffectsLabel();
		initCardEnemyEffectsText();
		if (card.getCanBeDiscarded() == false) {
			initDiscardCardLabel();
		}
		initExitButton();
		if (this.playGameGui != null) {
			if (card.getCanBeDiscarded() == true) {
				initDiscardButton();
			}
			if (this.playGameGui.getPlayerDungeonStock() >= card.getCostMonsters() && 
					this.playGameGui.getPlayerMagicLabStock() >= card.getCostCrystal() && 
					this.playGameGui.getPlayerMineStock() >= card.getCostBrick()) {
				initPlayCardButton();
			}
		}
		this.shell.pack();
	}
	
	public void open() {
		this.shell.open();
	}
	
	private void initShell() {
		this.shell = new Shell(SWT.TITLE);
		this.shell.setText("Kartendetails");
		this.shell.setLayout(new FormLayout());
		MainMenuGUI.setShellLocationCenteredToScreen(this.display, this.shell);
	}
	
	private void initCardNameText() {		
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 40);
		LabelData.top =  new FormAttachment(0, 1000, 15);
		LabelData.width = 300;
		Font font = new Font(this.display, "Arial", 14, SWT.BOLD);
		
		this.cardNameLabel = new Label(this.shell, SWT.CENTER | SWT.WRAP);
		this.cardNameLabel.setText(this.card.getName().toString());
		this.cardNameLabel.setFont(font);
		this.cardNameLabel.setLayoutData(LabelData);
	}

	private void initCardTypeLabel() {
		createCategorieText("Kartentyp:", true, 40, 0, 80);
	}

	private void initCardTypeText() {
		createCardText(this.card.getCardType().toString(), 40, 0);
	}
	
	private void initCardCostsLabel() {
		createCategorieText("Kosten:", true, 65, 0, 80);
	}
	
	private void initCardCostsText() {
		createCardText(this.card.getCostDescription().replace(", ", "\n"), 65, 0);
	}
	
	private void initCardEffectsLabel() {
		createCategorieText("Effekte:", true, 130, 0, 80);
	}
	
	private void initCardOwnEffectsLabel() {
		createCategorieText("Eigene:", false, 150, 90, 80);
	}
	
	private void initCardOwnEffectsText() {
		createCardText(this.card.getOwnEffectDescription(), 150, 90);
	}

	private void initCardEnemyEffectsLabel() {
		createCategorieText("Gegner:", false, 250, 90, 80);
	}
	private void initCardEnemyEffectsText() {
		createCardText(this.card.getEnemyEffectDescription(), 250, 90);
	}
	private void initDiscardCardLabel() {
		createCategorieText("Karte kann nicht verworfen werden", true,  370, 90, 220);
	}

	private void initExitButton() {
		this.exitButton = createButton("Zurück", 390, 275);
		this.exitButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (ShowCardDetailGUI.this.playGameGui != null) {
					ShowCardDetailGUI.this.playGameGui.setCardDetailIsOpen(false);
				}
				if (ShowCardDetailGUI.this.chooseDeckGui != null) {
					ShowCardDetailGUI.this.chooseDeckGui.setCardDetailIsOpen(false);
				}
				ShowCardDetailGUI.this.shell.setVisible(false);
			}
		});
	}
	
	private void initDiscardButton() {
		this.discardButton = createButton("Verwerfen", 390, 25);
		this.discardButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ShowCardDetailGUI.this.playGameGui.setCardDetailIsOpen(false);
					Globals.getLocalGameServer().discardCard(ShowCardDetailGUI.this.card);
					ShowCardDetailGUI.this.playGameGui.playerDiscardCard(ShowCardDetailGUI.this.card.getName());
					ShowCardDetailGUI.this.shell.setVisible(false);
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	private void initPlayCardButton() {
		this.playCardButton = createButton("Spielen", 390, 150);
		this.playCardButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					ShowCardDetailGUI.this.playGameGui.setCardDetailIsOpen(false);
					ShowCardDetailGUI.this.playGameGui.playerPlayedCard(ShowCardDetailGUI.this.card.getName());
					Globals.getLocalGameServer().playCard(ShowCardDetailGUI.this.card);
					ShowCardDetailGUI.this.shell.setVisible(false);
				} catch (RemoteException e1) {
				}
			}
		});
	}
	
	private Button createButton(String text, int x, int y) {
		FormData btnData = new FormData();
		btnData.top =  new FormAttachment(0, 1000, x);
		btnData.left =  new FormAttachment(0, 1000, y);
		btnData.width = 100;
		btnData.height = 28;
		
		Button button = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		button.setLayoutData(btnData);
		button.setText(text);
		
		return button;
	}
	
	private void createCategorieText(String text, boolean underline, 
			int positionFromTop, int fieldHeight, int formDataWidth) {
		FormData formData = new FormData();
		formData.left = new FormAttachment(0, 1000, 30);
		formData.top =  new FormAttachment(0, 1000, positionFromTop);
		if (formDataWidth != 0){
			formData.width = formDataWidth;
		} else {
			formData.width = 80;
		}
		if (fieldHeight != 0) {
			formData.height = fieldHeight;
		}
		
		StyledText field = new StyledText(this.shell, SWT.LEFT);
		field.setText(text);
		
		StyleRange styledRange = new StyleRange();
		styledRange.start = 0;
		styledRange.length = field.getText().length();
		styledRange.underline = underline;
		
		field.setBackground(this.shell.getBackground());
		field.setStyleRange(styledRange);
		field.setLayoutData(formData);
	}
	
	private void createCardText(String text, int postitionFromTop, int fieldHeight) {
		FormData formData = new FormData();
		formData.top =  new FormAttachment(0, 1000, postitionFromTop);
		formData.left = new FormAttachment(0, 1000, 120);
		formData.width = 270;
		if (fieldHeight != 0) {
			formData.height = fieldHeight;
		}
		
		StyledText field = new StyledText(this.shell, SWT.LEFT);
		field.setText(text);
		field.setBackground(this.shell.getBackground());
		field.setWordWrap(true);
		field.setLayoutData(formData);
	}	
}
