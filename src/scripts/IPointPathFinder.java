package scripts;

import java.awt.Point;
import java.util.List;

public interface IPointPathFinder {
	public List<Point> findPath(IZaggerPoint startPoint, IZaggerPoint endPoint);
}
