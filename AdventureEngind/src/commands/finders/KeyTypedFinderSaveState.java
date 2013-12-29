package commands.finders;

import io.IInputEvent;
import io.KeyTypedEvent;
import objects.ConcreteObject;
import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.savegamedialoge.SaveGameDialogue;
import ui.IGameModel;

public class KeyTypedFinderSaveState extends LeftClickFinder{

	@Override
	public IGameObject findObject(IGameModel model, IInputEvent event) {
		// TODO Auto-generated method stub
		KeyTypedEvent castedEvent = (KeyTypedEvent) event;
		IInterfaceableObject interfaceObject = (IInterfaceableObject) SaveGameDialogue.getInstance();
		interfaceObject.keyTyped(castedEvent.getKeyEvent());
		return new ConcreteObject();
	}
	
}
