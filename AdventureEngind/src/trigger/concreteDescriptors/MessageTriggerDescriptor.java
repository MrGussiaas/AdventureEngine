package trigger.concreteDescriptors;

import trigger.ITriggerDescriptor;

public class MessageTriggerDescriptor implements ITriggerDescriptor {
	private String message;
	public MessageTriggerDescriptor(String message){
		this.message = message;
	}
	public String getMessage(){
		return message;
	}
}
