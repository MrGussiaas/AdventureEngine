package scripts;

import java.awt.Point;

import objects.IBarrierObject;
import ui.IGameModel;

public class ZaggerModelFactory implements IZaggerModelFactory {

	private static IZaggerModelFactory instance;
	
	public static IZaggerModelFactory getInstance(){
		if(instance == null){
			instance = new ZaggerModelFactory();
		}
		return instance;
	}
	
	private ZaggerModelFactory(){}
	
	private boolean isIntersecting(Point p, IGameModel model){
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IBarrierObject barrier = model.getBarrier(i);
			int x = (int) barrier.getX();
			int y = (int) barrier.getY();
			int dx = (int) (x + barrier.getWidth());
			int dy = (int) (y + barrier.getHeight());
			if(p.getX() >= x && p.getX() <= dx && p.getY() >= y && p.getY() <= dy){
				return true;
			}
		}
		
		return false;
	}
	
	public IZaggerPointModel createZaggerPointsFromModel(IGameModel model) {
		IZaggerPointModel newModel = new ZaggerPointModel();
		for(int i = 0, n = model.getBarrierCount(); i < n; i++){
			IBarrierObject barrier = model.getBarrier(i);
			int x = (int) barrier.getX() - 1;
			int y = (int) barrier.getY() - 1;
			int dx = (int) (barrier.getX() + barrier.getWidth() + 1);
			int dy = (int) (barrier.getY() + barrier.getHeight() + 1);
			Point p1 = new Point(x, y);
			Point p2 = new Point(dx, y);
			Point p3 = new Point(x, dy);
			Point p4 = new Point(dx, dy);
			if(!isIntersecting(p1, model)){
				newModel.addZaggerPoint(new ZaggerPoint(p1));
			}
			if(!isIntersecting(p2, model)){
				newModel.addZaggerPoint(new ZaggerPoint(p2));
			}
			if(!isIntersecting(p3, model)){
				newModel.addZaggerPoint(new ZaggerPoint(p3));
			}
			if(!isIntersecting(p4, model)){
				newModel.addZaggerPoint(new ZaggerPoint(p4));
			}
			
		}
		return newModel;
	}

}
