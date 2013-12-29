package commands;

import io.IInputEvent;

import java.awt.Frame;

import ui.IUIController;

public interface IOCommand {
	public void runCommand(IUIController controller, IInputEvent event);
}
