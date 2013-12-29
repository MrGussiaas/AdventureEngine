package trigger.processors;

import java.awt.Point;
import java.util.List;

import objects.IGameObject;
import scripts.IPointPathFinder;
import scripts.IZaggerModelFactory;
import scripts.IZaggerPoint;
import scripts.IZaggerPointLinker;
import scripts.IZaggerPointModel;
import scripts.PathFinder;
import scripts.ZaggerModelFactory;
import scripts.ZaggerPoint;
import scripts.ZaggerPointLinker;
import scripts.gamescripts.PointPathFinder;
import trigger.ITrigger;
import trigger.ITriggerProcessor;
import trigger.concreteDescriptors.WalkToTrigger;
import ui.IGameModel;

public class WalkToProcessor implements ITriggerProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		WalkToTrigger castedTrigger = (WalkToTrigger) trigger;
		IGameObject avatarObject = model.getAvatar();
		for(int i = 0, n = avatarObject.getWayPointCount(); i < n; i++){
			avatarObject.removeWayPoint(0);
		}
		
		IZaggerModelFactory factory = ZaggerModelFactory.getInstance();
		IZaggerPointModel zaggerModel = factory.createZaggerPointsFromModel(model);
		zaggerModel.setEnd(new ZaggerPoint(new Point((int)castedTrigger.getX(), (int)castedTrigger.getY())));
		IZaggerPointLinker linker = ZaggerPointLinker.getInstance();
		IZaggerPoint start = new ZaggerPoint(avatarObject.getHotSpot());
		start = linker.createLinkedPoint(start, zaggerModel, model);
		IPointPathFinder finder = new PointPathFinder();
		
		List<Point> wayPoints = finder.findPath(start, zaggerModel.getEnd());
		for(int i = 0, n = wayPoints.size(); i < n; i++){
			avatarObject.addWayPoint(wayPoints.get(i));
		}
		avatarObject.setInternalState(IGameObject.InternalObjectStates.WALKING_STATE);

	}

}
