package commands;

import io.IIOHandler.InternalStates;
import io.IInputEvent;
import io.KeyTypedEvent;
import io.LeftClickEvent;
import io.LeftPressEvent;
import io.MouseEnteredHudAreaEvent;
import io.MouseExitedHudAreaEvent;
import io.RightClickEvent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import commands.concretecommands.UpdateToSeeCommand;
import commands.concretecommands.WalkToClickCommand;
import commands.runners.BringUpHudRunner;
import commands.runners.ConcreteRunner;
import commands.runners.DropHudRunner;
import commands.runners.LeftClickHudRunner;
import commands.runners.LeftPressHudRunner;
import commands.runners.LeftPressInventorySelectRunner;
import commands.runners.LeftPressRestoreGameRunner;
import commands.runners.LeftPressSaveGameRunner;
import commands.runners.LookAtRunner;
import commands.runners.SettingsLeftClickRunner;
import commands.runners.SwitchActionRunner;
import commands.runners.SwitchObjectUseRunner;
import commands.runners.SwitchSeeRunner;
import commands.runners.SwitchTalkRunner;
import commands.runners.SwitchWalkRunner;
import commands.runners.WalkToRunner;

public class CommandRegistry {
	private static CommandRegistry instance ;
	private Map<ICRegistryKey, ICommandRunner> commandMap = new HashMap<ICRegistryKey, ICommandRunner>(10);
	private static ICommandRunner DEFAULT_RUNNER = new ConcreteRunner();
	private class ICRegistryKey{
		private Class<?> eventType;
		private InternalStates internalState;
		
		public ICRegistryKey(Class<?> eventType, InternalStates internalState){
			this.eventType = eventType;
			this.internalState = internalState;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((eventType == null) ? 0 : eventType.hashCode());
			result = prime * result
					+ ((internalState == null) ? 0 : internalState.hashCode());
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
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (eventType == null) {
				if (other.eventType != null)
					return false;
			} else if (!eventType.equals(other.eventType))
				return false;
			if (internalState != other.internalState)
				return false;
			return true;
		}

		private CommandRegistry getOuterType() {
			return CommandRegistry.this;
		}



	}
	
	private CommandRegistry(){
		
		commandMap.put(new ICRegistryKey(RightClickEvent.class, InternalStates.DEFAULT_STATE ), new SwitchWalkRunner());
		commandMap.put(new ICRegistryKey(RightClickEvent.class, InternalStates.WALK_STATE ), new SwitchTalkRunner());
		commandMap.put(new ICRegistryKey(RightClickEvent.class, InternalStates.TALK_STATE ), new SwitchSeeRunner());
		commandMap.put(new ICRegistryKey(RightClickEvent.class, InternalStates.LOOK_STATE ), new SwitchActionRunner());
		commandMap.put(new ICRegistryKey(RightClickEvent.class, InternalStates.ACTION_STATE ), new SwitchObjectUseRunner());
		commandMap.put(new ICRegistryKey(RightClickEvent.class, InternalStates.OBJECT_USE_STATE), new SwitchWalkRunner());
		
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.LOOK_STATE ), new LookAtRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.WAIT_STATE ), new SwitchSeeRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.WALK_STATE ), new WalkToRunner());
	
		commandMap.put(new ICRegistryKey(MouseEnteredHudAreaEvent.class, InternalStates.LOOK_STATE), new BringUpHudRunner());
		commandMap.put(new ICRegistryKey(MouseEnteredHudAreaEvent.class, InternalStates.WALK_STATE), new BringUpHudRunner());
		commandMap.put(new ICRegistryKey(MouseEnteredHudAreaEvent.class, InternalStates.ACTION_STATE), new BringUpHudRunner());
		commandMap.put(new ICRegistryKey(MouseEnteredHudAreaEvent.class, InternalStates.TALK_STATE), new BringUpHudRunner());
		commandMap.put(new ICRegistryKey(MouseEnteredHudAreaEvent.class, InternalStates.OBJECT_USE_STATE), new BringUpHudRunner());
		
		commandMap.put(new ICRegistryKey(MouseExitedHudAreaEvent.class, InternalStates.HUD_STATE), new DropHudRunner());
		
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.HUD_STATE), new LeftPressHudRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.HUD_STATE), new LeftClickHudRunner());
	
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.SETTINGS_STATE), new LeftPressHudRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.SETTINGS_STATE), new SettingsLeftClickRunner());
		
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.SAVE_GAME_STATE), new LeftPressHudRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.SAVE_GAME_STATE), new LeftPressSaveGameRunner());
		
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.RESTORE_GAME_STATE), new LeftPressHudRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.RESTORE_GAME_STATE), new LeftPressRestoreGameRunner());
		
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.SELECT_INVENTORY_STATE), new LeftPressHudRunner());
		commandMap.put(new ICRegistryKey(LeftClickEvent.class, InternalStates.SELECT_INVENTORY_STATE), new LeftPressInventorySelectRunner());
		
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.GAME_OVER_STATE), new LeftPressHudRunner());
		commandMap.put(new ICRegistryKey(LeftPressEvent.class, InternalStates.GAME_OVER_STATE), new SettingsLeftClickRunner());
	}
	
	
	public static CommandRegistry getInstance(){
		if(instance == null){
			instance = new CommandRegistry();
		}
		return instance;
	}
	
	public Iterator<ICommand> getCommands(IInputEvent event, InternalStates state){
		ICommandRunner answer = commandMap.get(new ICRegistryKey(event.getClass(), state));
		if(answer == null){
			return DEFAULT_RUNNER.runCommands();
		}
		return answer.runCommands();
	}
	
}
