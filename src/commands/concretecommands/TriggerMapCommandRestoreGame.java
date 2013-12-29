package commands.concretecommands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import objects.IGameObject;
import objects.restoregamedialog.RestoreGameDialog;
import objects.savegamedialoge.SaveGameDialogue;
import objects.settingswindow.CancelButton;
import objects.settingswindow.RestoreButton;
import objects.settingswindow.SaveButton;
import trigger.ITrigger;
import trigger.RemoveObjectTrigger;
import trigger.RestoreGameTrigger;
import trigger.SaveGameTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class TriggerMapCommandRestoreGame implements ICommand {

	private Map<Class<?>, List<ITrigger>> mappedTrigger = new HashMap<Class<?>, List<ITrigger>>(10);
	
	public TriggerMapCommandRestoreGame(){
		List<ITrigger> saveList = new ArrayList<ITrigger>(10);
		List<ITrigger> cancelList = new ArrayList<ITrigger>(10);
		saveList.add(new RemoveObjectTrigger(RestoreGameDialog.getInstance()));
		saveList.add(new RestoreGameTrigger());
		cancelList.add(new RemoveObjectTrigger(RestoreGameDialog.getInstance()));
		mappedTrigger.put(RestoreButton.class, saveList);
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
