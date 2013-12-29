package commands;

import io.IInputEvent;
import io.RefreshEvent;

import java.awt.Frame;

import ui.IUIController;
import ui.TestFrame;

public class RefreshCommand implements IOCommand {

	@Override
	public void runCommand(IUIController controller, IInputEvent event) {
		RefreshEvent castedEvent = (RefreshEvent) event;
		TestFrame castedFrame = castedEvent.getFrame();
		controller.refreshView();
		castedFrame.refresh(controller.getView());

	}

}
