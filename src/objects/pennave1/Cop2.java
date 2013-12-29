package objects.pennave1;

import io.IIOHandler;

import java.awt.Image;
import java.awt.Point;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import objects.gameoverdialog.GameOverDialogue;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddNewEventToQueueScript;
import scripts.gamescripts.AddObjectToModelScript;
import scripts.gamescripts.ChangeAvatarCooridinateScript;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.InitWayPointScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.SetAvatarInternalStateScript;
import scripts.gamescripts.SetObjectInternalStateScript;
import scripts.gamescripts.TickerScript;
import scripts.gamescripts.WalkRefreshScript;

public class Cop2 extends ConcreteDrawableObject implements IScriptableObject{

	private int cycleCount;
	public Image createImage() {
		IImageRegistry registry = Cop2ImageRegistryRegistry.getInstance().getRegistry(getInternalState());
		Image image = registry.getImage(cycleCount);
		setHeight(image.getHeight(null));
		setWidth(image.getWidth(null));
		return image;
	}

	@Override
	public void update() {
		cycleCount++;
	}

	@Override
	public IScriptRunner getActionScript() {
		IScriptRunner actionScript = new ConcreteScriptRunner();
		actionScript.addScript(new InitWayPointScript(new Point(410, 250)));
		ICompositeScript walkToScript = new RefreshableCompositeScript();
		walkToScript.addScript(new WalkRefreshScript());
		actionScript.addScript(walkToScript);
		actionScript.addScript(new SetObjectInternalStateScript(IGameObject.InternalObjectStates.SHOOTING_A_GUN, this));
		actionScript.addScript(new SetAvatarInternalStateScript(IGameObject.InternalObjectStates.SHOT_BY_GUN));
		ICompositeScript timeScript = new RefreshableCompositeScript();
		timeScript.addScript(new TickerScript(8));
		actionScript.addScript(timeScript);
		actionScript.addScript(new SetAvatarInternalStateScript(IGameObject.InternalObjectStates.DEAD_FROM_GUN));
		actionScript.addScript(new ChangeAvatarCooridinateScript(new Point(450, 275)));
		actionScript.addScript(new MessageScript("Aginst your better judgement you have decided to lay a finger on cop #2.\n" +
				"Although not technically assault on an officer of the law he seems to think otherwise.\n" +
				"He skips all of the miranda right red tape mumbo jumbo and skips straight to the death penalty\n" +
				" by decorating Pennsylvania ave with your own brains"));
		actionScript.addScript(new MessageScript("As you breath your last breath you now know what your teachers all meant when they said to keep your hands to yourself"));
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
		talkScript.addScript(new InitWayPointScript(new Point(380, 300)));
		ICompositeScript walkToScript = new RefreshableCompositeScript();
		walkToScript.addScript(new WalkRefreshScript());
		talkScript.addScript(walkToScript);
		talkScript.addScript(new MessageScript("You: Um . . . Hello can you tell me how to get to the white house."));
		talkScript.addScript(new MessageScript("Cop2: Why of course I can my good man."));
		talkScript.addScript(new MessageScript("Cop2: It is one screen east of here."));
		talkScript.addScript(new MessageScript("You: Hey thanks a lot I really appreciate it"));
		talkScript.addScript(new MessageScript("Cop2: Don't mention it anything for a good citizen <snicker>."));
		talkScript.addScript(new EOTScript());
		return talkScript;
	}

	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

}
