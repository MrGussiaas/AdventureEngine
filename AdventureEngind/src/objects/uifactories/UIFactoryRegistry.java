package objects.uifactories;

import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.IUIFactory;
import objects.inventorywindow.InventoryWindow;
import objects.restoregamedialog.RestoreGameDialog;
import objects.savegamedialoge.SaveGameDialogue;

public class UIFactoryRegistry {
	private static UIFactoryRegistry instance;
	private Map<Class<?>, IUIFactory> factories = new HashMap<Class<?>, IUIFactory>(10);
	public static UIFactoryRegistry getInstance(){
		if(instance == null){
			instance = new UIFactoryRegistry();
		}
		return instance;
	}
	
	private static final IUIFactory DEFAULT = new IUIFactory(){

		@Override
		public void initUIComponent(IInterfaceableObject object) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void initUIComponent(IInterfaceableObject object,
				IGameObject gameObject) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private UIFactoryRegistry(){
		factories.put(SaveGameDialogue.class, new SaveGameDialogFactory());
		factories.put(RestoreGameDialog.class, new RestoreGameDialogFactory());
		factories.put(InventoryWindow.class, new InventoryWindowFactory());
	}
	
	public IUIFactory getFactory(Class<?> clazz){
		IUIFactory answer = factories.get(clazz);
		if(answer == null){
			answer = DEFAULT;
		}
		return answer;
	}
}
