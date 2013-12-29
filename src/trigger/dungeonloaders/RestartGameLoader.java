package trigger.dungeonloaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import objects.IDrawableObject;

import testgame.AvatarObject;
import trigger.DungeonRoomTrigger;
import trigger.ITrigger;
import trigger.RestartGameTrigger;
import ui.IGameModel;
import data.IDungeon;

public class RestartGameLoader implements IDungeonLoaderProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDungeon loadNewDungeon(IDungeon currentDungeon, ITrigger trigger) {
		RestartGameTrigger castedTrigger = (RestartGameTrigger) trigger;
		IDungeon newDungeon = null;

		try {

			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(castedTrigger.getDungeonHandle()));
			
			newDungeon = (IDungeon) inputStream.readObject();
			//AvatarObject avatarObject = new AvatarObject();
			//avatarObject.setX(50);
			//avatarObject.setY(90);
			//avatarObject.setHeight(avatarObject.createImage().getHeight(null));
			//avatarObject.setWidth(avatarObject.createImage().getWidth(null));
			newDungeon.setCurrentRoom(newDungeon.getInitialRoom());
			//newDungeon.getCurrentRoom().addObject(avatarObject);

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
