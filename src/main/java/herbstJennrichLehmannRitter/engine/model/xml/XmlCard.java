package herbstJennrichLehmannRitter.engine.model.xml;

import herbstJennrichLehmannRitter.engine.enums.CardType;
import herbstJennrichLehmannRitter.engine.model.Card;
import herbstJennrichLehmannRitter.engine.model.action.ComplexCardAction;
import herbstJennrichLehmannRitter.engine.model.action.OtherActions;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement(name="Card")
public class XmlCard implements Card {

	private String name;
	private CardType cardType;
	private int costBrick;
	private int costMonster;
	private int costCrystal;
	private OtherActions ownSimpleCardAction;
	private OtherActions enemySimpleCardAction;
	private ComplexCardAction complexCardAction;
	
	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name="Name", required=true)
	@Override
	public String getName() {
		return this.name;
	}
	
	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	@XmlElement(name="CardType", required=true)
	@Override
	public CardType getCardType() {
		return this.cardType;
	}

	public void setCostBrick(int costBrick) {
		this.costBrick = costBrick;
	}

	@XmlElement(name="CostBrick")
	@Override
	public int getCostBrick() {
		return this.costBrick;
	}

	public void setCostMonsters(int costMonsters) {
		this.costMonster = costMonsters;
	}

	@XmlElement(name="CostMonster")
	@Override
	public int getCostMonsters() {
		return this.costMonster;
	}

	public void setCostCrystal(int costCrystal) {
		this.costCrystal = costCrystal;
	}

	@XmlElement(name="CostCrystal")
	@Override
	public int getCostCrystal() {
		return this.costCrystal;
	}

	public void setOwnSimpleCardAction(OtherActions ownSimpleCardAction) {
		this.ownSimpleCardAction = ownSimpleCardAction;
	}

	@XmlElement(name="OwnCardAction", type=XmlOtherActions.class, required=true)
	@Override
	public OtherActions getOwnSimpleCardAction() {
		return this.ownSimpleCardAction;
	}
	
	public void setEnemySimpleCardAction(OtherActions enemySimpleCardAction) {
		this.enemySimpleCardAction = enemySimpleCardAction;
	}

	@XmlElement(name="EnemyCardAction", type=XmlOtherActions.class, required=true)
	@Override
	public OtherActions getEnemySimpleCardAction() {
		return this.enemySimpleCardAction;
	}

	public void setComplexCardAction(ComplexCardAction complexCardAction) {
		this.complexCardAction = complexCardAction;
	}

	@XmlTransient
	@Override
	public ComplexCardAction getComplexCardAction() {
		return this.complexCardAction;
	}

}
