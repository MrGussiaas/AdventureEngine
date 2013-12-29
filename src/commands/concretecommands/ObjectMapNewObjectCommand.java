package commands.concretecommands;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.IUIFactory;
import objects.hudbar.InventoryIcon;
import objects.hudbar.StatusIcon;
import objects.inventorywindow.InventoryWindow;
import objects.settingswindow.SettingsWindow;
import objects.uifactories.UIFactoryRegistry;
import commands.ICommand;
import commands.IPostProcessCommandContext;

public class ObjectMapNewObjectCommand implements ICommand {

	private Map<Class<?>, IGameObject> objectMap = new HashMap<Class<?>, IGameObject>(10);
	
	public ObjectMapNewObjectCommand(){
		objectMap.put(InventoryIcon.class, InventoryWindow.getInstance());
		objectMap.put(StatusIcon.class, SettingsWindow.getinstance());
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		IGameObject answer = objectMap.get(objectClicked.getClass());
		
		if(answer != null){
			IUIFactory factory = UIFactoryRegistry.getInstance().getFactory(answer.getClass());
			factory.initUIComponent((IInterfaceableObject) answer, avatarObject);
			context.addNewObject(answer);
		}

	}

}
