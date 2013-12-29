package objects.savegamedialoge;

import objects.IDrawableObject;
import objects.IInterfaceableObject;
import trigger.ITriggerHandler;

public interface IListCel extends IDrawableObject, ITriggerHandler, IInterfaceableObject{
	public Object getValue();
	public void setValue(Object value);

	public boolean isSelected();
	public void setSelected(boolean selected);
	
	public void addSelectionListener(ISelectionListener handler);
	public void removeSelectionListener(ISelectionListener handler);
	
}
