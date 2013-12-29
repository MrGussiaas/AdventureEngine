package commands.concretecommands;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import commands.ICommand;
import commands.IPostProcessCommandContext;



public class ObjectMapCommandSettings implements ICommand{

	private Map<Class<?>, IGameObject> objects = new HashMap<Class<?>, IGameObject>(10); 
	
	public ObjectMapCommandSettings(){
		
	}
	
	public void runCommand(IPostProcessCommandContext context,
			IGameObject objectClicked, IGameObject avatarObject, int x, int y) {
		IGameObject object = objects.get(objectClicked.getClass());
		if(object != null){
			context.addNewObject(object);
		}
		
	}

}
