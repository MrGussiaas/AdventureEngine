package scripts.gamescripts;

import java.awt.Point;

import objects.IGameObject;
import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class LopHeadOffScript implements IGameScript {

	private boolean finished;
	public void execute(IGameModel model) {
		IGameObject avatar = model.getAvatar();
		avatar.addWayPoint(new Point((int)avatar.getX(), (int)avatar.getY() - 30));
		avatar.addWayPoint(new Point((int)avatar.getX(), (int)avatar.getY() + 10));
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
