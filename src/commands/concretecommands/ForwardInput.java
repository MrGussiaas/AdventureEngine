package commands.concretecommands;

import javax.swing.JOptionPane;

import objects.IGameObject;
import objects.IInterfaceableObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class ForwardInput implements ICommand {

	@Override
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		if(objectClicked != null && objectClicked instanceof IInterfaceableObject){
			IInterfaceableObject castedObject = (IInterfaceableObject) objectClicked;
			castedObject.mouseLeft();
		}

	}

}
