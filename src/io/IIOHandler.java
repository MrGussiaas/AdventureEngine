package io;

import javax.swing.JFrame;

import ui.IUIController;


public interface IIOHandler {
	public static enum GameStates{SCRIPTING, PLAYING, GAME_OVER_STATE};
	public static enum InternalStates{DEFAULT_STATE, WALK_STATE, LOOK_STATE, 
		ACTION_STATE, WAIT_STATE, TALK_STATE, HUD_STATE, PREVIOUS_STATE,
		SETTINGS_STATE, SAVE_GAME_STATE, RESTORE_GAME_STATE, SELECT_INVENTORY_STATE,
		OBJECT_USE_STATE, GAME_OVER_STATE, SCRIPT_ONLY};
	public void processEvent(IInputEvent event);
	public IUIController getController();
	public void setController(IUIController controller);
	public GameStates getGameState();
	public void setGameState(GameStates gameState);
	public InternalStates getInternalState();
	public void setInternalState(InternalStates internalState);
	public void addForwardHandler(IIOHandler nextHandler);

}
