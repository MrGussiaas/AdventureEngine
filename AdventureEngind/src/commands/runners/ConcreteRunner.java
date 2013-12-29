package commands.runners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import commands.ICommand;
import commands.ICommandRunner;

public class ConcreteRunner implements ICommandRunner {
	
	private List<ICommand> commands = new ArrayList<ICommand>(10);
	
	public int getCommandCount() {
		return commands.size();
	}

	public ICommand getCommand(int index) {
		return commands.get(index);
	}

	
	public void addCommand(ICommand command) {
		commands.add(command);

	}

	@Override
	public void removeCommand(int index) {
		commands.remove(index);

	}

	@Override
	public Iterator<ICommand> runCommands() {
		return commands.iterator();
	}

}
