package commands.concretecommands;

import objects.IGameObject;
import objects.settingswindow.QuitButton;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class QuitGameCommand implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		if(objectClicked.getClass() == QuitButton.class){
			System.exit(0);
		}

	}

}
