package commands.finders;

import io.IInputEvent;
import objects.IGameObject;
import ui.IGameModel;
import commands.IObjectFinder;

public class RefreshFinder implements IObjectFinder {

	@Override
	public IGameObject findObject(IGameModel model, IInputEvent event) {
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			model.getObject(i).update();
		}
		return null;
	}

	@Override
	public int getXClick() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getYClick() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setYClick(int yClick) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setXClick(int xClick) {
		// TODO Auto-generated method stub

	}

}
