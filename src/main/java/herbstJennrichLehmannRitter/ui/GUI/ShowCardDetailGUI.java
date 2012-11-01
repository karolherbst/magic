package herbstJennrichLehmannRitter.ui.GUI;

import herbstJennrichLehmannRitter.engine.Globals;

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
import org.eclipse.swt.widgets.Table;


/**
 * Karten Details aus dem Deck-Creator
 */

public class ShowCardDetailGUI {
	
	private Shell shell;
	private final Display display;
	private Button btnExit;
	private Label lblCardName;
	private Label lblCardTypeName;
	private Label lblCardType;
	private Label lblCardCostsName;
	private Label lblCardCosts;
	private Label lblCardEffectsName;
	private Label lblCardEffects;
	
	public ShowCardDetailGUI(Display parent) {
		this.display = parent;
		initShell();
		initLabelCardName();
		initLabelCardTypeName();
		initLabelCardType();
		initLabelCardCostsName();
		initLabelCardCosts();
		initLabelCardEffectsName();
		initLabelCardEffects();
		initBtnExit();
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
		this.lblCardName.setText("Kartenname");
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
		this.lblCardType.setText("Zauberkarte");
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
		this.lblCardCosts.setText("6 Ziegel\n6 Kistalle\n3 Monster");
		this.lblCardCosts.setLayoutData(LabelData);
	}
	private void initLabelCardEffectsName() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 27);
		LabelData.top =  new FormAttachment(0, 1000, 130);
		this.lblCardEffectsName = new Label(this.shell, SWT.LEFT);
		this.lblCardEffectsName.setText("Effekte:");
		this.lblCardEffectsName.setLayoutData(LabelData);
	}
	private void initLabelCardEffects() {
		FormData LabelData = new FormData();
		LabelData.left = new FormAttachment(0, 1000, 110);
		LabelData.top =  new FormAttachment(0, 1000, 130);
		LabelData.width = 180;
		this.lblCardEffects = new Label(this.shell, SWT.WRAP | SWT.BORDER);
		this.lblCardEffects.setText("Gegner legt alle Steinbruch-Karten auf den Kartenfriedhof, ziehe und spiele noch eine Karte");
		this.lblCardEffects.setLayoutData(LabelData);
	}
	
	
	private void initBtnExit() {
		btnExit = new Button(this.shell, SWT.PUSH | SWT.CENTER);
		FormData btnExitData = new FormData();
		btnExitData.left =  new FormAttachment(0, 1000, 210);
		btnExitData.top =  new FormAttachment(0, 1000, 220);
		btnExitData.width = 69;
		btnExitData.height = 28;
		btnExit.setLayoutData(btnExitData);
		btnExit.setText("Zurück");
		this.btnExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ShowCardDetailGUI.this.shell.setVisible(false);
			}
		});
	}

	public void open(String card) {
		cardStringToObject(card);
		this.shell.open();
	}
	
	private void cardStringToObject(String card) {
		//TODO: Karol, wir müssen irgendwie an ein einzelnes Kartenobjekt kommen!
	}

}
