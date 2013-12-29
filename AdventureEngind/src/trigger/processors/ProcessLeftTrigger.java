package trigger.processors;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import objects.IGameObject;

import data.IDungeon;
import data.IRoom;
import data.ModelConverter;
import testgame.AvatarObject;
import trigger.ITrigger;
import trigger.TriggerProcessor;
import trigger.WarpTrigger;
import ui.IGameModel;
import ui.IUIController;

public class ProcessLeftTrigger extends TriggerProcessor implements
		IDungeonProcessor {

	@Override
	public void processTrigger(IDungeon dungeon) {


	}

	@Override
	public void postProcess(IDungeon dungeon, IUIController controller, ITrigger trigger) {
		IRoom room = (IRoom) dungeon.getLeftMapping(dungeon.getCurrentRoom());
		WarpTrigger castedTrigger = (WarpTrigger) trigger;
		int roomIndex = dungeon.getRoomIndex(room);
		if(roomIndex == -1){
			return;
		}
		IRoom newRoom = dungeon.getRoom(roomIndex);
		IRoom currentRoom = dungeon.getCurrentRoom();
		IRoom convertedRoom = ModelConverter.getInstance().convertModelToRoom(controller.getModel());
		convertedRoom.setId(currentRoom.getId());
		ModelConverter.getInstance().replaceDungeonRooms(currentRoom, convertedRoom, dungeon);
		dungeon.setCurrentRoom(newRoom);
		IGameObject avatarObject = controller.getModel().getAvatar();
		avatarObject.setX(castedTrigger.getNewX());
		avatarObject.setY(castedTrigger.getNewY());
		dungeon.setCurrentRoom(newRoom);
		room = dungeon.getCurrentRoom();
		IGameModel model = ModelConverter.getInstance().convertRoomToModel(newRoom);
		avatarObject.setInternalState(IGameObject.InternalObjectStates.DEFAULT_STATE);
		model.setAvatar(avatarObject);
		model.addObject(avatarObject);
		controller.setModel(model);
		
	}

}
