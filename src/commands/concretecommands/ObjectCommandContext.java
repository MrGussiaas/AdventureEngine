package commands.concretecommands;

import objects.IGameObject.InternalObjectStates;

public class ObjectCommandContext implements IObjectCommandContext {

	private int newX;
	private int newY;
	private InternalObjectStates newState;

	@Override
	public int getNewX() {
		return newX;
	}

	@Override
	public int getNewY() {
		return newY;
	}

	@Override
	public void setNewX(int x) {
		this.newX = x;

	}

	@Override
	public void setNewY(int y) {
		this.newY = y;

	}

	@Override
	public InternalObjectStates getNewState() {
		return newState;
	}

	@Override
	public void setInternalObjectState(InternalObjectStates newState) {
		this.newState = newState;

	}

}
