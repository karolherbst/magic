package herbstJennrichLehmannRitter.engine.exception;

import herbstJennrichLehmannRitter.exception.MagicException;

/** Description of PlayerCouldNotBeCreatedException Class
 *  This Class extends the MagicException Interface.
 *  It sets a serialVersionUID and declares the error texts for the PlayerCouldNotBeCreated Errors.
 */

public class PlayerCouldNotBeCreatedException extends MagicException {

	private static final long serialVersionUID = -5445087690691741698L;

	public static enum PLAYER_ERROR {
		NOT_ENOUGH_CARDS("Nicht genügend Karten. Ein Deck muss aus mindestens 50 Karten bestehen");
		
		private final String msg;
		
		PLAYER_ERROR(String errorMsg) {
			this.msg = errorMsg;
		}
		
		@Override
		public String toString() {
			return this.msg;
		}
	}
	
	private final PLAYER_ERROR code;
	
	public PlayerCouldNotBeCreatedException(PLAYER_ERROR code) {
		super(code);
		this.code = code;
	}
	
	@Override
	public PLAYER_ERROR getCode() {
		return this.code;
	}
}
