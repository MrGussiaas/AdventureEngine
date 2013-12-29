package scripts.gamescripts;

import javax.swing.JOptionPane;

import objects.IGameObject;
import objects.IInterfaceableObject;
import io.IInputEvent;
import io.LeftClickEvent;
import io.MouseMovedEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class GetSelectionScript implements IGameScript {

	private IGameObject dialogue;
	private boolean finished = false;
	private boolean firstExecution = false;
	
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
		if(casted.getValue() != null){
			JOptionPane.showMessageDialog(null, casted.getValue());
			finished = true;
		}

	}

	@Override
	public void processEvent(IInputEvent e) {


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
