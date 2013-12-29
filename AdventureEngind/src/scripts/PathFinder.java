package scripts;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import objects.IGameObject;

import ui.IGameModel;

public class PathFinder {
	
	private static Map<Class<?>, IPointFinder> pointFinders = new HashMap<Class<?>, IPointFinder>(10);
	private List<Point> visitedPoints = new ArrayList<Point>(10);
	private static final int MAX_DISTANCE = 1000000;
	static{
		pointFinders.put(RightEdgeIntersector.class, new RightPointFinder());
		pointFinders.put(LeftEdgeIntersector.class, new LeftPointFinder());
		pointFinders.put(BottomEdgeIntersector.class, new BottomPointFinder());
		pointFinders.put(TopEdgeIntersector.class, new TopPointFinder());
		
	}

	
	private double getDistance(List<Point> points, Point endPoint){
		double answer = 0;
		
		if(points.size() == 0){
			return MAX_DISTANCE;
		}
			Point prevPoint = points.get(0);
		
		for(int i = 0, n = points.size();  i < n; i++){
			Point point = points.get(i);
			double asqur = Math.pow(point.getX() - prevPoint.getX(), 2);
			double bsqur = Math.pow(point.getY() - prevPoint.getY(), 2);
			answer += Math.sqrt(asqur + bsqur);
			prevPoint = point;
		}
		/*prevPoint = points.get(points.size() - 1);
		double asqur = Math.pow(endPoint.getX() - prevPoint.getX(), 2);
		double bsqur = Math.pow(endPoint.getY() - prevPoint.getY(), 2);
		answer += Math.sqrt(asqur + bsqur);*/
		if(!points.contains(endPoint)){
			answer += MAX_DISTANCE;
		}
		return answer;
	}
	

	
	public List<Point> findPath(Point startPoint, Point endPoint, IGameModel model){
		List<Point> answer = new ArrayList<Point>(10);
		
		answer.add(startPoint);
		if(visitedPoints.contains(startPoint)){
			return answer;
		}
		visitedPoints.add(startPoint);
		Point currentEndPoint = endPoint;
		Point currentStartPoint = startPoint;
		if(endPoint == null || startPoint == null){
			return new ArrayList<Point>(10);
		}
		double dx = endPoint.getX() - startPoint.getX();
		double dy = endPoint.getY() - startPoint.getY();
		
		IIntersectionHelper helper1 = null;
		IIntersectionHelper helper2 = null;
		if(dx <= 0){
			helper1 = new RightEdgeIntersector();
		}
		else{
			helper1 = new LeftEdgeIntersector();
		}
		if(dy <= 0){
			helper2 = new BottomEdgeIntersector();
		}
		else{
			helper2 = new TopEdgeIntersector();
		}
		boolean hasInterSection = false;
		boolean hasInterSection2 = false;
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IGameObject object = model.getBarrier(i);
			IPointFinder finder1 = pointFinders.get(helper1.getClass());
			IPointFinder finder2 = pointFinders.get(helper2.getClass());
			
			hasInterSection2 = hasInterSection2 | helper1.isIntersecting(object, currentStartPoint, currentEndPoint) | helper2.isIntersecting(object, currentStartPoint, currentEndPoint);
			
			if(helper1.isIntersecting(object, currentStartPoint, currentEndPoint) && !visitedPoints.contains(helper1.getIntersection())){
				List<Point> firstTraversal = new ArrayList<Point>(10); 
				Point point1 = finder1.getPoint1(object, model, helper1.getIntersection());
				Point point2 = finder1.getPoint2(object, model, helper1.getIntersection());
				hasInterSection = true;
				firstTraversal = findPath(point1,currentEndPoint, model);
				
				
				List<Point> secondTraversal = new ArrayList<Point>(10); 
				
				hasInterSection = true;
				secondTraversal = findPath(point2,currentEndPoint, model);

				
				double d1 = getDistance(firstTraversal, endPoint);
				double d2 = getDistance(secondTraversal, endPoint);
				if((d1 < d2)){
					currentEndPoint = firstTraversal.get(0);
					for(int j = firstTraversal.size() - 1; j >= 0; j--){
						answer.add(1, firstTraversal.get(j));
						
					}
					
				}
				else{
					currentEndPoint = secondTraversal.get(0);
					for(int j = secondTraversal.size() - 1; j >= 0; j--){
						answer.add(1, secondTraversal.get(j));
					}
				}
			}
			
			else if(helper2.isIntersecting(object, currentStartPoint, currentEndPoint) && !visitedPoints.contains(helper2.getIntersection())){
				
				
				
				List<Point> firstTraversal = new ArrayList<Point>(10); 
				Point point1 = finder2.getPoint1(object, model, helper2.getIntersection());
				Point point2 = finder2.getPoint2(object, model, helper2.getIntersection());
				firstTraversal = findPath(point1,currentEndPoint, model);
				hasInterSection = true;

				
				List<Point> secondTraversal = new ArrayList<Point>(10); 
				secondTraversal = findPath(point2,currentEndPoint, model);
				hasInterSection = true;
				
			
				double d1 = getDistance(firstTraversal, endPoint);
				double d2 = getDistance(secondTraversal, endPoint);
				if((d1 < d2)){
					currentEndPoint = firstTraversal.get(0);
					for(int j = firstTraversal.size() - 1; j >= 0; j--){
						answer.add(1, firstTraversal.get(j));
					}
				}
				else{
					currentEndPoint = secondTraversal.get(0);
					for(int j = secondTraversal.size() - 1; j >= 0; j--){
						answer.add(1, secondTraversal.get(j));
					}
				}
			}
			
		}
		if(!hasInterSection2){
			answer.add(endPoint);
		}
		return answer;
	}
}
