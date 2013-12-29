package scripts;

import java.awt.Point;

import objects.IGameObject;

public class RightEdgeIntersector implements IIntersectionHelper {

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
			double objectX = object.getX() + object.getWidth() - startPoint.getX();
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
				intersection = new Point((int)(object.getX() + object.getWidth()),(int)object.getY());
				if(endPointz.getY() < startPointz.getY()){
					intersection = new Point((int)(object.getX() + object.getWidth()),(int)(object.getY() + object.getHeight()));
				}
				return true;
			}			
			if(objectX >= startX && objectX <= endX && yPoint >= objectY && yPoint <= objectY + objectHeight){
				intersection = new Point((int)(object.getX() + object.getWidth()), (int)(yPoint));
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
