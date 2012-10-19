package herbstJennrichLehmannRitter.engine.exception;

import herbstJennrichLehmannRitter.exception.MagicException;

public class EngineCouldNotStartException extends MagicException {
	
	private static final long serialVersionUID = 8288228990384367096L;

	private static String DEFAULT_ERROR = "Engine could not start, because of error: ";
	
	public EngineCouldNotStartException(Throwable throwable) {
		super(DEFAULT_ERROR, throwable);
	}
	
	public EngineCouldNotStartException(String message) {
		super(DEFAULT_ERROR + message);
	}
	
}
