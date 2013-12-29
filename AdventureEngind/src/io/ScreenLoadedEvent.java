package io;

import scripts.IScriptableObject;

public class ScreenLoadedEvent implements IInputEvent {
	private IScriptableObject screenLoadScript;

	public IScriptableObject getScreenLoadScript() {
		return screenLoadScript;
	}
	
	public ScreenLoadedEvent(IScriptableObject screenLoadScript){
		this.screenLoadScript = screenLoadScript;
	}
}
