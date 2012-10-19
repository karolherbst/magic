package herbstJennrichLehmannRitter.engine.exception;

import herbstJennrichLehmannRitter.exception.MagicException;

public class EngineCouldNotStartException extends MagicException {
	
	private static String DEFAULT_ERROR = "Engine could not start, because of errors";
	
	public EngineCouldNotStartException(Throwable throwable) {
		super(DEFAULT_ERROR, throwable);
	}
	
}
