package commands.runners;

import commands.concretecommands.SwitchToHudState;

public class BringUpHudRunner extends ConcreteRunner {
	public BringUpHudRunner(){
		addCommand(new SwitchToHudState());
	}
}
