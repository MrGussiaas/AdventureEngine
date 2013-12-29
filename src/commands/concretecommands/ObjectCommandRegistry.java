package commands.concretecommands;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.IGameObject.InternalObjectStates;
import objects.oncomingtraffic.JerkyTruck;
import testgame.AvatarObject;

public class ObjectCommandRegistry {
	private static ObjectCommandRegistry instance;
	
	private ObjectCommandRegistry(){
		commands.put(new ICCommandKey(AvatarObject.class, InternalObjectStates.WALKING_STATE), new WalkToCommand());
		commands.put(new ICCommandKey(AvatarObject.class, InternalObjectStates.HIT_BY_A_TRUCK_STATE), new HitByTruckProcessor());
		commands.put(new ICCommandKey(JerkyTruck.class, InternalObjectStates.WALKING_STATE), new WalkToCommand());
	}
	private Map<ICCommandKey, IObjectCommand> commands = new HashMap<ICCommandKey, IObjectCommand>(10);
	
	public static ObjectCommandRegistry getInstance(){
		if(instance == null){
			instance = new ObjectCommandRegistry();
		}
		return instance;
	}
	
	private class ICCommandKey{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ICCommandKey other = (ICCommandKey) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (clazz == null) {
				if (other.clazz != null)
					return false;
			} else if (!clazz.equals(other.clazz))
				return false;
			if (state != other.state)
				return false;
			return true;
		}

		private Class<?> clazz;
		private IGameObject.InternalObjectStates state;
		
		public ICCommandKey(Class<?> clazz, IGameObject.InternalObjectStates state){
			this.clazz = clazz;
			this.state = state;
		}

		private ObjectCommandRegistry getOuterType() {
			return ObjectCommandRegistry.this;
		}
	}
	
	public IObjectCommand getCommand(IGameObject object, IGameObject.InternalObjectStates state){
		return commands.get(new ICCommandKey(object.getClass(), state));
	}
}
