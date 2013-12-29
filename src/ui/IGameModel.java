package ui;

import java.awt.Cursor;
import java.util.Comparator;
import java.util.Iterator;

import objects.BackgroundObject;
import objects.IBarrierObject;
import objects.IGameObject;
import trigger.ITrigger;

public interface IGameModel {
	public int getObjectCount();
	public IGameObject getObject(int index);
	public void addObject(IGameObject object);
	public void removeObject(int index);
	public void removeObject(IGameObject object);
	public void clearAllObjects();
	public IGameObject getAvatar();
	public void setAvatar(IGameObject avatar);
	public void setOnScreenMessage(String message);
	public String getOnScreenMessage();
	public Cursor getCursor();
	public void setCursor(Cursor cursor);
	
	public void addBarrier(IBarrierObject barrierObject);
	public IBarrierObject getBarrier(int index);
	public int getBarrierCount();
	public void removeBarrier(int index);
	
	public void sortObjects(Comparator<IGameObject> cmp);
	
	public void addTrigger(ITrigger trigger);
	public ITrigger getTrigger(int index);
	public void removeTrigger(int index);
	public int getTriggerCount();
	
	public void setActiveInventoryItem(IGameObject inventoryItem);
	public IGameObject getActiveInventoryItem();
	
	public void setBackgroundObject(BackgroundObject bgObject);
	public BackgroundObject getBackgroundObject();
	

	
}
