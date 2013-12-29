package scripts.gamescripts;

import java.awt.Point;
import java.util.List;

import objects.IGameObject;

import io.IInputEvent;
import scripts.IGameScript;
import scripts.PathFinder;
import ui.IGameModel;

public class InitWayPointForGeneralObjectScript implements IGameScript {

	private Point endPoint = new Point();
	private boolean finished = false;
	private IGameObject target;
	
	public InitWayPointForGeneralObjectScript(Point endPoint, IGameObject target) {
		super();
		this.endPoint = endPoint;
		this.target = target;
	}
	
	public void execute(IGameModel model) {
		for(int i = 0, n = target.getWayPointCount(); i < n; i++){
			target.removeWayPoint(0);
		}
			target.addWayPoint(endPoint);
		
		target.setInternalState(IGameObject.InternalObjectStates.WALKING_STATE);
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
