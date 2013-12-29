package commands.finders;

import java.awt.Point;

import io.IInputEvent;
import io.LeftClickEvent;
import objects.IGameObject;
import ui.IGameModel;
import commands.IObjectFinder;

public class LeftClickFinder implements IObjectFinder {

	private int xClick;
	private int yClick;

	public IGameObject findObject(IGameModel model, IInputEvent event) {
		LeftClickEvent castedEvent = (LeftClickEvent) event;
		int x = castedEvent.getX();
		int y = castedEvent.getY();
		this.xClick = x;
		this.yClick = y;
		System.out.println("x: " + x);
		System.out.println("y: " + y);
		IGameObject answer = null;
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			IGameObject current = model.getObject(i);
			int startX = (int) current.getX();
			int endX = (int) (startX + current.getWidth());
			int startY = (int) current.getY();
			int endY = (int) (startY + current.getHeight());
			if(x >= startX && x <= endX && y >= startY && y <= endY){
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
