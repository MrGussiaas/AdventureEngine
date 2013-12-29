package io;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public interface IOPropogater extends MouseListener, KeyListener, MouseMotionListener{
	public void fireEvent(IInputEvent event);
	public void addIIOHandler(IIOHandler handler);
	public int getHandlerCount();
	public void removeHandler(int index);
	public void removeAllHandlers();
}
