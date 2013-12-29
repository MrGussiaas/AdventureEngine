package objects;

import java.awt.Point;
import java.io.Serializable;

import trigger.ITriggerHandler;

public interface IGameObject extends ITriggerHandler, Serializable {
	public enum InternalObjectStates{WALKING_STATE, DEFAULT_STATE, HIT_BY_A_TRUCK_STATE, DEAD_FROM_TRUCK_STATE, OPEN, CLOSED,
			FALLING_IN_LOVE, SHOOTING_A_GUN, SHOT_BY_GUN, DEAD_FROM_GUN, LIT, EXPLODE};
	public double getX();
	public double getY();
	public void setX(double x);
	public void setY(double y);
	
	public InternalObjectStates getInternalState();
	public void setInternalState(InternalObjectStates state);
	public double getHeight();
	public double getWidth();
	public void setHeight(double height);
	public void setWidth(double width);
	public void addWayPoint(Point p);
	public int getWayPointCount();
	public void removeWayPoint(int index);
	public Point getWayPoint(int index);
	public void update();
	public Point getHotSpot();
	public void setHotSpot(Point hotSpot);
	
	public int getContainedObjectsCount();
	public void addContainedObject(IGameObject object);
	public IGameObject getContainedObject(int index);
	public void removeContainedObject(int index);
	public void removeContainedObject(IGameObject object);
	
	public double getZIndex();


	
	
}
