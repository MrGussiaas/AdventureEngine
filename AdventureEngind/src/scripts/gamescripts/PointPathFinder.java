package scripts.gamescripts;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import scripts.IPointPathFinder;
import scripts.IZaggerPoint;
import scripts.IZaggerPointModel;

public class PointPathFinder implements IPointPathFinder {

	private double calculateTraversalDistance(Point startPoint, List<Point> points){
		double answer = 0;
		if(points == null){
			return 0;
		}
		for(int i = 0, n = points.size(); i < n; i++){
			Point currentPoint = points.get(i);
			answer += (currentPoint.distance(startPoint));
			startPoint = currentPoint;
		}
		return answer;
	}
	public List<Point> findPath(IZaggerPoint startPoint, IZaggerPoint endPoint) {
		List<Point> answer = new ArrayList<Point>(10);
		if(startPoint.getChildCount() == 0 || startPoint.getPoint().equals(endPoint.getPoint())){
			answer.add(startPoint.getPoint());
			return answer;
		}
		double traversalDistance = Double.MAX_VALUE;
		double endDistance = Double.MAX_VALUE;
		for(int i = 0, n = startPoint.getChildCount(); i < n; i++){
			IZaggerPoint subPoint = startPoint.getChild(i);
			List<Point> subAnswer = findPath(subPoint, endPoint);
			Point endSub = subAnswer.get(subAnswer.size() - 1);
			double tempEnd = endSub.distance(endPoint.getPoint());
			double tempTraversal = calculateTraversalDistance(startPoint.getPoint(), subAnswer);
			if(tempEnd == 0 && tempTraversal <= traversalDistance){
				traversalDistance = tempTraversal;
				endDistance = tempEnd;
				answer = subAnswer;
			}
			else if(tempEnd != 0 && tempEnd <= endDistance){
				endDistance = tempEnd;
				answer = subAnswer;
			}

		}
		if(endDistance != 0 && startPoint.getPoint().distance(endPoint.getPoint()) <= endDistance){
			answer = new ArrayList<Point>(10);
		}
		answer.add(0, startPoint.getPoint());
		return answer;
	}

}
