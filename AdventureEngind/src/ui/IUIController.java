package ui;

import java.awt.Image;

import io.IInputEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;

import trigger.ITriggerHandler;
import trigger.ITriggerModelHandler;

public interface IUIController extends ITriggerModelHandler{

	public Image getView();
	public void refreshView();
	public void setView(Image view);
	public void setModel(IGameModel model);
	public IGameModel getModel();
	public void addITriggerHandler(ITriggerHandler handler);

	
}
