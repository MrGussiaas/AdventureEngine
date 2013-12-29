package scripts;

import objects.ConcreteObject;
import objects.IGameObject;

public class ScreenLoadScript extends ConcreteObject{

	private IScriptableObject wrappedScript;
	
	public IScriptableObject getScript(){
		return wrappedScript;
	}
	
	public ScreenLoadScript(IScriptableObject wrappedScript){
		this.wrappedScript = wrappedScript;
	}

}
