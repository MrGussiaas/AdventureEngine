package commands.runners;

import commands.concretecommands.UpdateToSeeCommand;

public class SwitchSeeRunner extends ConcreteRunner {
	public SwitchSeeRunner(){
		super.addCommand(new UpdateToSeeCommand());
	}
}
