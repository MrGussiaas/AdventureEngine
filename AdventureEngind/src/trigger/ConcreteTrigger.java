package trigger;

import objects.ConcreteObject;
import objects.IGameObject;
import data.IWarp;

public class ConcreteTrigger extends ConcreteObject implements ITrigger {

	private int x;
	private int y;
	private int width;
	private int height;

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

	/*@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;

	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;

	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;

	}

	@Override
	public void setHeight(int height) {
		this.height = height;

	}

	@Override
	public int getHeight() {
		return height;
	}*/

	@Override
	public boolean isTriggerable(IGameObject object) {
		return false;
		// TODO Auto-generated method stub
		
	}

}
