package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class SetAvatarInternalStateScript implements IGameScript {

	private IGameObject.InternalObjectStates newState;
	private boolean finished;
	
	public SetAvatarInternalStateScript(IGameObject.InternalObjectStates newState){
		this.newState = newState;
	}
	
	public void execute(IGameModel model) {
		model.getAvatar().setInternalState(newState);
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
