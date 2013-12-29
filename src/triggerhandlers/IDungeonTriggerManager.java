package triggerhandlers;

import objects.IGameObject;
import data.IDungeon;
import data.IRoom;
import data.ModelConverter;
import trigger.ITrigger;
import trigger.ITriggerHandler;
import trigger.processors.DungeonProcessors;
import trigger.processors.IDungeonProcessor;
import ui.IGameModel;
import ui.IUIController;

public class IDungeonTriggerManager implements ITriggerHandler {

	public IDungeon getDungeon() {
		return dungeon;
	}
	public void setDungeon(IDungeon dungeon) {
		this.dungeon = dungeon;
	}
	private IUIController controller;
	private IDungeon dungeon;
	public void handleTrigger(ITrigger descriptor) {
		IDungeonProcessor processor = DungeonProcessors.getInstance().getProcessor(descriptor.getClass());
		if(processor != null){
			processor.processTrigger(dungeon);
			processor.postProcess(dungeon, controller, descriptor);
			
			
		}
	}
	public IDungeonTriggerManager(IUIController controller, IDungeon dungeon) {
		super();
		this.controller = controller;
		this.dungeon = dungeon;
	}

}
