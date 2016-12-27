package objects.outsideachmeres;

import io.TriggerEvent;

import java.awt.Image;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddNewTriggerEventToQueueScript;
import scripts.gamescripts.InitWayPointScript;
import scripts.gamescripts.SetObjectInternalStateScript;
import scripts.gamescripts.WalkRefreshScript;
import trigger.DungeonTrigger;

public class AchmeresDoor extends ConcreteDrawableObject implements IScriptableObject {
	
	
	public AchmeresDoor(){
		setInternalState(IGameObject.InternalObjectStates.CLOSED);
		setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"nineteenth2"+File.separatorChar+"achmeresdoorClosed.bmp");
	}

	@Override
	public IScriptRunner getActionScript() {
		IScriptRunner actionRunner = new ConcreteScriptRunner();
		ICompositeScript walkToScript = new RefreshableCompositeScript();
		walkToScript.addScript(new WalkRefreshScript());
		actionRunner.addScript(new InitWayPointScript(new Point(300, 245)));
		actionRunner.addScript(walkToScript);
		actionRunner.addScript(new SetObjectInternalStateScript(IGameObject.InternalObjectStates.OPEN, this));
		actionRunner.addScript(new AddNewTriggerEventToQueueScript(new TriggerEvent(new DungeonTrigger("."+File.separatorChar+"rooms"+File.separatorChar+"achmere.dgn"))));
		
		return actionRunner;
	}

	@Override
	public Image createImage() {
		Image img = AchmeresDoorImageRegistry.getInstance().getImage(getInternalState());
		setHeight(img.getHeight(null));
		setWidth(img.getWidth(null));
		return img;
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
		return null;
	}
}
