package objects.cityprison;

import java.io.File;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class PrisonWindow extends ConcreteDrawableObject implements
		IScriptableObject {

	public PrisonWindow(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"cityprison"+File.separatorChar+"jailbars.bmp");
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
