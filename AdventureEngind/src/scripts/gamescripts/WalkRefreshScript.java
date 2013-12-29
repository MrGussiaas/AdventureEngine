package scripts.gamescripts;

import io.IInputEvent;
import io.RefreshEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class WalkRefreshScript implements IGameScript {

	private boolean finished = false;
	public void execute(IGameModel model) {
		if(model.getAvatar().getWayPointCount() == 0){
			finished = true;
		}

	}

	public void processEvent(IInputEvent e) {


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
