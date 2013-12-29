package data;

import java.io.Serializable;
import java.util.Iterator;

import objects.IGameObject;
import trigger.ITrigger;

public interface IRoom extends IWarp{
	
	public Iterator<IGameObject> getMappedObjects(int quadrant);
	public void putMappedObjectToQuadrant(int quadrant, IGameObject object);
	public int getObjectCount();
	public IGameObject getObject(int index);
	public void addObject(IGameObject object);
	public void removeObject(int index);
	public void clearAllObjects();
	public int getTriggerCount();
	public void addTrigger(ITrigger trigger);
	public ITrigger getTrigger(int index);
	public void removeTrigger(int index);
}
