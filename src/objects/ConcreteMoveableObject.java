package objects;

import java.awt.Point;

import objects.IGameObject.InternalObjectStates;

import commands.concretecommands.IObjectCommand;
import commands.concretecommands.IObjectCommandContext;
import commands.concretecommands.ObjectCommandContext;
import commands.concretecommands.ObjectCommandRegistry;

public class ConcreteMoveableObject extends ConcreteDrawableObject {

	@Override
	public void update() {
		IObjectCommand command = ObjectCommandRegistry.getInstance().getCommand(this, super.getInternalState());
		IObjectCommandContext context = new ObjectCommandContext();
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
		int xVelocity = 1;
		int yVelocity = 1;
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
	}

	@Override
	public Point getHotSpot() {
		return new Point((int)(getWidth() / 2 + getX()), (int)(getHeight() + getY()));
	}
	
}
