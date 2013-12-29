package scripts;

import java.io.Serializable;

import io.IInputEvent;
import ui.IGameModel;

public interface IScriptRunner extends Serializable{
	public void execute(IGameModel model);
	public void addScript(IGameScript script);
	public void removeScript(int index);
	public IGameScript getScript(int index);
	public boolean isComplete();
	public void processUIEvent(IInputEvent e);
	public int getScriptCount();
}
