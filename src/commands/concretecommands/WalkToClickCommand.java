package commands.concretecommands;

import java.awt.Point;

import objects.IGameObject;
import trigger.concreteDescriptors.WalkToTrigger;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class WalkToClickCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		//System.out.println("must walk to x : " + x + " y : " + y );

		context.addTrigger(new WalkToTrigger(x, y));
	}

}
