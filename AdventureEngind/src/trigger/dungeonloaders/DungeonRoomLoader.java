package trigger.dungeonloaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import testgame.AvatarObject;
import trigger.DungeonRoomTrigger;
import trigger.DungeonTrigger;
import trigger.ITrigger;
import ui.IGameModel;
import data.ConcreteRoom;
import data.IDungeon;
import data.IRoom;

public class DungeonRoomLoader implements IDungeonLoaderProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDungeon loadNewDungeon(IDungeon currentDungeon, ITrigger trigger) {
		DungeonRoomTrigger castedTrigger = (DungeonRoomTrigger) trigger;
		IDungeon newDungeon = null;

		try {

			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(castedTrigger.getDungeonHandle()));
			
			newDungeon = (IDungeon) inputStream.readObject();
			AvatarObject avatarObject = new AvatarObject();
			avatarObject.setX(castedTrigger.getExactPoint().getX());
			avatarObject.setY(castedTrigger.getExactPoint().getY());
			newDungeon.setCurrentRoom(newDungeon.getRoomById(castedTrigger.getRoomIndex()));
			newDungeon.getCurrentRoom().addObject(avatarObject);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return newDungeon;
	}

}
