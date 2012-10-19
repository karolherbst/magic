package herbstJennrichLehmannRitter.exception;

public class MagicException extends RuntimeException {
	
	private static final long serialVersionUID = 3788396458956006670L;
	
	private static String DEFAULT_ERROR = "undefined cause exception";
	
	public MagicException() {
		super(DEFAULT_ERROR);
	}
	
	public MagicException(String cause) {
		super(cause);
	}
	
	public MagicException(String cause, Throwable throwable) {
		super(cause, throwable);
	}
	
	public MagicException(Throwable throwable) {
		super(throwable);
	}
	
}
