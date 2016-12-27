package data.rooms.achmere;

import java.io.File;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import renderingpolicies.TransparencyPolicy;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.achmereinterior.LookBeerScript;

public class BeerCooler extends ConcreteDrawableObject implements
		IScriptableObject {

	public BeerCooler(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"achmereInterior"+File.separatorChar+"beerCooler.bmp");
		super.addImagePolicy(new TransparencyPolicy(0xFFFA45EC));
	}
	
	@Override
	public IScriptRunner getActionScript() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		return new LookBeerScript();
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
