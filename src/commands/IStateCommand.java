package commands;

import io.IIOHandler;

public interface IStateCommand {
	public void updateInternalState(IIOHandler handler);
}
