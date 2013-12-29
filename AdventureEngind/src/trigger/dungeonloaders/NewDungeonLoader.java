package trigger.dungeonloaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import objects.restoregamedialog.RestoreGameDialog;

import data.IDungeon;
import testgame.AvatarObject;
import trigger.DungeonTrigger;
import trigger.ITrigger;
import ui.IGameModel;

public class NewDungeonLoader implements IDungeonLoaderProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public IDungeon loadNewDungeon(IDungeon currentDungeon, ITrigger trigger) {
		DungeonTrigger castedTrigger = (DungeonTrigger) trigger;
		IDungeon newDungeon = null;

		try {

			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(castedTrigger.getDungeonHandle()));
			
			newDungeon = (IDungeon) inputStream.readObject();
			AvatarObject avatarObject = new AvatarObject();
			avatarObject.setX(100);
			avatarObject.setY(100);
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
