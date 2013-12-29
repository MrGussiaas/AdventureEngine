package trigger;

import ui.IGameModel;

public interface ITriggerModelHandler extends ITriggerHandler {
	public void handleTrigger(IGameModel model, ITriggerDescriptor descriptor);
}
