package commands.concretecommands;

import io.IIOHandler;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.settingswindow.CancelButton;
import objects.settingswindow.RestartButton;
import objects.settingswindow.RestoreButton;
import objects.settingswindow.SaveButton;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class CommandMapCommandSettings implements ICommand {

	private Map<Class<?>, IIOHandler.InternalStates > states = new HashMap<Class<?>, IIOHandler.InternalStates>(10);
	
	public CommandMapCommandSettings(){
		states.put(CancelButton.class, IIOHandler.InternalStates.PREVIOUS_STATE);
		states.put(SaveButton.class, IIOHandler.InternalStates.SAVE_GAME_STATE);
		states.put(RestoreButton.class, IIOHandler.InternalStates.RESTORE_GAME_STATE);
		states.put(RestartButton.class, IIOHandler.InternalStates.LOOK_STATE);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		if(objectClicked == null){
			return;
		}
		IIOHandler.InternalStates answer = states.get(objectClicked.getClass());
		if(answer != null){
			context.setInternalState(answer);
		}

	}

}
