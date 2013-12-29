package commands.concretecommands;

import io.IIOHandler.InternalStates;
import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class UpdateToWaitCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		System.out.println("Updating to Wait");
		context.setInternalState(InternalStates.WAIT_STATE);

	}

}
