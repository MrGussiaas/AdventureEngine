package trigger.processors;

import trigger.ITrigger;
import trigger.ITriggerProcessor;
import trigger.RemoveObjectTrigger;
import ui.IGameModel;

public class RemoveObjectProcessor implements ITriggerProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		RemoveObjectTrigger castedTrigger = (RemoveObjectTrigger) trigger;
		model.removeObject(castedTrigger.getObjectToRemove());

	}

}
