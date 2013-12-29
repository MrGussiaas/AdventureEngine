package trigger.dungeonloaders;

import java.util.HashMap;
import java.util.Map;

import trigger.DungeonRoomTrigger;
import trigger.DungeonTrigger;
import trigger.RestartGameTrigger;
import trigger.RestoreGameTrigger;

public class DungeonLoaderRegistry {
	private Map<Class<?>, IDungeonLoaderProcessor> registry = new HashMap<Class<?>, IDungeonLoaderProcessor>(10);
	
	private static DungeonLoaderRegistry instance;
	
	public static DungeonLoaderRegistry getInstance(){
		if(instance == null){
			instance = new DungeonLoaderRegistry();
		}
		return instance;
	}
	
	private DungeonLoaderRegistry(){
		registry.put(RestoreGameTrigger.class, new RestoreDungeonLoader());
		registry.put(DungeonTrigger.class, new NewDungeonLoader());
		registry.put(DungeonRoomTrigger.class, new DungeonRoomLoader());
		registry.put(RestartGameTrigger.class, new RestartGameLoader());
	}
	
	
	
	public IDungeonLoaderProcessor getProcessor(Class<?> clazz){
		return registry.get(clazz);
	}
}
