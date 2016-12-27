package objects.pennave1;

import io.IIOHandler;

import java.awt.Image;
import java.awt.Point;
import java.io.File;

import commands.runners.ConcreteRunner;
import objects.ConcreteDrawableObject;
import objects.ConcreteMoveableObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.gameoverdialog.GameOverDialogue;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.IGameScript;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddNewEventToQueueScript;
import scripts.gamescripts.AddObjectToModelScript;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.InitWayPointForGeneralObjectScript;
import scripts.gamescripts.InitWayPointScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.SetObjectInternalStateScript;
import scripts.gamescripts.WalkRefreshScript;
import scripts.gamescripts.WalkRefreshScriptGeneralObject;

public class Cop1 extends ConcreteDrawableObject implements IScriptableObject{

	int cycle;
	public Image createImage() {
		IImageRegistry imageRegistry = Cop1ImageRegistryRegistry.getInstance().getRegistry(getInternalState());
		Image image = imageRegistry.getImage(cycle);
		setWidth(image.getWidth(null));
		setHeight(image.getHeight(null));
		return image;
	}

	@Override
	public void update() {
		cycle ++;
	}

	@Override
	public IScriptRunner getActionScript() {
		IScriptRunner actionScript = new ConcreteScriptRunner();
		IDrawableObject redHeart = new ConcreteMoveableObject();
		redHeart.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"penn1"+File.separatorChar+"redHeart.bmp");
		redHeart.setX(360);
		redHeart.setY(180);
		
		actionScript.addScript(new InitWayPointScript(new Point(380, 300)));
		ICompositeScript walkToScript = new RefreshableCompositeScript();
		ICompositeScript heartAnimateScript = new RefreshableCompositeScript();
		walkToScript.addScript(new WalkRefreshScript());
		actionScript.addScript(walkToScript);
		actionScript.addScript(new MessageScript("You reach your hand out to the cop and . . ."));
		actionScript.addScript(new SetObjectInternalStateScript(IGameObject.InternalObjectStates.FALLING_IN_LOVE, this));
		actionScript.addScript(new AddObjectToModelScript(redHeart));
		actionScript.addScript(new EOTScript());
		actionScript.addScript(new InitWayPointForGeneralObjectScript(new Point(360, 150), redHeart));
		heartAnimateScript.addScript(new WalkRefreshScriptGeneralObject(redHeart));
		actionScript.addScript(heartAnimateScript);
		actionScript.addScript(new MessageScript("Way to go stud it appears as if you are cop #1's type."));
		actionScript.addScript(new MessageScript("Although we'll spare you the Disney sponsored details of the next few moments\n since this is a family game. . ."));
		actionScript.addScript(new MessageScript("At least you can look on the bright side of knowning that you won't have to die alone after all."));
		actionScript.addScript(new AddObjectToModelScript(new GameOverDialogue()));
		actionScript.addScript(new AddNewEventToQueueScript(IIOHandler.GameStates.GAME_OVER_STATE));
		actionScript.addScript(new EOTScript());
		return actionScript;
	}

	@Override
	public IScriptRunner getLookScript() {
		IScriptRunner lookScript = new ConcreteScriptRunner();
		lookScript.addScript(new MessageScript("Ah yes you see to of D.C.'s finest hard at work."));
		lookScript.addScript(new MessageScript("You catch the whiff of doughnuts coming from the cop on the left"));
		lookScript.addScript(new EOTScript());
		return lookScript;
	}

	@Override
	public IScriptRunner getTalkScript(IGameObject object) {
		IScriptRunner talkScript = new ConcreteScriptRunner();
		talkScript.addScript(new InitWayPointScript(new Point(350, 300)));
		ICompositeScript walkToScript = new RefreshableCompositeScript();
		walkToScript.addScript(new WalkRefreshScript());
		talkScript.addScript(walkToScript);
		talkScript.addScript(new MessageScript("You: Um . . . Hello can you tell me how to get to the white house."));
		talkScript.addScript(new MessageScript("Cop1: Why of course I can my good man."));
		talkScript.addScript(new MessageScript("Cop1: Go to 621 East 76th Street in Boulder Colorado, it's next to House 623 which is the yellow House."));
		talkScript.addScript(new MessageScript("You: Gee. . . thanks"));
		talkScript.addScript(new EOTScript());
		return talkScript;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
