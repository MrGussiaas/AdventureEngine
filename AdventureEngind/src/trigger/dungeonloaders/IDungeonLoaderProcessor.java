package trigger.dungeonloaders;

import data.IDungeon;
import trigger.ITrigger;
import trigger.ITriggerProcessor;
import ui.IUIController;

public interface IDungeonLoaderProcessor extends ITriggerProcessor {
	public IDungeon loadNewDungeon(IDungeon currentDungeon, ITrigger trigger);
}
