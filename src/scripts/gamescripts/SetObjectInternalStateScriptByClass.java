package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class SetObjectInternalStateScriptByClass implements IGameScript {

	private IGameObject.InternalObjectStates newState;
	private Class<?> objectClass;
	private boolean finished;
	
	public SetObjectInternalStateScriptByClass(IGameObject.InternalObjectStates newState, Class<?> objectClass){
		this.newState = newState;
		this.objectClass = objectClass;
	}
	
	public void execute(IGameModel model) {
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			IGameObject object = model.getObject(i);
			if(object.getClass() == objectClass){
				object.setInternalState(newState);
			}
		}
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
