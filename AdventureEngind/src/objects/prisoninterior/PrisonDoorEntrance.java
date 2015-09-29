package objects.prisoninterior;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import renderingpolicies.IImagePolicy;
import renderingpolicies.TransparencyPolicy;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class PrisonDoorEntrance extends ConcreteDrawableObject implements
		IScriptableObject {

	public PrisonDoorEntrance(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"PrisonInterior\\doorentrance.bmp");
		IImagePolicy transparency = new TransparencyPolicy(0xFFFA45EC);
		super.addImagePolicy(transparency);
		setInternalState(IGameObject.InternalObjectStates.CLOSED);
	}
	
	@Override
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
