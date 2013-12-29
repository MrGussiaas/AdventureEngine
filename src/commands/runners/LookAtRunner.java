package commands.runners;

import java.util.Iterator;

import commands.ICommand;
import commands.ICommandRunner;
import commands.concretecommands.LookAtCommand;
import commands.concretecommands.UpdateToWaitCommand;

public class LookAtRunner extends ConcreteRunner{

	public LookAtRunner(){
		super.addCommand(new UpdateToWaitCommand());
		super.addCommand(new LookAtCommand());
	}

}
