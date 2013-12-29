package commands.concretecommands;

import java.awt.Point;

import objects.IGameObject;

public class HitByTruckProcessor implements IObjectCommand {


		public void executeCommand(IObjectCommandContext context,
				IGameObject gameObject) {
			int xVelocity = 1;
			int yVelocity = 1;
			int nextX = (int) gameObject.getHotSpot().getX();
			int nextY = (int) gameObject.getHotSpot().getY();

			context.setNewX((int) gameObject.getX());
			context.setNewY((int) gameObject.getY());
			if(gameObject.getWayPointCount() == 0){
				context.setInternalObjectState(IGameObject.InternalObjectStates.DEAD_FROM_TRUCK_STATE);
				return;
			}
			
			Point wayPoint = gameObject.getWayPoint(0);
			int dx = (int) (wayPoint.getX() - nextX);
			int dy = (int) (wayPoint.getY() - nextY);
			if(Math.abs(dx) < xVelocity){
				xVelocity = Math.abs(dx);
			}
			if(Math.abs(dy) < yVelocity){
				yVelocity = Math.abs(dy);
			}
			context.setNewX((int) (gameObject.getX()+ (dx != 0 ? (dx / Math.abs(dx) * xVelocity) : 0)));
			context.setNewY((int) (gameObject.getY() + (dy != 0 ? (dy / Math.abs(dy) * yVelocity) : 0)));
			
			

		}

	

}
