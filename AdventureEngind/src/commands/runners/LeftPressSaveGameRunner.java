package commands.runners;

import commands.concretecommands.QuitGameCommand;
import commands.concretecommands.SendMouseUpCommand;
import commands.concretecommands.StateMapCommandSaveGame;
import commands.concretecommands.TriggerMapCommandSaveGame;

public class LeftPressSaveGameRunner extends ConcreteRunner {
	public LeftPressSaveGameRunner(){
		addCommand(new SendMouseUpCommand());
		addCommand(new StateMapCommandSaveGame());
		addCommand(new TriggerMapCommandSaveGame());
		
		
	}
}
