package commands;

import io.RefreshEvent;
import io.RightClickEvent;

import java.util.HashMap;
import java.util.Map;

public class IOCommandRegistry {
	private Map<Class<?>, IOCommand> commandMap = new HashMap<Class<?>, IOCommand>(10);
	
	private static IOCommandRegistry instance;
	
	public static IOCommandRegistry getInstance(){
		if(instance == null){
			instance = new IOCommandRegistry();
		}
		return instance;
	}
	
	private IOCommandRegistry(){
		commandMap.put(RefreshEvent.class, new RefreshCommand());
		//commandMap.put(RightClickEvent.class, new ChangeCursorCommand());
	}
	
	public IOCommand getCommand(Class<?> clazz){
		return commandMap.get(clazz);
	}
	
	
}
