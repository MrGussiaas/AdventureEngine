package commands.runners;

import commands.concretecommands.UpdateToActionCommand;

public class SwitchActionRunner extends ConcreteRunner {
	public SwitchActionRunner(){
		super.addCommand(new UpdateToActionCommand());
	}
}
