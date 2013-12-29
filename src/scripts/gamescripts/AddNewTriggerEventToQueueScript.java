package scripts.gamescripts;

import commands.UniversalCommandQueue;

import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class AddNewTriggerEventToQueueScript implements IGameScript {

	private boolean finished = false;
	private IInputEvent event;
	
	public AddNewTriggerEventToQueueScript(IInputEvent event){
		this.event = event;
	}
	
	public void execute(IGameModel model) {
		UniversalCommandQueue.getInstance().addEvent(event);
		finished = true;

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
		this.finished = finished;

	}

}
