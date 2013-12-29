package commands.runners;

import commands.concretecommands.UpdateToWalkCommand;

public class SwitchWalkRunner extends ConcreteRunner {
	public SwitchWalkRunner(){
		super.addCommand(new UpdateToWalkCommand());
	}
}
