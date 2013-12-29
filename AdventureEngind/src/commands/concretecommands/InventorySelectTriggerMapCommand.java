package commands.concretecommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.inventorywindow.InventoryWindow;
import objects.savegamedialoge.IListCel;
import objects.settingswindow.CancelButton;
import objects.settingswindow.SaveButton;
import trigger.ITrigger;
import trigger.RemoveObjectTrigger;
import trigger.SetActiveInventoryItemTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class InventorySelectTriggerMapCommand implements ICommand {

	private Map<Class<?>, List<ITrigger>> triggerLists = new HashMap<Class<?>, List<ITrigger>>(10);
	
	public InventorySelectTriggerMapCommand(){
		List<ITrigger> okTriggers = new ArrayList<ITrigger>(10);
		List<ITrigger> cancelTriggers = new ArrayList<ITrigger>(10);
		okTriggers.add(new RemoveObjectTrigger(InventoryWindow.getInstance()));
		cancelTriggers.add(new RemoveObjectTrigger(InventoryWindow.getInstance()));
		triggerLists.put(SaveButton.class, okTriggers);
		triggerLists.put(CancelButton.class, cancelTriggers);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		if(objectClicked == null){
			return;
		}
		List<ITrigger> answer = triggerLists.get(objectClicked.getClass());
		if(answer == null){
			return;
		}
		for(int i = 0, n = answer.size(); i < n; i++){
			context.addTrigger(answer.get(i));
		}

		if(objectClicked.getClass() == SaveButton.class){
			IInterfaceableObject casted = (IInterfaceableObject) InventoryWindow.getInstance();
			context.addTrigger(new SetActiveInventoryItemTrigger((IGameObject) casted.getValue()));
		}

	}

}
