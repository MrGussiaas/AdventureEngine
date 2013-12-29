package commands.runners;

import commands.concretecommands.PopPreviousCommand;
import commands.concretecommands.RemoveHudBarCommand;
import commands.concretecommands.UpdateToWalkCommand;

public class DropHudRunner extends ConcreteRunner {
	public DropHudRunner(){
		addCommand(new RemoveHudBarCommand());
		addCommand(new PopPreviousCommand());
	}
}
