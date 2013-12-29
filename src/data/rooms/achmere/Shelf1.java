package data.rooms.achmere;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.achmereinterior.LookAisle1Script;

public class Shelf1 extends ConcreteDrawableObject implements IScriptableObject {

	@Override
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		return new LookAisle1Script();
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
