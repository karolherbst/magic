package herbstJennrichLehmannRitter.engine.exception;

import herbstJennrichLehmannRitter.exception.MagicException;

public class GameCardFactoryException extends MagicException {

	private static final long serialVersionUID = 8275730135609871722L;

	public static enum CARD_FACTORY_ERROR {
		WRITE_OBJECTS_TO_FILE_FAILED("Karten konnten nicht in eine Datei gespeichert werden!"),
		WRONG_FORMAT("Die geladene Datei hat ein falsches Format!"),
		COULD_NOT_LOAD_COMPLEX_ACTIONS("Die Spezialaktionen konnten nicht geladen werden. Möglicherweise ist die *.jar" +
				" Datei beschädigt!"),
		XML_ERROR("Ein interner JaxB Fehler ist aufgetreten!"),
		INTERNAL_CARD_WAS_NULL("Ein interner Server error!"),
		CARD_ASSERTION_ERROR("Karte in der cards.xml hat einen Fehler!"),
		NO_CARDS_FOUND("Es wurden keine Karten in der cards.xml gefunden!");
		
		private final String msg;
		
		CARD_FACTORY_ERROR(String errorMsg) {
			this.msg = errorMsg;
		}
		
		@Override
		public String toString() {
			return this.msg;
		}
	}
	
	private final CARD_FACTORY_ERROR code;
	
	public GameCardFactoryException(CARD_FACTORY_ERROR code) {
		super(code);
		this.code = code;
	}
	
	public GameCardFactoryException(CARD_FACTORY_ERROR code, String additional) {
		super(code, additional);
		this.code = code;
	}
	
	public GameCardFactoryException(CARD_FACTORY_ERROR code, Throwable throwable) {
		super(code, throwable);
		this.code = code;
	}
	
	@Override
	public CARD_FACTORY_ERROR getCode() {
		return this.code;
	}
	
}
