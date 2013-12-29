package commands.concretecommands;

import io.IIOHandler;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import objects.IGameObject;
import objects.savegamedialoge.SaveGameDialogue;
import objects.settingswindow.CancelButton;
import objects.settingswindow.SaveButton;
import commands.ICommand;
import commands.IPostProcessCommandContext;
import java.util.Map;

import trigger.ITrigger;
import trigger.RemoveObjectTrigger;
import trigger.SaveGameTrigger;
public class TriggerMapCommandSaveGame implements ICommand {

	private Map<Class<?>, List<ITrigger>> mappedTrigger = new HashMap<Class<?>, List<ITrigger>>(10);
	
	public TriggerMapCommandSaveGame(){
		List<ITrigger> saveList = new ArrayList<ITrigger>(10);
		List<ITrigger> cancelList = new ArrayList<ITrigger>(10);
		saveList.add(new RemoveObjectTrigger(SaveGameDialogue.getInstance()));
		saveList.add(new SaveGameTrigger());
		cancelList.add(new RemoveObjectTrigger(SaveGameDialogue.getInstance()));
		mappedTrigger.put(SaveButton.class, saveList);
		mappedTrigger.put(CancelButton.class, cancelList);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		List<ITrigger> answer = mappedTrigger.get(objectClicked.getClass());
		if(answer != null){
			for(int i = 0, n = answer.size();  i < n; i++){
				context.addTrigger(answer.get(i));
			}
		}

	}

}
