package io;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import commands.IOCommand;
import commands.IOCommandRegistry;

import ui.IUIController;

public class ConcreteIOHandler implements IIOHandler {

	private IUIController myController;
	private List<IIOHandler> forwardHandlers = new ArrayList<IIOHandler>(10);
	private IIOHandler.InternalStates internalState = IIOHandler.InternalStates.DEFAULT_STATE;
	
	public void processEvent(IInputEvent event) {
		IOCommand command = IOCommandRegistry.getInstance().getCommand(event.getClass());
		if(command != null){
			command.runCommand(myController, event);
		}
		for(int i = 0, n = forwardHandlers.size(); i < n; i++){
			forwardHandlers.get(i).processEvent(event);
		}

	}

	@Override
	public IUIController getController() {
		
		return myController;
	}

	@Override
	public void setController(IUIController controller) {
		this.myController = controller;

	}

	@Override
	public GameStates getGameState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setGameState(GameStates gameState) {
		// TODO Auto-generated method stub

	}

	@Override
	public InternalStates getInternalState() {
		// TODO Auto-generated method stub
		return internalState;
	}

	@Override
	public void setInternalState(InternalStates internalState) {
		this.internalState = internalState;

	}

	
	public void addForwardHandler(IIOHandler nextHandler) {
		forwardHandlers.add(nextHandler);
		
	}

}
