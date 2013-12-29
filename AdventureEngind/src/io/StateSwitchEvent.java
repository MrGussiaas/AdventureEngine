package io;

public class StateSwitchEvent implements IInputEvent {
	public IIOHandler.GameStates getNewState() {
		return newState;
	}

	private IIOHandler.GameStates newState;
	
	public StateSwitchEvent(IIOHandler.GameStates newState){
		this.newState = newState;
	}
}
