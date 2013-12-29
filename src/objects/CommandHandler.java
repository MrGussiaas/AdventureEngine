package objects;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import objects.uifactories.CursorFactoryRegistry;
import objects.uifactories.ICursorFactory;

import trigger.ITrigger;
import trigger.ITriggerDescriptor;
import trigger.ITriggerHandler;
import ui.IGameModel;

import commands.CommandRegistry;
import commands.ICommand;
import commands.IObjectFinder;
import commands.IPostProcessCommandContext;
import commands.concretecommands.ConcreteCommandContext;
import commands.finders.ObjectFinderRegistry;

import io.ConcreteIOHandler;
import io.IIOHandler;
import io.IIOHandler.GameStates;
import io.IIOHandler.InternalStates;
import io.IInputEvent;

public class CommandHandler extends ConcreteIOHandler implements ITriggerHandler{

	private List<IIOHandler.InternalStates> stateStack = new ArrayList<IIOHandler.InternalStates>(10);
	private InternalStates gameState = InternalStates.WALK_STATE;
	
	
	@Override
	public InternalStates getInternalState() {
		return gameState;
	}





	@Override
	public void setInternalState(InternalStates internalState) {
		this.gameState = internalState;
	}





	public void processEvent(IInputEvent event) {
		IObjectFinder finder =  ObjectFinderRegistry.getInstance().getFinder(gameState, event.getClass());
		Iterator<ICommand> commandSet= CommandRegistry.getInstance().getCommands(event, gameState);
		IPostProcessCommandContext context = new ConcreteCommandContext();
		
		IGameModel model = super.getController().getModel();
		context.setMessage(model.getOnScreenMessage());
		IGameObject clickedObject = finder.findObject(model, event);
		
		while(commandSet.hasNext()){
			ICommand nextCommand = commandSet.next();
			nextCommand.runCommand(context, clickedObject, model.getAvatar(), finder.getXClick(), finder.getYClick());
		}
		
		InternalStates newState = context.getNewState();
		if(newState != null && newState != IIOHandler.InternalStates.PREVIOUS_STATE){
			stateStack.add(0, gameState);
			gameState = newState;
		}
		else if (newState == IIOHandler.InternalStates.PREVIOUS_STATE && stateStack.size() > 0){
			gameState = stateStack.get(0);
			stateStack.remove(0);
		}
		ICursorFactory cursorFactory = CursorFactoryRegistry.getInstance().getFactory(gameState);
		Cursor newCursor = cursorFactory.makeCursor(model, clickedObject);
		if(newCursor != null){
			model.setCursor(newCursor);
		}
		
		model.setOnScreenMessage(context.getMessage());
		
		for(int i = 0, n = context.getNewObjectsCount(); i < n; i++){
			model.addObject(context.getNewObject(i));
		}
		
		for(int i = 0, n = context.getTriggerCount(); i < n; i++){
			super.getController().handleTrigger(context.getTrigger(i));
		}
		for(int i = 0, n = model.getTriggerCount(); i < n; i++){
			ITrigger trigger = model.getTrigger(i);
			if(trigger.isTriggerable(model.getAvatar())){
				super.getController().handleTrigger(trigger);
			}
		}
	}


	@Override
	public void handleTrigger(ITrigger descriptor) {
		super.getController().handleTrigger(descriptor);
		
	}



}
