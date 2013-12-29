package ui;

import java.awt.Cursor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import objects.BackgroundObject;
import objects.IBarrierObject;
import objects.IGameObject;
import trigger.ITrigger;

public class ConcreteGameModel implements IGameModel {

	private List<IGameObject> gameObjects = new ArrayList<IGameObject>(10);
	private IGameObject avatar;
	private String onScreenMessage = null;
	private Cursor cursor = new Cursor(Cursor.HAND_CURSOR);;
	private List<IBarrierObject> barriers = new ArrayList<IBarrierObject>(10);
	private List<ITrigger> triggers = new ArrayList<ITrigger>(10);
	private IGameObject activeInventoryItem;
	private BackgroundObject backgroundObject;
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

	public IGameObject getAvatar() {
		return avatar;
	}

	public void setAvatar(IGameObject avatar) {
		this.avatar = avatar;

	}

	public void setOnScreenMessage(String message) {
		this.onScreenMessage = message;
		
	}

	@Override
	public Cursor getCursor() {
		return cursor;
	}

	@Override
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
		
	}

	@Override
	public String getOnScreenMessage() {
		return onScreenMessage;
	}

	@Override
	public void addBarrier(IBarrierObject barrierObject) {
		barriers.add(barrierObject);
		
	}

	@Override
	public IBarrierObject getBarrier(int index) {
		return barriers.get(index);
	}

	@Override
	public int getBarrierCount() {
		return barriers.size();
	}

	@Override
	public void removeBarrier(int index) {
		barriers.remove(index);
		
	}

	@Override
	public void sortObjects(Comparator<IGameObject> cmp) {
		Collections.sort(gameObjects, cmp);
		
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

	@Override
	public int getTriggerCount() {
		return triggers.size();
	}

	@Override
	public void removeObject(IGameObject object) {
		gameObjects.remove(object);
		
	}

	@Override
	public void setActiveInventoryItem(IGameObject inventoryItem) {
		this.activeInventoryItem = inventoryItem;
		
	}

	@Override
	public IGameObject getActiveInventoryItem() {
		return activeInventoryItem;
	}

	@Override
	public void setBackgroundObject(BackgroundObject bgObject) {
		this.backgroundObject = bgObject;
		
	}

	@Override
	public BackgroundObject getBackgroundObject() {
		return backgroundObject;
	}

}
