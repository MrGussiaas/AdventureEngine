package scripts.gamescripts;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class WalkRefreshScriptGeneralObjectByClass implements IGameScript {

	private Class<?> objectClass;
	private IGameObject mappedObject = null;
	private boolean finished;
	
	public WalkRefreshScriptGeneralObjectByClass(Class<?> objectClass){
		this.objectClass = objectClass;
	}
	
	public void execute(IGameModel model) {
		if(mappedObject == null){
			for(int i = 0, n = model.getObjectCount(); i < n; i++){
				IGameObject object = model.getObject(i);
				if(object.getClass() == objectClass){
					mappedObject = object;
				}
			}
		}
		if(mappedObject.getWayPointCount() == 0){
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
		// TODO Auto-generated method stub

	}

}
