package commands.runners;

import commands.concretecommands.SendMouseUpCommand;
import commands.concretecommands.StateMapCommandRestoreGame;
import commands.concretecommands.StateMapCommandSaveGame;
import commands.concretecommands.TriggerMapCommandRestoreGame;
import commands.concretecommands.TriggerMapCommandSaveGame;

public class LeftPressRestoreGameRunner extends ConcreteRunner {
	public LeftPressRestoreGameRunner(){
		addCommand(new SendMouseUpCommand());
		addCommand(new StateMapCommandRestoreGame());
		addCommand(new TriggerMapCommandRestoreGame());
	}
}
