package commands.concretecommands;

import objects.IGameObject;

public interface IObjectCommand {
	public void executeCommand(IObjectCommandContext context, IGameObject gameObject);
}
