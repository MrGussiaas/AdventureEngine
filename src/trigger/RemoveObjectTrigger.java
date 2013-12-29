package trigger;

import objects.IGameObject;

public class RemoveObjectTrigger extends ConcreteTrigger {
	private IGameObject objectToRemove;
	
	public RemoveObjectTrigger(IGameObject objectToRemove){
		this.objectToRemove = objectToRemove;
	}
	
	public IGameObject getObjectToRemove(){
		return objectToRemove;
	}
}
