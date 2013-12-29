package scripts.gamescripts;

import java.awt.Point;
import java.util.List;

import objects.IGameObject;

import io.IInputEvent;
import scripts.IGameScript;
import scripts.PathFinder;
import trigger.concreteDescriptors.WalkToTrigger;
import ui.IGameModel;

public class InitWayPointScript implements IGameScript {

	private Point endPoint = new Point();
	private boolean finished = false;
	
	
	public InitWayPointScript(Point endPoint) {
		super();
		this.endPoint = endPoint;
	}

	public void execute(IGameModel model) {
		IGameObject avatarObject = model.getAvatar();
		for(int i = 0, n = avatarObject.getWayPointCount(); i < n; i++){
			avatarObject.removeWayPoint(0);
		}
		PathFinder finder = new PathFinder();
		List<Point> wayPoints = finder.findPath(avatarObject.getHotSpot(), endPoint, model);
		for(int i = 0, n = wayPoints.size(); i < n; i++){
			avatarObject.addWayPoint(wayPoints.get(i));
		}
		avatarObject.setInternalState(IGameObject.InternalObjectStates.WALKING_STATE);
		finished = true;
	}

	@Override
	public void processEvent(IInputEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void setFinished(boolean finished) {
		this.finished = finished;

	}

}
