package commands.uihandlers;

import io.IInputEvent;
import objects.IGameObject;
import objects.IInterfaceableObject;

public class LeftClickHandler implements IUIEventHandler {

	@Override
	public void handleEvent(IInputEvent event, IInterfaceableObject object) {
		object.mouseUp();

	}

}
