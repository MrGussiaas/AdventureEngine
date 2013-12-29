package scripts;

import java.awt.Point;

import objects.IGameObject;

public class LeftEdgeIntersector implements IIntersectionHelper {

	private Point intersection;

	@Override
	public boolean isIntersecting(IGameObject object, Point startPointz,
			Point endPointz) {
		Point startPoint = startPointz;
		Point endPoint = endPointz;
		if(endPoint.getX() < startPoint.getX()){
			Point temp = startPoint;
			startPoint = endPoint;
			endPoint = temp;
		}
		double startX = 0;
		double endX = endPoint.getX() - startPoint.getX();
		double startY = startPoint.getY();
		double endY = endPoint.getY();
		double dx = endX - startX;
		double dy = endY - startY;;
		double objectX = object.getX() - startPoint.getX();
		double objectY = object.getY();
		double slopeX = dx == 0 ? 0 : dy / dx;
		double slopeY = dy == 0 ? 0 : dx / dy;
		double yPoint = slopeX != 0 ? slopeX * (objectX) + startY : startY;
		double xPoint = slopeY != 0 ? Math.round(slopeY * (yPoint - startY)) : objectX;
		
		double objectHeight = object.getHeight();
		
		
		
		boolean isIntersecting = dx == 0 && startX == objectX && ((
				(objectY >= startY && objectY <= endY) || (objectY >= endY && objectY<= startY))
			||(objectY + objectHeight >= startY && objectY + objectHeight <= endY) || (objectY + objectHeight >= endY && objectY + objectHeight<= startY));
		if(isIntersecting){
			intersection = new Point((int)(object.getX()), (int)object.getY());
			if(startPointz.getY() < endPointz.getY()){
				intersection = new Point((int)object.getX(), (int)(object.getY() + objectHeight));
			}
			return true;
		}
		/*if(dy == 0){
			double objectDX = objectX+ object.getWidth();
			return (objectX >= startX && objectX <= endX) && ((startY >= objectY && startY <= objectY + object.getHeight())); 
		}*/
		
		if(objectX >= startX && objectX <= endX && yPoint >= objectY && yPoint <= objectY + objectHeight){
			intersection = new Point((int)(objectX + startX), (int)yPoint);
			return true;
		}		
		return false;
	}

	@Override
	public Point getIntersection() {
		// TODO Auto-generated method stub
		return intersection;
	}

}
