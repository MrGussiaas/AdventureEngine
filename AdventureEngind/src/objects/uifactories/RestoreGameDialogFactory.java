package objects.uifactories;

import java.io.File;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.IUIFactory;
import objects.restoregamedialog.RestoreGameDialog;
import objects.savegamedialoge.IListBox;
import objects.savegamedialoge.SaveGameDialogue;

public class RestoreGameDialogFactory implements IUIFactory {

	@Override
	public void initUIComponent(IInterfaceableObject object) {
		RestoreGameDialog castedObject = (RestoreGameDialog) object;
		IListBox listBox = castedObject.getListBox();
		for(int i = 0, n = listBox.getItemCount(); i < n; i++){
			listBox.removeItem(0);
		}
		File f = new File("."+File.separatorChar+"savedgames");
		String[] files = f.list();
		for(int i = 0, n = files.length; i < n; i++){
			listBox.addItem(files[i]);
		}

	}

	@Override
	public void initUIComponent(IInterfaceableObject object,
			IGameObject gameObject) {
		// TODO Auto-generated method stub
		
	}

}
