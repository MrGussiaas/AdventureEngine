package commands.finders;

import io.IInputEvent;
import io.ScreenLoadedEvent;
import objects.ConcreteObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import ui.IGameModel;
import commands.IObjectFinder;

public class ScreenLoadedFinder implements IObjectFinder {

	private class DummyObject extends ConcreteObject implements IScriptableObject{

		private IScriptRunner wrappedScript;
		
		public DummyObject(IScriptRunner wrappedScript){
			this.wrappedScript = wrappedScript;
		}
		
		public IScriptRunner getActionScript() {
			return wrappedScript;
		}

		@Override
		public IScriptRunner getLookScript() {
			return wrappedScript;
		}

		@Override
		public IScriptRunner getTalkScript(IGameObject object) {
			return wrappedScript;
		}

		@Override
		public IScriptRunner getItmScript(IGameObject object) {
			return wrappedScript;
		}
		
	}
	public IGameObject findObject(IGameModel model, IInputEvent event) {
		ScreenLoadedEvent casted = (ScreenLoadedEvent) event;
		return new DummyObject(casted.getScreenLoadScript().getActionScript());
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
