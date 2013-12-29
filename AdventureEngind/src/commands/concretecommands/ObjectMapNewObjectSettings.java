package commands.concretecommands;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.restoregamedialog.RestoreGameDialog;
import objects.savegamedialoge.SaveGameDialogue;
import objects.settingswindow.RestoreButton;
import objects.settingswindow.SaveButton;
import objects.uifactories.UIFactoryRegistry;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class ObjectMapNewObjectSettings implements ICommand {

	private Map<Class<?>, IGameObject> mappedObjects = new HashMap<Class<?>, IGameObject>(10);
	
	public ObjectMapNewObjectSettings(){
		mappedObjects.put(SaveButton.class, SaveGameDialogue.getInstance());
		mappedObjects.put(RestoreButton.class, RestoreGameDialog.getInstance());
	}
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		if(objectClicked == null){
			return;
		}

		IGameObject answer = mappedObjects.get(objectClicked.getClass());
		if(answer != null){
			UIFactoryRegistry.getInstance().getFactory(answer.getClass()).initUIComponent((IInterfaceableObject) answer);
			context.addNewObject(answer);
		}

	}

}
