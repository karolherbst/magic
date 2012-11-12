package herbstJennrichLehmannRitter.engine.exception;

import herbstJennrichLehmannRitter.exception.MagicException;

public class GameEngineException extends MagicException {
	
	private static final long serialVersionUID = 8288228990384367096L;

	public static enum ENGINE_ERROR {
		UNKNOWN_GAME_TYP("this won't ever occur"),
		NOT_2_PLAYERS_AVAILABLE("Derzeit sind nicht 2 Spieler registriert!"),
		NOT_RUNNING("Die GameEngine ist noch nicht gestartet"),
		PLAYER_CANT_EFFORT_CARD("Die Karten kann vom Spieler nicht bezahlt werden!"),
		PLAYER_DONT_OWN_CARD("Diese Karte gehört nicht zum Spieler!");
	
		private final String msg;
		
		ENGINE_ERROR(String errorMsg) {
			this.msg = errorMsg;
		}
		
		@Override
		public String toString() {
			return this.msg;
		}
	}
	
	private final ENGINE_ERROR code;
	
	public GameEngineException(ENGINE_ERROR code, Throwable throwable) {
		super(code, throwable);
		this.code = code;
	}
	
	public GameEngineException(ENGINE_ERROR code) {
		super(code);
		this.code = code;
	}
	
	@Override
	public ENGINE_ERROR getCode() {
		return this.code;
	}
	
}
