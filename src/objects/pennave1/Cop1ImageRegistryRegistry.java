package objects.pennave1;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;

public class Cop1ImageRegistryRegistry {
	private static Cop1ImageRegistryRegistry instance;
	private Cop1ImageRegistry defaultRegistry = Cop1ImageRegistry.getInstance();
	
	private Map<IGameObject.InternalObjectStates, IImageRegistry> registries = new HashMap<IGameObject.InternalObjectStates, IImageRegistry>(10);
	
	public static Cop1ImageRegistryRegistry getInstance(){
		if(instance == null){
			instance = new Cop1ImageRegistryRegistry();
		}
		return instance;
	}
	
	private Cop1ImageRegistryRegistry(){
		registries.put(IGameObject.InternalObjectStates.DEFAULT_STATE, defaultRegistry);
		registries.put(IGameObject.InternalObjectStates.FALLING_IN_LOVE, Cop1LoveImageRegistry.getInstance());
	}
	
	public IImageRegistry getRegistry(IGameObject.InternalObjectStates state){
		IImageRegistry answer = registries.get(state);
		if(answer == null){
			return defaultRegistry;
		}
		return answer;
	}
}
