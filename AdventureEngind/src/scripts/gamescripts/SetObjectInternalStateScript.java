package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class SetObjectInternalStateScript implements IGameScript {

	private IGameObject.InternalObjectStates newState;
	private IGameObject target;
	private boolean finished;
	
	public SetObjectInternalStateScript(IGameObject.InternalObjectStates newState, IGameObject target){
		this.target = target;
		this.newState = newState;
	}
	
	public void execute(IGameModel model) {
		target.setInternalState(newState);
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
		// TODO Auto-generated method stub

	}

}
