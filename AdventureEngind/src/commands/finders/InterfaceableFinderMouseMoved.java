package commands.finders;

import io.IInputEvent;
import io.LeftClickEvent;
import io.MouseMovedEvent;

import java.awt.Point;

import objects.IGameObject;
import objects.IInterfaceableObject;
import ui.IGameModel;

public class InterfaceableFinderMouseMoved extends LeftClickFinder {
	private int xClick;
	private int yClick;

	public IGameObject findObject(IGameModel model, IInputEvent event) {
		MouseMovedEvent castedEvent = (MouseMovedEvent) event;
		int x = (int) castedEvent.getNewPoint().getX();
		int y = (int) castedEvent.getNewPoint().getY();
		this.xClick = x;
		this.yClick = y;

		IGameObject answer = null;
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			IGameObject current = model.getObject(i);
			int startX = (int) current.getX();
			int endX = (int) (startX + current.getWidth());
			int startY = (int) current.getY();
			int endY = (int) (startY + current.getHeight());
			if(x >= startX && x <= endX && y >= startY && y <= endY && current instanceof IInterfaceableObject){
				return getSubObject(current, new Point(x, y));
			}
		}
		return answer;
	}
	
	private IGameObject getSubObject(IGameObject mainObject, Point clickPoint){
		if(mainObject.getContainedObjectsCount() == 0){
			return mainObject;
		}
		for(int i = 0, n = mainObject.getContainedObjectsCount(); i < n; i++){
			IGameObject subObject = mainObject.getContainedObject(i);
			int x = (int) subObject.getX();
			int y = (int) subObject.getY();
			int endX = (int) (mainObject.getX() + x + subObject.getWidth());
			int endY = (int) (mainObject.getY() + y + subObject.getHeight());
			if(clickPoint.getX() >= x && clickPoint.getX() <= endX && clickPoint.getY() >= y && clickPoint.getY() <= endY){
				return getSubObject(subObject, clickPoint);
			}
		}
		return mainObject;
	}

	@Override
	public int getXClick() {
		return xClick;
	}

	@Override
	public int getYClick() {
		return yClick;
	}

	@Override
	public void setYClick(int yClick) {
		this.yClick = yClick;
		
	}

	@Override
	public void setXClick(int xClick) {
		this.xClick = xClick;
		
	}
}
