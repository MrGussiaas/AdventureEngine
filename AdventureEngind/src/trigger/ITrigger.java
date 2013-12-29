package trigger;

import java.io.Serializable;

import data.IWarp;
import objects.IGameObject;

public interface ITrigger extends Serializable, IGameObject {
	public boolean isTriggerable(IGameObject object, IWarp warp);
	public void internalTrigger(IGameObject object, IWarp warp);
	public void fireTrigger(ITriggerDescriptor descriptor);
	public boolean isTriggerable(IGameObject object);
	/*public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	public int getWidth();
	public void setWidth(int width);
	public void setHeight(int height);
	public int getHeight();*/
	
}
