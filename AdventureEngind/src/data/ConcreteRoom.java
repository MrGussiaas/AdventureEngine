package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import objects.IGameObject;
import trigger.ITrigger;

public class ConcreteRoom implements IRoom {

	@Override
	public int hashCode() {
		final int prime = 32;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConcreteRoom other = (ConcreteRoom) obj;
		if (id != other.id)
			return false;
		return true;
	}


	private List<IGameObject> gameObjects = new ArrayList<IGameObject>(10);
	private Map<Integer, List<IGameObject>> quadrantMap = new HashMap<Integer, List<IGameObject>>(10);
	private List<ITrigger> triggers = new ArrayList<ITrigger>(10);
	private int id;

	public ConcreteRoom(){
		this.id = (int) System.currentTimeMillis();
	}

	public Iterator<IGameObject> getMappedObjects(int quadrant) {
		List temp = quadrantMap.get(quadrant);
		if(temp != null){
			return temp.iterator();
		}
		return null;
	}


	public void putMappedObjectToQuadrant(int quadrant, IGameObject object) {
		List<IGameObject> slot = quadrantMap.get(quadrant);
		if(slot == null){
			slot = new ArrayList<IGameObject>(10);
			quadrantMap.put(quadrant, slot);
		}
		slot.add(object);

	}

	
	public int getObjectCount() {
		return gameObjects.size();
	}


	public IGameObject getObject(int index) {
		if(index < gameObjects.size()){
			return gameObjects.get(index);
		}
		return null;
	}

	public void addObject(IGameObject object) {
		gameObjects.add(object);

	}

	public void removeObject(int index) {
		if(index < gameObjects.size()){
			gameObjects.remove(index);
		}

	}


	public void clearAllObjects() {
		gameObjects.clear();

	}

	public int getTriggerCount() {
		return triggers.size();
	}

	public void addTrigger(ITrigger trigger) {
		triggers.add(trigger);

	}

	public void removeTrigger(int index) {
		if(index < triggers.size()){
			triggers.remove(index);
		}

	}


	@Override
	public ITrigger getTrigger(int index) {
		return triggers.get(index);
	}


	@Override
	public int getId() {
		return id;
	}


	@Override
	public void setId(int id) {
		this.id = id;
		
	}







}
