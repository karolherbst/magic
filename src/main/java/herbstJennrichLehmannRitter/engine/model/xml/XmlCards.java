package herbstJennrichLehmannRitter.engine.model.xml;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**	Description of XmlCards Class
 *  This Class sets the card collection.
 */

@XmlRootElement(name="Cards")
public class XmlCards {
	
	private Collection<XmlCard> cards;

	@XmlElements({
		@XmlElement(name="Card", type=XmlCard.class)	
	})
	public Collection<XmlCard> getCards() {
		return this.cards;
	}

	public void setCards(Collection<XmlCard> cards) {
		this.cards = cards;
	}
}
