package herbstJennrichLehmannRitter.engine.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/** Description of CardType enum
 *  This Class implements the enums for all Cards.
 */

@XmlType(name="CardType")
@XmlEnum
public enum CardType {
	
	@XmlEnumValue("Steinbruch")		MINE("Steinbruch"),
	@XmlEnumValue("Zauberlabor")	MAGIC_LAB("Zauberlabor"),
	@XmlEnumValue("Verlies")		DUNGEON("Verlies"),
	@XmlEnumValue("Spezial")		SPECIAL("Spezial");
	
	private String value;
	
	private CardType(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value + "karte";
	}
}
