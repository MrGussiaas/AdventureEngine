package objects.cityprison;

import io.TriggerEvent;

import java.awt.Image;
import java.awt.Point;

import objects.ConcreteDrawableObject;
import objects.IGameObject;
import objects.outsideachmeres.AchmeresDoorImageRegistry;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddNewTriggerEventToQueueScript;
import scripts.gamescripts.InitWayPointScript;
import scripts.gamescripts.SetObjectInternalStateScript;
import scripts.gamescripts.WalkRefreshScript;
import trigger.DungeonRoomTrigger;
import trigger.DungeonTrigger;

public class PrisonDoor extends ConcreteDrawableObject implements
		IScriptableObject {

	public PrisonDoor(){
		super.setSpriteFile(globalvariables.constants.IMAGE_LOCATION+"cityprison\\prisonDoorClosed.bmp");
		setInternalState(IGameObject.InternalObjectStates.CLOSED);
	}
	public IScriptRunner getActionScript() {
		IScriptRunner actionRunner = new ConcreteScriptRunner();
		ICompositeScript walkToScript = new RefreshableCompositeScript();
		walkToScript.addScript(new WalkRefreshScript());
		actionRunner.addScript(new InitWayPointScript(new Point(300, 245)));
		actionRunner.addScript(walkToScript);
		actionRunner.addScript(new SetObjectInternalStateScript(IGameObject.InternalObjectStates.OPEN, this));
		actionRunner.addScript(new AddNewTriggerEventToQueueScript(new TriggerEvent(new DungeonRoomTrigger(".\\rooms\\prisoninterior.dgn", new Point(50, 200), 1))));
		
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
	public Image createImage() {
		Image img = PrisonDoorImageRegistry.getInstance().getImage(getInternalState());
		setHeight(img.getHeight(null));
		setWidth(img.getWidth(null));
		return img;
	}
	@Override
	public IScriptRunner getItmScript(IGameObject object) {
		// TODO Auto-generated method stub
		return null;
	}

}
