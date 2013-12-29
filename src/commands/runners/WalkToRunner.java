package commands.runners;

import commands.concretecommands.UpdateToWalkCommand;
import commands.concretecommands.WalkToClickCommand;

public class WalkToRunner extends ConcreteRunner {
	public WalkToRunner(){
		super.addCommand(new WalkToClickCommand());
	}
}
