package scripts.gamescripts;

import commands.UniversalCommandQueue;

import io.IIOHandler;
import io.IIOHandler.GameStates;
import io.IInputEvent;
import io.StateSwitchEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class AddNewEventToQueueScript implements IGameScript {

	private boolean finished;
	private IIOHandler.GameStates newState;
	public AddNewEventToQueueScript(GameStates newState) {
		super();
		this.newState = newState;
	}

	public void execute(IGameModel model) {
		UniversalCommandQueue.getInstance().addEvent(new StateSwitchEvent(newState));
		finished = true;

	}

	@Override
	public void processEvent(IInputEvent e) {
		// TODO Auto-generated method stub

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
