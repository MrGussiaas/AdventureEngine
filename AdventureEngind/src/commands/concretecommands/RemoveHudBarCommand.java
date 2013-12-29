package commands.concretecommands;

import objects.IGameObject;
import objects.hudbar.HudBar;
import trigger.RemoveObjectTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class RemoveHudBarCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		context.addTrigger(new RemoveObjectTrigger(HudBar.getInstance()));

	}

}
