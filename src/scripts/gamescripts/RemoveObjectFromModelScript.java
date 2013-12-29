package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class RemoveObjectFromModelScript implements IGameScript {

	private IGameObject target;
	private boolean finished = false;
	public void execute(IGameModel model) {
		model.removeObject(target);
		finished = true;

	}

	public RemoveObjectFromModelScript(IGameObject target) {
		super();
		this.target = target;
	}

	@Override
	public void processEvent(IInputEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return finished;
	}

	@Override
	public void setFinished(boolean finished) {
		this.finished = finished;

	}

}
