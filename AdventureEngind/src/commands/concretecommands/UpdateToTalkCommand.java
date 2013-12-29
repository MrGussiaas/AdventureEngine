package commands.concretecommands;

import io.IIOHandler.InternalStates;
import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class UpdateToTalkCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		System.out.println("Updating to Talk");
		context.setInternalState(InternalStates.TALK_STATE);

	}

}
