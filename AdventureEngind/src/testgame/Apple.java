package testgame;

import java.awt.Point;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddObjectToAvatarInventoryScript;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.InitWayPointScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.RemoveObjectFromModelScript;
import scripts.gamescripts.WalkRefreshScript;
import scripts.gamescripts.WalkToScript;

public class Apple extends ConcreteDrawableObject implements IScriptableObject {
	
	public Apple(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"apple.bmp");
		

	}

	@Override
	public IScriptRunner getActionScript() {
		IScriptRunner actionRunner = new ConcreteScriptRunner();
		ICompositeScript walkScript = new RefreshableCompositeScript();
		walkScript.addScript(new WalkRefreshScript());
		int midX = (int) (super.getWidth() / 2 + super.getX());
		actionRunner.addScript(new InitWayPointScript(new Point(midX, (int) (super.getY() + super.getHeight()))));
		actionRunner.addScript(walkScript);
		actionRunner.addScript(new MessageScript("You pick up the tasy apple and add it to your inventory"));
		actionRunner.addScript(new AddObjectToAvatarInventoryScript(this));
		actionRunner.addScript(new RemoveObjectFromModelScript(this));
		actionRunner.addScript(new EOTScript());
		return actionRunner;
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
