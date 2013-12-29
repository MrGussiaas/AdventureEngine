package trigger;

import objects.IGameObject;
import data.IWarp;

public class AddMessageToModelTrigger extends ConcreteTrigger {

	private String message = "";
	
	public AddMessageToModelTrigger(String message){
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}
	

}
