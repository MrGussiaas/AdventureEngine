package commands;

import io.LeftClickEvent;
import io.LeftPressEvent;
import io.MouseMovedEvent;

import java.util.HashMap;
import java.util.Map;

import commands.uihandlers.IUIEventHandler;
import commands.uihandlers.LeftClickHandler;
import commands.uihandlers.MouseMoveHandler;

public class ScriptEventRegistry {
	private Map<Class<?>, IUIEventHandler> eventMap = new HashMap<Class<?>, IUIEventHandler>(10);
	
	private static ScriptEventRegistry instance;
	
	public static ScriptEventRegistry getInstance(){
		if(instance == null){
			instance = new ScriptEventRegistry();
		}
		return instance;
	}
	
	public IUIEventHandler getEventHandler(Class<?> clazz){
		return eventMap.get(clazz);
	}
	
	private ScriptEventRegistry(){
		eventMap.put(LeftPressEvent.class, new LeftClickHandler());
		eventMap.put(MouseMovedEvent.class, new MouseMoveHandler());
	}
}
