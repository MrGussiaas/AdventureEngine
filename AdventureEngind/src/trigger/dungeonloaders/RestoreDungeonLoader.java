package trigger.dungeonloaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import objects.restoregamedialog.RestoreGameDialog;
import trigger.ITrigger;
import ui.IGameModel;
import data.IDungeon;
import data.IRoom;
import data.ModelConverter;

public class RestoreDungeonLoader extends NewDungeonLoader {

	@Override
	public IDungeon loadNewDungeon(IDungeon currentDungeon, ITrigger trigger) {
		RestoreGameDialog dialog = (RestoreGameDialog) RestoreGameDialog.getInstance();
		String selectedGame = dialog.getValue().toString();
		IDungeon newDungeon = null;

		try {

			ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(".\\savedgames\\"+selectedGame));
			newDungeon = (IDungeon) inputStream.readObject();


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
