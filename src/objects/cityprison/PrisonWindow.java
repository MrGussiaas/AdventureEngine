package objects.cityprison;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class PrisonWindow extends ConcreteDrawableObject implements
		IScriptableObject {

	public PrisonWindow(){
		super.setSpriteFile(".\\images\\cityprison\\jailbars.bmp");
	}
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
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
