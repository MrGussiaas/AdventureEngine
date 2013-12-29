package objects;

import java.awt.event.KeyEvent;

public interface IInterfaceableObject {
	public void mouseLeft();
	public void mouseUp();
	public void keyTyped(KeyEvent event);
	public Object getValue();
	public void setValue(Object object);
	public void mouseEntered();
	public void mouseExited();
}
