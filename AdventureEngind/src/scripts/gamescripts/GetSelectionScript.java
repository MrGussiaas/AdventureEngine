package scripts.gamescripts;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import objects.IGameObject;
import objects.IInterfaceableObject;
import io.IInputEvent;
import io.LeftClickEvent;
import io.MouseMovedEvent;
import scripts.CompositeScript;
import scripts.IGameScript;
import scripts.IScriptRunner;
import ui.IGameModel;

public class GetSelectionScript extends CompositeScript {

	private IGameObject dialogue;
	private boolean finished = false;
	private boolean firstExecution = false;
	private IScriptRunner compositeScript = null;

	
	private Map<Object, IScriptRunner> choiceMap = new HashMap<Object, IScriptRunner>(10);
	
	public void addScriptMapping(Object object, IScriptRunner script){
		choiceMap.put(object, script);
	}
	
	public GetSelectionScript(IGameObject dialogue) {
		super();
		this.dialogue = dialogue;
	}

	public void execute(IGameModel model) {
		if(!firstExecution){
			model.addObject(dialogue);
			firstExecution = true;
		}
		IInterfaceableObject casted = (IInterfaceableObject) dialogue;
		if(compositeScript != null){
			IGameScript script = compositeScript.getScript(0);
			script.execute(model);
			if(script.isFinished()){
				compositeScript.removeScript(0);
			}
			finished = compositeScript.isComplete();
		}
		else if (casted.getValue() != null){
			compositeScript = choiceMap.get(casted.getValue());
		}


	}

	@Override
	public void processEvent(IInputEvent e) {
		if(compositeScript != null){
			compositeScript.processUIEvent(e);
		}

	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void setFinished(boolean finished) {
		// TODO Auto-generated method stub

	}

}
