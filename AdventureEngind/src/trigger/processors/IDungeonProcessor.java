package trigger.processors;

import data.IDungeon;
import trigger.ITrigger;
import trigger.ITriggerProcessor;
import ui.IGameModel;
import ui.IUIController;

public interface IDungeonProcessor extends ITriggerProcessor {
	public void processTrigger(IDungeon dungeon);
	public void postProcess(IDungeon dungeon, IUIController controller, ITrigger trigger);
}
