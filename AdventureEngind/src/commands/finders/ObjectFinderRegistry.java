package commands.finders;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import ui.IGameModel;

import commands.IObjectFinder;

import io.IIOHandler.InternalStates;
import io.IInputEvent;
import io.KeyTypedEvent;
import io.LeftClickEvent;
import io.LeftPressEvent;
import io.MouseMovedEvent;
import io.RefreshEvent;
import io.ScreenLoadedEvent;

public class ObjectFinderRegistry {
	private static ObjectFinderRegistry instance;
	private static Map<ICRegistryKey, IObjectFinder> finders = new HashMap<ICRegistryKey, IObjectFinder>(10);
	public static ObjectFinderRegistry getInstance(){
		if(instance == null){
			instance = new ObjectFinderRegistry();
		}
		return instance;
	}
	private static IObjectFinder DEFAULT_FINDER = new IObjectFinder(){
		public IGameObject findObject(IGameModel model, IInputEvent event) {
			return null;
		}

		@Override
		public int getXClick() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getYClick() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void setYClick(int yClick) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setXClick(int xClick) {
			// TODO Auto-generated method stub
			
		}
		
	};
	private static class ICRegistryKey{
		private InternalStates state;
		private Class<?> clazz;
		
		public ICRegistryKey(InternalStates state, Class<?> clazz){
			this.state = state;
			this.clazz = clazz;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
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
			ICRegistryKey other = (ICRegistryKey) obj;
			if (clazz == null) {
				if (other.clazz != null)
					return false;
			} else if (!clazz.equals(other.clazz))
				return false;
			if (state != other.state)
				return false;
			return true;
		}
	}
	
	private ObjectFinderRegistry(){
		finders.put(new ICRegistryKey(InternalStates.ACTION_STATE, LeftClickEvent.class), new LeftClickFinder());
		finders.put(new ICRegistryKey(InternalStates.WALK_STATE, LeftClickEvent.class), new LeftClickFinder());
		finders.put(new ICRegistryKey(InternalStates.LOOK_STATE, LeftClickEvent.class), new LeftClickFinder());
		finders.put(new ICRegistryKey(InternalStates.TALK_STATE, LeftClickEvent.class), new LeftClickFinder());
		
		finders.put(new ICRegistryKey(InternalStates.ACTION_STATE, RefreshEvent.class), new RefreshFinder());
		finders.put(new ICRegistryKey(InternalStates.WALK_STATE, RefreshEvent.class), new RefreshFinder());
		finders.put(new ICRegistryKey(InternalStates.LOOK_STATE, RefreshEvent.class), new RefreshFinder());
		finders.put(new ICRegistryKey(InternalStates.TALK_STATE, RefreshEvent.class), new RefreshFinder());
		
		finders.put(new ICRegistryKey(InternalStates.HUD_STATE, LeftPressEvent.class), new InterfaceableFinder());
		finders.put(new ICRegistryKey(InternalStates.HUD_STATE, LeftClickEvent.class), new InterfaceableFinder());
	
		finders.put(new ICRegistryKey(InternalStates.SETTINGS_STATE, LeftPressEvent.class), new InterfaceableFinder());
		finders.put(new ICRegistryKey(InternalStates.SETTINGS_STATE, LeftClickEvent.class), new InterfaceableFinder());
		
		finders.put(new ICRegistryKey(InternalStates.SAVE_GAME_STATE, LeftClickEvent.class), new LeftClickFinderSaveState());
		finders.put(new ICRegistryKey(InternalStates.SAVE_GAME_STATE, LeftPressEvent.class), new LeftClickFinderSaveState());
		
		finders.put(new ICRegistryKey(InternalStates.SAVE_GAME_STATE, KeyTypedEvent.class), new KeyTypedFinderSaveState());
	
		finders.put(new ICRegistryKey(InternalStates.RESTORE_GAME_STATE, LeftClickEvent.class), new LeftClickFinderRestoreState());
		finders.put(new ICRegistryKey(InternalStates.RESTORE_GAME_STATE, LeftPressEvent.class), new LeftClickFinderRestoreState());
		
		finders.put(new ICRegistryKey(InternalStates.SELECT_INVENTORY_STATE, LeftClickEvent.class), new LeftClickFinderInventoryState());
		finders.put(new ICRegistryKey(InternalStates.SELECT_INVENTORY_STATE, LeftPressEvent.class), new LeftClickFinderInventoryState());
		
		finders.put(new ICRegistryKey(InternalStates.ACTION_STATE, ScreenLoadedEvent.class), new ScreenLoadedFinder());
		finders.put(new ICRegistryKey(InternalStates.WALK_STATE, ScreenLoadedEvent.class), new ScreenLoadedFinder());
		finders.put(new ICRegistryKey(InternalStates.LOOK_STATE, ScreenLoadedEvent.class), new ScreenLoadedFinder());
		finders.put(new ICRegistryKey(InternalStates.TALK_STATE, ScreenLoadedEvent.class), new ScreenLoadedFinder());
		
		finders.put(new ICRegistryKey(InternalStates.GAME_OVER_STATE, LeftPressEvent.class), new InterfaceableFinder());
		finders.put(new ICRegistryKey(InternalStates.GAME_OVER_STATE, LeftClickEvent.class), new InterfaceableFinder());
		
		finders.put(new ICRegistryKey(InternalStates.SCRIPT_ONLY, LeftPressEvent.class), new InterfaceableFinder());
		finders.put(new ICRegistryKey(InternalStates.SCRIPT_ONLY, MouseMovedEvent.class), new InterfaceableFinderMouseMoved());
		
		//finders.put(new ICRegistryKey(InternalStates.RESTORE_GAME_STATE, KeyTypedEvent.class), new KeyTypedFinderRestoreState());
		
	}
	
	public IObjectFinder getFinder(InternalStates state, Class<?> clazz){
		IObjectFinder answer = finders.get(new ICRegistryKey(state, clazz));
		if(answer == null){
			answer = DEFAULT_FINDER;
		}
		return answer;
	}
}
