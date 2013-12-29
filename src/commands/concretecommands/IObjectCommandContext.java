package commands.concretecommands;

import objects.IGameObject;

public interface IObjectCommandContext {
	public int getNewX();
	public int getNewY();
	
	public void setNewX(int x);
	public void setNewY(int y);
	
	public IGameObject.InternalObjectStates getNewState();
	public void setInternalObjectState(IGameObject.InternalObjectStates newState);
}
