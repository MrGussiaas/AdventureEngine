package trigger.processors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JOptionPane;

import objects.savegamedialoge.SaveGameDialogue;
import trigger.ITrigger;
import ui.IGameModel;
import ui.IUIController;
import data.IDungeon;
import data.IRoom;
import data.ModelConverter;

public class SaveGameProcessor implements IDungeonProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processTrigger(IDungeon dungeon) {

		//JOptionPane.showMessageDialog(null, "hello");

	}


	@Override
	public void postProcess(IDungeon dungeon, IUIController controller, ITrigger trigger) {

		IRoom currentRoom = dungeon.getCurrentRoom();
		IRoom convertedRoom = ModelConverter.getInstance().convertModelToRoom(controller.getModel());
		ModelConverter.getInstance().replaceDungeonRooms(currentRoom, convertedRoom, dungeon);
		currentRoom.addObject(controller.getModel().getAvatar());
		ObjectOutputStream outputStream;
		try {
			
			SaveGameDialogue dialogue = (SaveGameDialogue) SaveGameDialogue.getInstance();
			File f = new File("."+File.separatorChar+"savedgames"+File.separatorChar+""+dialogue.getValue().toString());
			if(!f.exists()){
				f.createNewFile();
			}
			
			
			outputStream = new ObjectOutputStream(new FileOutputStream(f));
			outputStream.writeObject(dungeon);
			dungeon.setCurrentRoom(currentRoom);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		} catch (IOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		};
		
	}

}
