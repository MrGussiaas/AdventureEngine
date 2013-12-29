package objects;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import objects.IGameObject.InternalObjectStates;
import trigger.ITrigger;
import trigger.ITriggerDescriptor;

public class ConcreteObject implements IGameObject {


	private double width;
	private double height;
	private double x;
	private double y;
	private List<Point> wayPoints = new ArrayList<Point>(10);
	private InternalObjectStates internalState;
	private Point hotSpot = new Point(0, 0);
	private int scaledWidth;
	private int scaledHeight;
	private List<IGameObject> containedObjects = new ArrayList<IGameObject>(10);

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}


	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}


	public void setX(double x) {
		this.x = x;

	}


	public void setY(double y) {
		this.y = y;

	}


	public InternalObjectStates getInternalState() {
		return internalState;
	}


	public void setInternalState(InternalObjectStates state) {
		this.internalState = state;

	}


	@Override
	public double getHeight() {
		return height;
	}


	@Override
	public double getWidth() {
		return width;
	}


	@Override
	public void setHeight(double height) {
		this.height = height;
		
	}


	@Override
	public void setWidth(double width) {
		this.width = width;
		
	}


	@Override
	public void addWayPoint(Point p) {
		wayPoints.add(p);
		
	}


	@Override
	public int getWayPointCount() {
		return wayPoints.size();
	}


	@Override
	public void removeWayPoint(int index) {
		wayPoints.remove(index);
		
	}


	@Override
	public Point getWayPoint(int index) {
		return wayPoints.get(index);
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void handleTrigger(ITrigger descriptor) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Point getHotSpot() {
		return hotSpot;
	}


	@Override
	public void setHotSpot(Point hotSpot) {
		this.hotSpot = hotSpot;
		
	}


	@Override
	public int getContainedObjectsCount() {
		return containedObjects.size();
	}


	@Override
	public void addContainedObject(IGameObject object) {
		containedObjects.add(object);
		
	}


	@Override
	public IGameObject getContainedObject(int index) {
		return containedObjects.get(index);
	}


	@Override
	public void removeContainedObject(int index) {
		containedObjects.remove(index);
		
	}


	@Override
	public double getZIndex() {
		return height + y;
	}


	@Override
	public void removeContainedObject(IGameObject object) {
		containedObjects.remove(object);
		
	}




}
