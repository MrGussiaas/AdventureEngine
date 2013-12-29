package scripts;

import java.awt.Point;

import objects.IGameObject;
import ui.IGameModel;

public interface IPointFinder {
	public Point getPoint1(IGameObject object, IGameModel model, Point startPoint);
	public Point getPoint2(IGameObject object, IGameModel model, Point startPoint);
	public boolean isValid(IGameObject object, Point startPoint);
	
	public void addPreviouslyTraversedPoint(Point p);
	public Point getPreviouslyTraversePoint(int index);
	public int getPreviouslyTraversedPointCount();
}
