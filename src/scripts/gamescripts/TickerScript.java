package scripts.gamescripts;

import io.IInputEvent;
import io.RefreshEvent;
import scripts.IGameScript;
import ui.IGameModel;

public class TickerScript implements IGameScript {

	private boolean finished;
	private int ticksToWait;
	private int tickerTime;
	public TickerScript(int ticksToWait){
		this.ticksToWait = ticksToWait;
	}
	
	public void execute(IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processEvent(IInputEvent e) {
		if(e.getClass() == RefreshEvent.class){
			tickerTime++;
		}
		if(tickerTime >= ticksToWait){
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
