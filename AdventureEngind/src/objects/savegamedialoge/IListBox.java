package objects.savegamedialoge;

import objects.IDrawableObject;
import objects.IInterfaceableObject;
import trigger.ITriggerHandler;

public interface IListBox extends IInterfaceableObject, ITriggerHandler, IDrawableObject, IScrollBarListener, ISelectionListener {
	public int getItemCount();
	public void addItem(Object item);
	public void removeItem(int index);
	public Object getItem(int index);
	
	public void addSelectionListener(ISelectionListener handler);
	public Object getSelectedItem();
	public void setSelectedItemIndex(int index);
	
	public IListCel getListCel(int index);
	
	public interface IListCelFactory{
		public IListCel createCel();
		public int getWidth();
		public int getHeight();
	}
	
	
}
