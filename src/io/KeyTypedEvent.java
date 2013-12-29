package io;

import java.awt.event.KeyEvent;

public class KeyTypedEvent implements IInputEvent {
	private KeyEvent event;
	
	public KeyTypedEvent(KeyEvent event){
		this.event = event;
	}
	
	public KeyEvent getKeyEvent(){
		return event;
	}
}
