package commands.concretecommands;

import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class LookAtCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		System.out.println("You are looking at the: " + objectClicked);
		context.setMessage("You are\n looking at the: " + objectClicked);
	}

}
