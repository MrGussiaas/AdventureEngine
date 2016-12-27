package trigger.processors;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JOptionPane;

import objects.restoregamedialog.RestoreGameDialog;
import trigger.ITrigger;
import ui.IGameModel;
import ui.IUIController;
import data.IDungeon;

public class RestoreGameProcessor implements IDungeonProcessor {

	@Override
	public void processTrigger(ITrigger trigger, IGameModel model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processTrigger(IDungeon dungeon) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postProcess(IDungeon dungeon, IUIController controller, ITrigger trigger) {
		RestoreGameDialog dialog = (RestoreGameDialog) RestoreGameDialog.getInstance();
		String selectedGame = dialog.getValue().toString();
	IDungeon newDungeon = null;
	
	try {
		
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("."+File.separatorChar+"rooms"+File.separatorChar+"testdungeon.dgn"));
		newDungeon = (IDungeon) inputStream.readObject();
		dungeon = null;
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		JOptionPane.showMessageDialog(null, e.getMessage());
	} catch (IOException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	} catch (ClassNotFoundException e) {
		JOptionPane.showMessageDialog(null, e.getMessage());
	}
	}

}
