package commands.concretecommands;

import io.IIOHandler;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.hudbar.ActionButton;
import objects.hudbar.CurrentObjectIcon;
import objects.hudbar.HudBar;
import objects.hudbar.LookIcon;
import objects.hudbar.TalkIcon;
import objects.hudbar.WalkButton;
import trigger.ITrigger;
import trigger.RemoveObjectTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class TriggerCommandHudBar implements ICommand {

	private Map<Class<?>, ITrigger> triggerMap = new HashMap<Class<?>, ITrigger>(10);
	
	public TriggerCommandHudBar(){
		triggerMap.put(ActionButton.class, new RemoveObjectTrigger(HudBar.getInstance()));
		triggerMap.put(LookIcon.class, new RemoveObjectTrigger(HudBar.getInstance()));
		triggerMap.put(TalkIcon.class, new RemoveObjectTrigger(HudBar.getInstance()));
		triggerMap.put(WalkButton.class, new RemoveObjectTrigger(HudBar.getInstance()));
		triggerMap.put(CurrentObjectIcon.class, new RemoveObjectTrigger(HudBar.getInstance()));
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		ITrigger answer = triggerMap.get(objectClicked.getClass());
		if(answer != null){
			context.addTrigger(answer);
		}

	}

}
