package commands.uihandlers;

import objects.IGameObject;
import objects.IInterfaceableObject;
import io.IInputEvent;

public interface IUIEventHandler {
	public void handleEvent(IInputEvent event, IInterfaceableObject object);
}
