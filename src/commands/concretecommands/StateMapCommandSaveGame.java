package commands.concretecommands;

import io.IIOHandler;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.settingswindow.CancelButton;
import objects.settingswindow.SaveButton;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class StateMapCommandSaveGame implements ICommand {

	private Map<Class<?>, IIOHandler.InternalStates> mappedStates = new HashMap<Class<?>, IIOHandler.InternalStates>(10);
	
	public StateMapCommandSaveGame(){
		mappedStates.put(CancelButton.class, IIOHandler.InternalStates.PREVIOUS_STATE);
		mappedStates.put(SaveButton.class, IIOHandler.InternalStates.PREVIOUS_STATE);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		IIOHandler.InternalStates answer = mappedStates.get(objectClicked.getClass());
		if(answer != null){
			context.setInternalState(answer);
		}

	}

}
