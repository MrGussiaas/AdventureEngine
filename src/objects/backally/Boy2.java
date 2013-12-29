package objects.backally;

import java.awt.Image;
import java.awt.Point;

import objects.ConcreteDrawableObject;
import objects.IGameObject.InternalObjectStates;
import ui.Boy1ImageMaker;
import ui.Boy2ImageMaker;
import ui.IImageMaker;

public class Boy2 extends ConcreteDrawableObject {

	@Override
	public Image createImage() {
		IImageMaker maker = Boy2ImageMaker.getInstance().getMaker(getInternalState());
		Point start = getHotSpot();
		Point end = new Point((int)getX(), (int)getY());;
		if(getWayPointCount() > 0){
			end = getWayPoint(0);
		}
		
		Image image = maker.getImage(cycleCount, start, end);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
		return image;
	}

	private int cycleCount = 0;
	public void update() {
		if(getWayPointCount() == 0){
			return;
		}
		for(int i = 0, n = getWayPointCount() - 1; i < n; i++){
			removeWayPoint(0);
		}
		Point goalPoint = getWayPoint(0);
		Point hotSpot = getHotSpot();
		int dx = (int) (goalPoint.getX() - hotSpot.getX());
		int dy = (int) (goalPoint.getY() - hotSpot.getY());
		int xVelocity = 5;
		int yVelocity = 5;
		if(Math.abs(dx) < xVelocity){
			xVelocity = Math.abs(dx);
		}
		if(Math.abs(dy) < yVelocity){
			yVelocity = Math.abs(dy);
		}
		int xIncrement = dx != 0 ? (Math.abs(dx) / dx) * xVelocity : 0;
		setX(getX() + xIncrement);
		int yIncrement = dy != 0 ? (Math.abs(dy) / dy * yVelocity) : 0;
		setY(getY() + yIncrement);
		if(hotSpot.equals(goalPoint)){
			removeWayPoint(0);
			setInternalState(InternalObjectStates.DEFAULT_STATE);
		}
		cycleCount++;
	}
	
	public Point getHotSpot() {
		return new Point((int)(getWidth() + getX()), (int)(getHeight() / 2 + getY()));
	}
	
}
