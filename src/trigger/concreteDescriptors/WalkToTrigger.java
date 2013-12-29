package trigger.concreteDescriptors;

import objects.IGameObject;
import data.IWarp;
import trigger.ConcreteTrigger;
import trigger.ITrigger;
import trigger.ITriggerDescriptor;

public class WalkToTrigger extends ConcreteTrigger {

	private int x;
	private int y;
	
	public WalkToTrigger(int x, int y){
		super.setX(x);
		super.setY(y);
	}
	


	@Override
	public boolean isTriggerable(IGameObject object, IWarp warp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void internalTrigger(IGameObject object, IWarp warp) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fireTrigger(ITriggerDescriptor descriptor) {
		// TODO Auto-generated method stub

	}

}
