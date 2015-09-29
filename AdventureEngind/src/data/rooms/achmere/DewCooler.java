package data.rooms.achmere;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import renderingpolicies.TransparencyPolicy;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.achmereinterior.LookDewScript;

public class DewCooler extends ConcreteDrawableObject implements
		IScriptableObject {

	public DewCooler(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"achmereInterior\\dewCooler.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
	}
	
	@Override
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		return new LookDewScript();
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
