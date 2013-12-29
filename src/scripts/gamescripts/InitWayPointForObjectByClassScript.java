package scripts.gamescripts;

import io.IInputEvent;

import java.awt.Point;

import objects.IGameObject;
import scripts.IGameScript;
import trigger.ITrigger;
import ui.IGameModel;

public class InitWayPointForObjectByClassScript implements IGameScript {
	private Class<?> objectClass;
	private boolean finished;
	private Point endPoint;
	
	public InitWayPointForObjectByClassScript(Class<?> objectClass, Point endPoint){
		this.objectClass = objectClass;
		this.endPoint = endPoint;
	}
	
	public void execute(IGameModel model) {
		IGameObject target;
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			IGameObject object = model.getObject(i);
			if(object.getClass() == objectClass){
				object.addWayPoint(endPoint);
			}
		}
		finished = true;
		
	}
	@Override
	public void processEvent(IInputEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean isFinished() {
		return finished;
	}
	@Override
	public void setFinished(boolean finished) {
		// TODO Auto-generated method stub
		
	}
}
