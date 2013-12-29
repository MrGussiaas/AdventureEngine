package scripts;

public interface ICompositeScript extends IGameScript {
	public int getScriptCount();
	public IGameScript getScript(int index);
	public void addScript(IGameScript script);
	public void removeScript(int index);
}
