package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class AddObjectToAvatarInventoryScript implements IGameScript {

	private IGameObject target;
	private boolean finished;
	public AddObjectToAvatarInventoryScript(IGameObject target) {
		super();
		this.target = target;
	}

	public void execute(IGameModel model) {
		IGameObject avatar = model.getAvatar();
		avatar.addContainedObject(target);
		finished = true;

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
