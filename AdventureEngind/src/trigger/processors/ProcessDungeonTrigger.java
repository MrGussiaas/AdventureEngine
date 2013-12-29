package trigger.processors;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import trigger.ITrigger;
import ui.IGameModel;
import ui.IUIController;
import data.IDungeon;
import data.IRoom;
import data.ModelConverter;

public class ProcessDungeonTrigger implements IDungeonProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processTrigger(IDungeon dungeon) {
		System.out.println("loading new Dungeon");

	}

	@Override
	public void postProcess(IDungeon dungeon, IUIController controller,
			ITrigger trigger) {
		IRoom currentRoom = dungeon.getCurrentRoom();
		IRoom convertedRoom = ModelConverter.getInstance().convertModelToRoom(controller.getModel());
		ModelConverter.getInstance().replaceDungeonRooms(currentRoom, convertedRoom, dungeon);
		ObjectOutputStream outputStream;
		try {
			
			outputStream = new ObjectOutputStream(new FileOutputStream(dungeon.getFileName()));
			outputStream.writeObject(dungeon);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
