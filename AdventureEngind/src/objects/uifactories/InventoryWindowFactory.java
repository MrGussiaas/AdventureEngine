package objects.uifactories;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.IUIFactory;
import objects.inventorywindow.InventoryWindow;
import objects.savegamedialoge.IListBox;

public class InventoryWindowFactory implements IUIFactory {

	@Override
	public void initUIComponent(IInterfaceableObject object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initUIComponent(IInterfaceableObject object,
			IGameObject gameObject) {
		InventoryWindow casted = (InventoryWindow) object;
		IListBox listBox = casted.getListBox();
		for(int i = 0, n = listBox.getContainedObjectsCount(); i < n; i++){
			listBox.removeItem(0);
		}
		
		for(int i = 0, n = gameObject.getContainedObjectsCount(); i < n; i++){
			//listBox.addContainedObject(gameObject.getContainedObject(i));
			listBox.addItem(gameObject.getContainedObject(i));
		}

	}

}
