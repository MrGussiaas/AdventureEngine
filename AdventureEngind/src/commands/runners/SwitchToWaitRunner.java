package commands.runners;

import commands.concretecommands.UpdateToTalkCommand;
import commands.concretecommands.UpdateToWaitCommand;

public class SwitchToWaitRunner extends ConcreteRunner {
	public SwitchToWaitRunner(){
		super.addCommand(new UpdateToWaitCommand());
	}
}
