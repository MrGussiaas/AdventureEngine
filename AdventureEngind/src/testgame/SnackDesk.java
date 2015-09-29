package testgame;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.ConcreteScriptRunner;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class SnackDesk extends ConcreteDrawableObject implements IScriptableObject{
	private IScriptRunner lookRunner = new ConcreteScriptRunner();
	public SnackDesk(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"snackdesk.bmp");
		lookRunner.addScript(new MessageScript("You are looking at a snack desk."));
		lookRunner.addScript(new MessageScript("It is filled only with health food. . . now that is messed up"));
		lookRunner.addScript(new EOTScript());
	}

	@Override
	public IScriptRunner getActionScript() {
		return null;
	}

	@Override
	public IScriptRunner getLookScript() {
		// TODO Auto-generated method stub
		return lookRunner;
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
