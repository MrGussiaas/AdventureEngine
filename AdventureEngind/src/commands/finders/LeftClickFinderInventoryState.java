package commands.finders;

import io.IInputEvent;
import io.LeftClickEvent;

import java.awt.Point;

import objects.ConcreteObject;
import objects.IGameObject;
import objects.inventorywindow.InventoryWindow;
import objects.restoregamedialog.RestoreGameDialog;
import ui.IGameModel;

public class LeftClickFinderInventoryState extends LeftClickFinder {
	private int xClick;
	private int yClick;
	public IGameObject findObject(IGameModel model, IInputEvent event) {
		LeftClickEvent castedEvent = (LeftClickEvent) event;
		int x = castedEvent.getX();
		int y = castedEvent.getY();
		this.xClick = x;
		this.yClick = y;

		IGameObject answer = null;
		for(int i = 0, n = InventoryWindow.getInstance().getContainedObjectsCount(); i < n; i++){
			IGameObject current = InventoryWindow.getInstance().getContainedObject(i);
			int startX = (int) (current.getX() + InventoryWindow.getInstance().getX());
			int endX = (int) (startX + current.getWidth());
			int startY = (int) ( current.getY() + InventoryWindow.getInstance().getY());
			int endY = (int) (startY + current.getHeight());
			if(x >= startX && x <= endX && y >= startY && y <= endY){
				return getSubObject(current, new Point(x - startX, y - startY));
			}
		}
		return new ConcreteObject();
	}
	
	private IGameObject getSubObject(IGameObject mainObject, Point clickPoint){
		if(mainObject.getContainedObjectsCount() == 0){
			return mainObject;
		}
		for(int i = 0, n = mainObject.getContainedObjectsCount(); i < n; i++){
			IGameObject subObject = mainObject.getContainedObject(i);
			int x = (int) subObject.getX();
			int y = (int) subObject.getY();
			int endX = (int) (x + subObject.getWidth());
			int endY = (int) (y + subObject.getHeight());
			if(clickPoint.getX() >= x && clickPoint.getX() <= endX && clickPoint.getY() >= y && clickPoint.getY() <= endY){
				return getSubObject(subObject, new Point((int)(x - subObject.getX()), (int)(y - (subObject.getY()))));
			}
		}
		return mainObject;
	}
}
