package herbstJennrichLehmannRitter.exception;

public abstract class MagicException extends RuntimeException {
	
	private static final long serialVersionUID = 3788396458956006670L;
	
	public MagicException(Enum<?> code) {
		super(code.toString());
	}
	
	public MagicException(Enum<?> code, String additional) {
		super(code.toString() + ": " + additional);
	}
	
	public MagicException(Enum<?> code, Throwable throwable) {
		super(code.toString(), throwable);
	}
	
	public abstract Enum<?> getCode();
	
}
