package commands.runners;

import commands.concretecommands.SwitchObjectUseCommand;

public class SwitchObjectUseRunner extends ConcreteRunner {
	public SwitchObjectUseRunner(){
		super.addCommand(new SwitchObjectUseCommand());
	}
}
