package scripts.gamescripts;

import io.IInputEvent;
import io.LeftClickEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class MessageScript implements IGameScript {

	private boolean finished = false;
	private String message = null;
	public MessageScript(String message) {
		super();
		this.message = message;
	}

	public void execute(IGameModel model) {
		model.setOnScreenMessage(message);

	}

	@Override
	public void processEvent(IInputEvent e) {
		if(e.getClass() == LeftClickEvent.class){
			finished = true;
		}

	}

	@Override
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void setFinished(boolean finished) {
		this.finished = finished;
		
	}

}
