package io;

import trigger.ITrigger;

public class TriggerEvent implements IInputEvent {
	private ITrigger trigger;
	
	public TriggerEvent (ITrigger trigger){
		this.trigger = trigger;
	}

	public ITrigger getTrigger() {
		return trigger;
	}

	public void setTrigger(ITrigger trigger) {
		this.trigger = trigger;
	}
}
