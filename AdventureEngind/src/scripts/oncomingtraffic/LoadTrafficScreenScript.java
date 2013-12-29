package scripts.oncomingtraffic;

import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.ScreenLoadScript;

public class LoadTrafficScreenScript implements IScriptableObject {

	private IScriptRunner scriptToRun = new LoadTrafficScreenRunner();
	public IScriptRunner getActionScript() {
		return scriptToRun;
	}
	@Override
	public IScriptRunner getLookScript() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IScriptRunner getTalkScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

}
