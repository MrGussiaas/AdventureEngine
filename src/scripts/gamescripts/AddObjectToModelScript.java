package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class AddObjectToModelScript implements IGameScript {

	public IGameObject objectToAdd;
	private boolean finished = false;
	
	public AddObjectToModelScript(IGameObject objectToAdd){
		this.objectToAdd = objectToAdd;
	}
	public void execute(IGameModel model) {
		model.addObject(objectToAdd);
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
