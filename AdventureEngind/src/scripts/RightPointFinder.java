package scripts;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import objects.IGameObject;
import ui.IGameModel;

public class RightPointFinder implements IPointFinder {

	private List<Point> traversals = new ArrayList<Point>(10);
	public Point getPoint1(IGameObject object, IGameModel model, Point startPoint) {
		Point optimalPoint = new Point((int)(object.getX() + object.getWidth() + 1), (int)object.getY() - 1);
		IIntersectionHelper helper = new BottomEdgeIntersector();
		IPointFinder finder = new BottomPointFinder();
		for(int i = 0, n = traversals.size(); i < n; i++){
			finder.addPreviouslyTraversedPoint(traversals.get(i));
		}
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IGameObject barrier = model.getBarrier(i);
			if(object != barrier && helper.isIntersecting(barrier, startPoint, optimalPoint)){
				Point intersection = helper.getIntersection();
				if(traversals.contains(intersection)){
				//	return null;
				}
				finder.addPreviouslyTraversedPoint(intersection);
				return traversals.contains(intersection) ? intersection : finder.getPoint2(barrier, model, intersection);
			}
		}

		finder.addPreviouslyTraversedPoint(optimalPoint);
		return optimalPoint;
		
	}

	@Override
	public Point getPoint2(IGameObject object, IGameModel model, Point startPoint) {
		Point optimalPoint = new Point((int)(object.getX() + object.getWidth() + 1), (int)(object.getY() + object.getHeight() + 1)); 
		IIntersectionHelper helper = new TopEdgeIntersector();
		IPointFinder finder = new TopPointFinder();
		for(int i = 0, n = traversals.size(); i < n; i++){
			finder.addPreviouslyTraversedPoint(traversals.get(i));
		}
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IGameObject barrier = model.getBarrier(i);
			if(object != barrier && helper.isIntersecting(barrier, startPoint, optimalPoint)){
				Point intersection = helper.getIntersection();
				if(traversals.contains(intersection)){
				//	return null;
				}
				finder.addPreviouslyTraversedPoint(intersection);
				return traversals.contains(intersection) ? intersection : finder.getPoint2(barrier, model, intersection);
			}
		}

		finder.addPreviouslyTraversedPoint(optimalPoint);
		return optimalPoint;
	}

	@Override
	public boolean isValid(IGameObject object, Point startPoint) {
		return startPoint.getX() >= object.getX() + object.getWidth();
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
