package trigger.processors;

import java.util.HashMap;
import java.util.Map;

import trigger.BottomRoomTrigger;
import trigger.DungeonRoomTrigger;
import trigger.DungeonTrigger;
import trigger.LeftRoomTrigger;
import trigger.RestoreGameTrigger;
import trigger.RightRoomTrigger;
import trigger.SaveGameTrigger;
import trigger.TopRoomTrigger;

public class DungeonProcessors {
	private static DungeonProcessors instance;
	
	private Map<Class<?>, IDungeonProcessor> processors = new HashMap<Class<?>, IDungeonProcessor>(10);
	
	public static DungeonProcessors getInstance(){
		if(instance == null){
			instance = new DungeonProcessors();
		}
		return instance;
	}
	
	private DungeonProcessors(){
		processors.put(LeftRoomTrigger.class, new ProcessLeftTrigger());
		processors.put(BottomRoomTrigger.class, new BottomProcessor());
		processors.put(RightRoomTrigger.class, new RightProcessor());
		processors.put(TopRoomTrigger.class, new ProcessTopTrigger());
		processors.put(SaveGameTrigger.class, new SaveGameProcessor());		
		processors.put(DungeonTrigger.class, new ProcessDungeonTrigger());
		processors.put(DungeonRoomTrigger.class, new ProcessDungeonTrigger());
	}
	
	public IDungeonProcessor getProcessor(Class<?> clazz){
		return processors.get(clazz);
	}
}
