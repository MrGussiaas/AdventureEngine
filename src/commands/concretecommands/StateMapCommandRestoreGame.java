package commands.concretecommands;

import java.util.HashMap;
import java.util.Map;

import io.IIOHandler;
import objects.IGameObject;
import objects.settingswindow.CancelButton;
import objects.settingswindow.RestoreButton;
import objects.settingswindow.SaveButton;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class StateMapCommandRestoreGame implements ICommand {

	private Map<Class<?>, IIOHandler.InternalStates> mappedStates = new HashMap<Class<?>, IIOHandler.InternalStates>(10);
	
	public StateMapCommandRestoreGame(){
		mappedStates.put(CancelButton.class, IIOHandler.InternalStates.PREVIOUS_STATE);
		mappedStates.put(RestoreButton.class, IIOHandler.InternalStates.WALK_STATE);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		IIOHandler.InternalStates answer = mappedStates.get(objectClicked.getClass());
		if(answer != null){
			context.setInternalState(answer);
		}

	}

}
