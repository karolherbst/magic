package herbstJennrichLehmannRitter.engine.exception;

import herbstJennrichLehmannRitter.exception.MagicException;

public class CardFactoryFileException extends MagicException {

	private static final long serialVersionUID = 4080238999628630585L;
	
	private static String ERROR_PREFIX = "The GameCardFactory encountered a problem: ";
	
	public CardFactoryFileException(String message, Throwable throwable) {
		super(ERROR_PREFIX + message, throwable);
	}
	
}
