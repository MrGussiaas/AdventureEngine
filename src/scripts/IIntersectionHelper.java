package scripts;

import java.awt.Point;

import objects.IGameObject;

public interface IIntersectionHelper {
	public boolean isIntersecting(IGameObject object, Point startPoint, Point endPoint);
	public Point getIntersection();
}
