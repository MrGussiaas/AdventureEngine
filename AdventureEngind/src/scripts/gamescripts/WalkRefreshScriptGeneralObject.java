package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class WalkRefreshScriptGeneralObject implements IGameScript {

	private IGameObject target;
	private boolean finished;
	
	public WalkRefreshScriptGeneralObject(IGameObject target){
		this.target = target;
	}
	
	public void execute(IGameModel model) {
		if(target.getWayPointCount() == 0){
			finished = true;
		}

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
