package scripts;

import java.util.ArrayList;
import java.util.List;

import io.IInputEvent;
import ui.IGameModel;

public class CompositeScript implements IGameScript, ICompositeScript {

	private List<IGameScript> scripts = new ArrayList<IGameScript>(10);
	public int getScriptCount() {
		return scripts.size();
	}

	@Override
	public IGameScript getScript(int index) {
		return scripts.get(index);
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
	public void execute(IGameModel model) {
		for(int i = 0, n = scripts.size(); i < n; i++){
			scripts.get(i).execute(model);
		}

	}

	@Override
	public void processEvent(IInputEvent e) {
		for(int i = 0, n = scripts.size(); i < n; i++){
			scripts.get(i).processEvent(e);
		}

	}

	@Override
	public boolean isFinished() {
		boolean finished = true;
		for(int i = 0, n = scripts.size(); i < n; i++){
			finished = finished & scripts.get(i).isFinished();
		}
		return finished;
	}

	@Override
	public void setFinished(boolean finished) {
		for(int i = 0, n = scripts.size(); i < n; i++){
			scripts.get(i).setFinished(finished);
		}

	}

}
