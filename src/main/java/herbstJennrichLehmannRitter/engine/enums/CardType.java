package herbstJennrichLehmannRitter.engine.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="CardType")
@XmlEnum
public enum CardType {
	// TODO simplier names
	
	@XmlEnumValue("Steinbruch")		CARD_TYPE_MINE("Steinbruch"),
	@XmlEnumValue("Zauberlabor")	CARD_TYPE_MAGIC_LAB("Zauberlabor"),
	@XmlEnumValue("Verlies")		CARD_TYPE_DUNGEON("Verlies"),
	@XmlEnumValue("Spezial")		CARD_TYPE_SPECIAL("Spezial");
	
	private String value;
	
	private CardType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
