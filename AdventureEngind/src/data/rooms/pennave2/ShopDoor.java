package data.rooms.pennave2;

import java.io.File;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class ShopDoor extends ConcreteDrawableObject implements
		IScriptableObject {

	public ShopDoor(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn2"+File.separatorChar+"launderyDoor.bmp");
		
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
