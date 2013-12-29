package commands.uihandlers;

import io.IInputEvent;
import objects.IGameObject;
import objects.IInterfaceableObject;

public class MouseMoveHandler implements IUIEventHandler {

	private IInterfaceableObject currentObject;
	public void handleEvent(IInputEvent event, IInterfaceableObject object) {
		if(currentObject == null){
			currentObject = object;
			currentObject.mouseEntered();
		}
		else if(object != currentObject){
			
			currentObject.mouseExited();
			object.mouseEntered();
			currentObject = object;
			
			
		}

	}

}
