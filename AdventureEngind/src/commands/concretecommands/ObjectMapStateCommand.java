package commands.concretecommands;

import io.IIOHandler;
import io.IIOHandler.InternalStates;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.hudbar.ActionButton;
import objects.hudbar.CurrentObjectIcon;
import objects.hudbar.HudBar;
import objects.hudbar.InventoryIcon;
import objects.hudbar.LookIcon;
import objects.hudbar.StatusIcon;
import objects.hudbar.TalkIcon;
import objects.hudbar.WalkButton;
import trigger.RemoveObjectTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class ObjectMapStateCommand implements ICommand {

	private Map<Class<?>, IIOHandler.InternalStates> classMap = new HashMap<Class<?>, IIOHandler.InternalStates>(10);
	
	public ObjectMapStateCommand(){
		classMap.put(ActionButton.class, IIOHandler.InternalStates.ACTION_STATE);
		classMap.put(LookIcon.class, IIOHandler.InternalStates.LOOK_STATE);
		classMap.put(TalkIcon.class, IIOHandler.InternalStates.TALK_STATE);
		classMap.put(WalkButton.class, IIOHandler.InternalStates.WALK_STATE);
		classMap.put(StatusIcon.class, IIOHandler.InternalStates.SETTINGS_STATE);
		classMap.put(CurrentObjectIcon.class, IIOHandler.InternalStates.OBJECT_USE_STATE);
		classMap.put(InventoryIcon.class, IIOHandler.InternalStates.SELECT_INVENTORY_STATE);
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		InternalStates answer = classMap.get(objectClicked.getClass());
		if(answer != null){
			context.setInternalState(answer);
		}


	}

}
