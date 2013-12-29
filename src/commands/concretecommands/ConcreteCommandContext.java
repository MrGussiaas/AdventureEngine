package commands.concretecommands;

import java.util.ArrayList;
import java.util.List;

import io.IIOHandler.InternalStates;
import objects.IGameObject;
import trigger.ITrigger;
import commands.IPostProcessCommandContext;

public class ConcreteCommandContext implements IPostProcessCommandContext {

	private InternalStates newState;
	private List<IGameObject> newObjects = new ArrayList<IGameObject>(10);
	private String message;
	private List<ITrigger> triggers = new ArrayList<ITrigger>(10);
	@Override
	public InternalStates getNewState() {
		return newState;
	}

	@Override
	public void setInternalState(InternalStates newState) {
		this.newState = newState;

	}

	@Override
	public int getNewObjectsCount() {
		return newObjects.size();

	}

	@Override
	public void addNewObject(IGameObject newObject) {
		newObjects.add(newObject);

	}

	@Override
	public IGameObject getNewObject(int index) {
		return newObjects.get(index);

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		
	}
	
	
	public int getTriggerCount() {
		return triggers.size();
	}

	@Override
	public void addTrigger(ITrigger trigger) {
		triggers.add(trigger);
		
	}

	@Override
	public ITrigger getTrigger(int index) {
		return triggers.get(index);
	}

	@Override
	public void removeTrigger(int index) {
		triggers.remove(index);
		
	}

}
