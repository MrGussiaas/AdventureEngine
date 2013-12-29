package commands;

import objects.IGameObject;
import io.IInputEvent;
import ui.IGameModel;

public interface IObjectFinder {
	public IGameObject findObject(IGameModel model, IInputEvent event);
	public int getXClick();
	public int getYClick();
	public void setYClick(int yClick);
	public void setXClick(int xClick);
}
