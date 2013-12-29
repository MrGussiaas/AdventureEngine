package scripts;

import io.IInputEvent;
import io.RefreshEvent;
import ui.IGameModel;

public class RefreshableCompositeScript extends CompositeScript {

	private IGameModel model;

	@Override
	public void execute(IGameModel model) {
		this.model = model;
		super.execute(model);
	}

	@Override
	public void processEvent(IInputEvent e) {
		if(e.getClass() != RefreshEvent.class || model == null){
			return;
		}
		for(int i = 0, n = model.getObjectCount(); i < n; i++){
			model.getObject(i).update();
		}
	}

	@Override
	public boolean isFinished() {
		if(super.isFinished()){
			model = null;
		}
		return super.isFinished();
	}
	
}
