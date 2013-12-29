package commands.concretecommands;

import io.IIOHandler;
import objects.IGameObject;
import objects.hudbar.HudBar;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class SwitchToHudState implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		context.setInternalState(IIOHandler.InternalStates.HUD_STATE);
		context.addNewObject(HudBar.getInstance());
		

	}

}
