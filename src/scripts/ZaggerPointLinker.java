package scripts;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.IBarrierObject;

import ui.IGameModel;

public class ZaggerPointLinker implements IZaggerPointLinker {

	private static IZaggerPointLinker instance;
	private List<IZaggerPoint> visitedPoints = new ArrayList<IZaggerPoint>(10);
	private Line2D line = new Line2D.Double(new Point(0,0), new Point(0,0));
	private Rectangle rect = new Rectangle();
	public static IZaggerPointLinker getInstance(){
		if(instance == null){
			instance = new ZaggerPointLinker();
		}
		return instance;
	}
	
	private ZaggerPointLinker(){

	}
	
	private boolean isBlocked(IZaggerPoint start, IZaggerPoint end, IGameModel gameModel){
		line.setLine(start.getPoint(), end.getPoint());
		for(int i = 0, n = gameModel.getBarrierCount(); i < n; i++){
			if(start.getPoint().equals(end.getPoint())){
				return true;
			}
			IBarrierObject barrierObject = gameModel.getBarrier(i);
			rect.setBounds((int)barrierObject.getX(), (int)barrierObject.getY(), (int)barrierObject.getWidth(), (int)barrierObject.getHeight());
			
			if(rect.intersectsLine(line)){
				return true;
			}
		}
		return false;
	}
	
	
	
	public void linkZaggerPoints(IZaggerPointModel zaggerModel,
			IGameModel gameModel) {
		List<IZaggerPoint> adjacentPoints = new ArrayList<IZaggerPoint>(10);
		for(int i = 0, n = zaggerModel.getZaggerPointCount(); i < n; i++){
			IZaggerPoint zaggerPoint = zaggerModel.getZaggerPoint(i);
			visitedPoints.add(zaggerPoint);
			for(int j = 0, k = zaggerModel.getZaggerPointCount(); j < k; j++){
				IZaggerPoint comparePoint = new ZaggerPoint(zaggerModel.getZaggerPoint(j).getPoint());
				if(!isBlocked(comparePoint, zaggerPoint, gameModel)){	
					adjacentPoints.add(comparePoint);
					visitedPoints.add(comparePoint);
				}
			}
			for(int j = 0, k = adjacentPoints.size(); j < k; j++){
				visitedPoints.remove(adjacentPoints.get(0));
				zaggerPoint.addChild(createLinkedPoint(adjacentPoints.get(0), zaggerModel, gameModel));
				adjacentPoints.remove(0);
			}
			visitedPoints.remove(zaggerPoint);
		}
		
		if(zaggerModel.getStart() != null){
			zaggerModel.setStart(createLinkedPoint(zaggerModel.getStart(), zaggerModel, gameModel));
		}
		if(zaggerModel.getEnd() != null){
			zaggerModel.setEnd(createLinkedPoint(zaggerModel.getEnd(), zaggerModel, gameModel));
		}
	}


	public IZaggerPoint createLinkedPoint(IZaggerPoint zaggerPoint, IZaggerPointModel zaggerModel,
			IGameModel gameModel) {
		IZaggerPoint answer = new ZaggerPoint(zaggerPoint.getPoint());
		visitedPoints.add(answer);

		for(int i = 0, n = zaggerModel.getZaggerPointCount(); i < n; i++){
			IZaggerPoint comparePoint = zaggerModel.getZaggerPoint(i);
			if(!visitedPoints.contains(comparePoint) && !isBlocked(comparePoint, answer, gameModel)){
				visitedPoints.add(comparePoint);
				answer.addChild(comparePoint);
			}
		}
		for(int i = 0, n = answer.getChildCount(); i < n; i++){
			IZaggerPoint newPoint = createLinkedPoint(answer.getChild(0), zaggerModel, gameModel);
			answer.removeChild(0);
			answer.addChild(newPoint);
		}
		for(int i = 0, n = answer.getChildCount(); i < n; i++){
			visitedPoints.remove(answer.getChild(i));
		}
		visitedPoints.remove(answer);
		if(zaggerModel.getEnd() != null){
			if(!isBlocked(zaggerModel.getEnd(), answer, gameModel)){
				answer.addChild(zaggerModel.getEnd());
			}
		}
		return answer;
	}
	

}
