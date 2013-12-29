package objects.pennave1;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;

public class Cop2ImageRegistryRegistry {
	private static Cop2ImageRegistryRegistry instance;
	private Map<IGameObject.InternalObjectStates, IImageRegistry> registries = new HashMap<IGameObject.InternalObjectStates, IImageRegistry>(10);
	private IImageRegistry defaultRegistry = Cop2ImageRegistry.getInstance();
	public static Cop2ImageRegistryRegistry getInstance(){
		if(instance == null){
			instance = new Cop2ImageRegistryRegistry();
		}
		return instance;
	}
	
	private Cop2ImageRegistryRegistry(){
		registries.put(IGameObject.InternalObjectStates.DEFAULT_STATE, Cop2ImageRegistry.getInstance());
		registries.put(IGameObject.InternalObjectStates.SHOOTING_A_GUN, Cop2ShootingImageRegistry.getInstance());
	}
	
	public IImageRegistry getRegistry(IGameObject.InternalObjectStates state){
		IImageRegistry answer = registries.get(state);
		if(answer == null){
			return defaultRegistry;
		}
		return answer;
	}
}
