package commands;

import objects.IGameObject;

public interface ICommand {
	public void runCommand(IPostProcessCommandContext context, IGameObject objectClicked, IGameObject avatarObject, int x, int y);
}
