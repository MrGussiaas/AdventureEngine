package trigger;

import objects.IGameObject;

public class AddObjectTrigger extends ConcreteTrigger {
	private IGameObject objectToAdd;
	
	public AddObjectTrigger(IGameObject objectToAdd){
		this.objectToAdd = objectToAdd;
	}
	
	public IGameObject getObjectToAdd(){
		return objectToAdd;
	}
}
