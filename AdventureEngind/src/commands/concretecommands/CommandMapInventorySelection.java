package commands.concretecommands;

import io.IIOHandler;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.settingswindow.CancelButton;
import objects.settingswindow.SaveButton;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class CommandMapInventorySelection implements ICommand {

	private Map<Class<?>, IIOHandler.InternalStates> mapStates = new HashMap<Class<?>, IIOHandler.InternalStates>(10);
	
	public CommandMapInventorySelection(){
		mapStates.put(SaveButton.class, IIOHandler.InternalStates.PREVIOUS_STATE);
		mapStates.put(CancelButton.class, IIOHandler.InternalStates.PREVIOUS_STATE);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		if(objectClicked == null){
			return;
		}
		IIOHandler.InternalStates answer = mapStates.get(objectClicked.getClass());
		if(answer != null){
			context.setInternalState(answer);
		}

	}

}
