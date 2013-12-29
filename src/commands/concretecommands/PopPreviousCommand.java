package commands.concretecommands;

import io.IIOHandler;
import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class PopPreviousCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		context.setInternalState(IIOHandler.InternalStates.PREVIOUS_STATE);

	}

}
