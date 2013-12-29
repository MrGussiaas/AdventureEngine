package scripts;

import java.io.Serializable;

import io.IInputEvent;
import objects.IGameObject;
import ui.IGameModel;

public interface IGameScript extends Serializable{
	public void execute(IGameModel model);
	public void processEvent(IInputEvent e);
	public boolean isFinished();
	public void setFinished(boolean finished);
	
}
