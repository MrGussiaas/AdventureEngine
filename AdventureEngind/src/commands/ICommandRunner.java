package commands;

import java.util.Iterator;

public interface ICommandRunner {
	public int getCommandCount();
	public ICommand getCommand(int index);
	public void addCommand(ICommand command);
	public void removeCommand(int index);
	public Iterator<ICommand> runCommands();
}
