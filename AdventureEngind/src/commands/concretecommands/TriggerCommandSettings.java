package commands.concretecommands;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.settingswindow.CancelButton;
import objects.settingswindow.RestartButton;
import objects.settingswindow.SettingsWindow;
import trigger.DungeonTrigger;
import trigger.ITrigger;
import trigger.RemoveObjectTrigger;
import trigger.RestartGameTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class TriggerCommandSettings implements ICommand{

	private Map<Class<?>, ITrigger> mappedTriggers = new HashMap<Class<?>, ITrigger>(10);
	
	public TriggerCommandSettings(){
		mappedTriggers.put(CancelButton.class, new RemoveObjectTrigger(SettingsWindow.getinstance()));
		mappedTriggers.put(RestartButton.class, new RestartGameTrigger("."+File.separatorChar+"rooms"+File.separatorChar+"testdungeon.dgn"));
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		ITrigger answer = mappedTriggers.get(objectClicked.getClass());
		if(answer != null){
			context.addTrigger(answer);
		}
		
	}

}
