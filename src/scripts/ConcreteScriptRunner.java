package scripts;

import io.IInputEvent;

import java.util.ArrayList;
import java.util.List;

import ui.IGameModel;

public class ConcreteScriptRunner implements IScriptRunner {

	private List<IGameScript> scripts = new ArrayList<IGameScript>(10);
	public void execute(IGameModel model) {
		IGameScript currentScript = scripts.get(0);
		currentScript.execute(model);
		if(currentScript.isFinished()){
			scripts.remove(0);
		}
		

	}

	@Override
	public void addScript(IGameScript script) {
		scripts.add(script);

	}

	@Override
	public void removeScript(int index) {
		scripts.remove(index);

	}

	@Override
	public IGameScript getScript(int index) {
		return scripts.get(index);
	}

	@Override
	public boolean isComplete() {
		return scripts.isEmpty();
	}

	@Override
	public void processUIEvent(IInputEvent e) {
		if(!scripts.isEmpty()){
			scripts.get(0).processEvent(e);
		}
		
	}

	@Override
	public int getScriptCount() {
		return scripts.size();
	}

}
