package scripts;

import java.io.Serializable;

import objects.IGameObject;

public interface IScriptableObject extends Serializable{
	public IScriptRunner getActionScript();
	public IScriptRunner getLookScript();
	public IScriptRunner getTalkScript(IGameObject object);
	public IScriptRunner getItmScript(IGameObject object);
}
