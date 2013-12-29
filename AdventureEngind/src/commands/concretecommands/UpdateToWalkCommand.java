package commands.concretecommands;

import io.IIOHandler.InternalStates;
import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class UpdateToWalkCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		System.out.println("updating game state to walk");
		context.setInternalState(InternalStates.WALK_STATE);
		
	}

}
