package scripts.oncomingtraffic;

import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class LoadBackAlleyScript implements IScriptableObject {

	private IScriptRunner scriptToRun = new LoadAlleyRunner();
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
