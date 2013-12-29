package data.rooms.pennave2;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.IScriptRunner;
import scripts.IScriptableObject;

public class ShopDoor extends ConcreteDrawableObject implements
		IScriptableObject {

	public ShopDoor(){
		super.setSpriteFile(".\\images\\penn2\\launderyDoor.bmp");
		
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
