package herbstJennrichLehmannRitter.engine.model.xml;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CardNames")
public class XmlCardNames {
	
	private Collection<String> cardNames;
	
	@XmlElements({
		@XmlElement(name="Card", type=String.class)
	})
	public Collection<String> getCardNames() {
		return this.cardNames;
	}
	
	public void setCardNames(Collection<String> cardNames) {
		this.cardNames = cardNames;
	}
}
