package commands;

import objects.IGameObject;
import trigger.ITrigger;
import io.IIOHandler.InternalStates;

public interface IPostProcessCommandContext {
	public InternalStates getNewState();
	public void setInternalState(InternalStates newState);
	
	public int getNewObjectsCount();
	public void addNewObject(IGameObject newObject);
	public IGameObject getNewObject(int index);
	
	public String getMessage();
	public void setMessage(String message);
	
	public int getTriggerCount();
	public void addTrigger(ITrigger trigger);
	public ITrigger getTrigger(int index);
	public void removeTrigger(int index);
}
