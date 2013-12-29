package commands.concretecommands;

import io.IIOHandler.InternalStates;
import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class UpdateToSeeCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		System.out.println("updating state to See");
		context.setInternalState(InternalStates.LOOK_STATE);
		context.setMessage(null);

	}

}
