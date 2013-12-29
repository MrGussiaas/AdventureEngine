package trigger;

import objects.IGameObject;

public class SetActiveInventoryItemTrigger extends ConcreteTrigger {
	private IGameObject currentlySelectedObjected;
	
	public SetActiveInventoryItemTrigger(IGameObject currentlySelectedObject){
		this.currentlySelectedObjected = currentlySelectedObject;
		
	}
}
