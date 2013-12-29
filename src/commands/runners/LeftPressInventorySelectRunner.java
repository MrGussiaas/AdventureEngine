package commands.runners;

import commands.concretecommands.CommandMapInventorySelection;
import commands.concretecommands.InventorySelectTriggerMapCommand;
import commands.concretecommands.SendMouseUpCommand;

public class LeftPressInventorySelectRunner extends ConcreteRunner {
	public LeftPressInventorySelectRunner(){
		addCommand(new SendMouseUpCommand());
		addCommand(new CommandMapInventorySelection());
		addCommand(new InventorySelectTriggerMapCommand());
	}
}
