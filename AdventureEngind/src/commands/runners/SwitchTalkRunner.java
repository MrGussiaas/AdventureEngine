package commands.runners;

import commands.concretecommands.UpdateToTalkCommand;

public class SwitchTalkRunner extends ConcreteRunner {
	public SwitchTalkRunner(){
		super.addCommand(new UpdateToTalkCommand());
	}
}
