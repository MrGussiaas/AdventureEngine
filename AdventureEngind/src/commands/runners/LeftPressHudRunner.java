package commands.runners;

import java.util.Iterator;

import commands.ICommand;
import commands.ICommandRunner;
import commands.concretecommands.ForwardInput;

public class LeftPressHudRunner extends ConcreteRunner {
	public LeftPressHudRunner(){
		super.addCommand(new ForwardInput());
	}


}
