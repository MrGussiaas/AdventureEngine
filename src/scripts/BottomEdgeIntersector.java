package scripts;

import java.awt.Point;

import objects.IGameObject;

public class BottomEdgeIntersector implements IIntersectionHelper {

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
		double objectY = object.getY() + object.getHeight();
		double slopeX = dx == 0 ? 0 : dy / dx;
		double slopeY = dy == 0 ? 0 : dx / dy;
		double xPoint = slopeY * (objectY - startY);
		double yPoint = slopeX != 0 ? slopeX * (xPoint) + startY : objectY;
		


		double objectHeight = object.getHeight();
		/*if(dx == 0){
			intersection = new Point((int)startPoint.getX(), (int)(objectY + object.getHeight()));
			return (((objectY >= startY && objectY <= endPoint.getY()) || (objectY >= endPoint.getY() && objectY <= startY )) && (startX >= objectX && startX <= objectX + object.getWidth()));
	
		}*/
		
		if(dy == 0){
			double objectDX = objectX+ object.getWidth();
			boolean answer = ((objectX >= startX && objectX <= endX)|| (objectDX >= startX && objectDX <= endX)) && (startY == objectY);
			if(answer){
			
			intersection = new Point((int)(object.getX() + object.getWidth()), (int)(objectY));
				if(startPointz.getX() < endPointz.getX()){
					intersection = new Point((int)(object.getX()), (int)(objectY));
				}
			}
			return answer; 
		}
		
		if(((objectY >= startY && objectY <= endY ) || objectY >= endY && objectY <= startY)  && xPoint >= objectX && xPoint <= objectX + object.getWidth()){
			intersection = new Point((int)(xPoint + startPoint.getX()), (int)objectY);
			return true;
		}		
		intersection = null;
		return false;
	}

	@Override
	public Point getIntersection() {
		return intersection;
	}

}
