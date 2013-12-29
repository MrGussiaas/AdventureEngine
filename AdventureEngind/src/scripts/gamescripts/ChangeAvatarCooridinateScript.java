package scripts.gamescripts;

import java.awt.Point;

import io.IInputEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class ChangeAvatarCooridinateScript implements IGameScript {

	private Point point;
	boolean finished;
	public ChangeAvatarCooridinateScript(Point point) {
		this.point = point;
	}

	public void execute(IGameModel model) {
		model.getAvatar().setX(point.getX());
		model.getAvatar().setY(point.getY());
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
