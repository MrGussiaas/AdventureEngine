package scripts.gamescripts;

import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class EOTScript implements IGameScript {

	@Override
	public void execute(IGameModel model) {
		model.setOnScreenMessage(null);

	}

	@Override
	public void processEvent(IInputEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFinished() {
		return true;
	}

	@Override
	public void setFinished(boolean finished) {
		// TODO Auto-generated method stub

	}

}
