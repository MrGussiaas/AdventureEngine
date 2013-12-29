package scripts;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import objects.IGameObject;
import ui.IGameModel;

public class TopPointFinder implements IPointFinder {

	
	private List<Point> traversals = new ArrayList<Point>(10);
	
	public Point getPoint1(IGameObject object, IGameModel model, Point startPoint) {
		IIntersectionHelper helper = new RightEdgeIntersector();
		IPointFinder finder = new RightPointFinder();
		Point optimalPoint = new Point((int)(object.getX() - 1), (int)(object.getY() - 1));
		for(int i = 0, n = traversals.size(); i < n; i++){
			finder.addPreviouslyTraversedPoint(traversals.get(i));
		}
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IGameObject barrier = model.getBarrier(i);
			if(object != barrier && helper.isIntersecting(barrier, startPoint, optimalPoint)){
				Point intersection = helper.getIntersection();
				finder.addPreviouslyTraversedPoint(intersection);
				return traversals.contains(intersection) ? intersection : finder.getPoint1(barrier, model, intersection);
			}
		}

		finder.addPreviouslyTraversedPoint(optimalPoint);
		return optimalPoint;
	}

	@Override
	public Point getPoint2(IGameObject object, IGameModel model, Point startPoint) {
		Point optimalPoint = new Point((int)(object.getX() + object.getWidth() + 1), (int)(object.getY() - 1));

		IIntersectionHelper helper = new LeftEdgeIntersector();
		IPointFinder finder = new LeftPointFinder();
		for(int i = 0, n = traversals.size(); i < n; i++){
			finder.addPreviouslyTraversedPoint(traversals.get(i));
		}
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IGameObject barrier = model.getBarrier(i);
			if(object != barrier && helper.isIntersecting(barrier, startPoint, optimalPoint)){
				Point intersection = helper.getIntersection();
				if(traversals.contains(intersection)){
					//return null;
				}
				finder.addPreviouslyTraversedPoint(intersection);
				return traversals.contains(intersection) ? intersection : finder.getPoint1(barrier, model, intersection);
			}
		}

		finder.addPreviouslyTraversedPoint(optimalPoint);
		return optimalPoint;
	}

	public boolean isValid(IGameObject object, Point startPoint) {
		return startPoint.getY() <= object.getY();
	}

	public void addPreviouslyTraversedPoint(Point p) {
		traversals.add(p);
		
	}

	public Point getPreviouslyTraversePoint(int index) {
		return traversals.get(index);
	}

	public int getPreviouslyTraversedPointCount() {
		return traversals.size();
	}

}
