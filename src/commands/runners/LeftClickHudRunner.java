package commands.runners;

import commands.concretecommands.ObjectMapNewObjectCommand;
import commands.concretecommands.ObjectMapStateCommand;
import commands.concretecommands.RemoveHudBarCommand;
import commands.concretecommands.SendMouseUpCommand;
import commands.concretecommands.TriggerCommandHudBar;
import commands.concretecommands.UpdateToSeeCommand;

public class LeftClickHudRunner extends ConcreteRunner {
	public LeftClickHudRunner(){
		super.addCommand(new UpdateToSeeCommand());
		super.addCommand(new SendMouseUpCommand());
		super.addCommand(new ObjectMapStateCommand());
		super.addCommand(new ObjectMapNewObjectCommand());
		super.addCommand(new TriggerCommandHudBar());
	}
}
