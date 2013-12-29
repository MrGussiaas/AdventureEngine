package io;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commands.IObjectFinder;
import commands.ScriptEventRegistry;
import commands.finders.InterfaceableFinder;
import commands.finders.ObjectFinderRegistry;
import commands.uihandlers.IUIEventHandler;

import objects.IGameObject;
import objects.IInterfaceableObject;
import objects.hoverbutton.HoverButton;
import objects.optiondialogue.OptionDialogue;

import scripts.IScriptableObject;
import trigger.ITriggerHandler;
import ui.IGameModel;
import ui.IUIController;

public class ScriptCommandBridgeIO extends ConcreteIOHandler {
	
	private static final StateEventHandler DEFAULT_HANDLER = new StateEventHandler(){

		@Override
		public void handleStateSwitch(IInputEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	private interface StateEventHandler{
		public void handleStateSwitch(IInputEvent event);
	}
	
	private Map<Class<?>, StateEventHandler> eventHandlers = new HashMap<Class<?>, StateEventHandler>(10);
	
	private StateEventHandler getHandler(IInputEvent event){
		StateEventHandler answer = eventHandlers.get(event.getClass());
		if(answer == null){
			answer = DEFAULT_HANDLER;
		}
		return answer;
	}
	
	private IIOHandler.GameStates state = IIOHandler.GameStates.PLAYING;
	public void processEvent(IInputEvent event) {

		IGameModel model = super.getController().getModel();
		IObjectFinder interfaceFinder = ObjectFinderRegistry.getInstance().getFinder(InternalStates.SCRIPT_ONLY, event.getClass());
		IGameObject target = interfaceFinder.findObject(model, event);
		
		IUIEventHandler handler = ScriptEventRegistry.getInstance().getEventHandler(event.getClass());
		if(interfaceFinder!= null && interfaceFinder.getClass() == InterfaceableFinder.class){
			System.out.println(interfaceFinder.getClass());
		}
		if(target != null && handler != null){
			handler.handleEvent(event, (IInterfaceableObject) target);
		}
		getHandler(event).handleStateSwitch(event);
		
		if(state == IIOHandler.GameStates.PLAYING){
			commandHandler.processEvent(event);
		}
		if(state == IIOHandler.GameStates.SCRIPTING){
			scriptHandler.setInternalState(commandHandler.getInternalState());
			scriptHandler.processEvent(event);
		}
		if(scriptHandler.getInternalState() == IIOHandler.InternalStates.DEFAULT_STATE){
			state = IIOHandler.GameStates.PLAYING;
		}

	}
	
	
	
	public ScriptCommandBridgeIO(IIOHandler commandHandler2,
			IIOHandler scriptHandler) {
		super();

		
		eventHandlers.put(LeftClickEvent.class, new StateEventHandler(){

			@Override
			public void handleStateSwitch(IInputEvent event) {
				IObjectFinder finder =  ObjectFinderRegistry.getInstance().getFinder(commandHandler.getInternalState(), event.getClass());
				IGameModel model = commandHandler.getController().getModel();
				IGameObject clickedObject = finder.findObject(model, event);
				if(clickedObject instanceof IScriptableObject){
					state = IIOHandler.GameStates.SCRIPTING;
					LeftClickEvent castedEvent = (LeftClickEvent) event;
					castedEvent.setClickedObject(clickedObject);
				}
				
			}
			
		});
		
		eventHandlers.put(ScreenLoadedEvent.class, new StateEventHandler(){

			@Override
			public void handleStateSwitch(IInputEvent event) {
				IObjectFinder finder =  ObjectFinderRegistry.getInstance().getFinder(commandHandler.getInternalState(), event.getClass());
				IGameModel model = commandHandler.getController().getModel();
				IGameObject clickedObject = finder.findObject(model, event);
				if(clickedObject instanceof IScriptableObject){
					state = IIOHandler.GameStates.SCRIPTING;
				}
			}
			
		});
		
		eventHandlers.put(TriggerEvent.class, new StateEventHandler(){

			@Override
			public void handleStateSwitch(IInputEvent event) {
				TriggerEvent castedEvent = (TriggerEvent) event;
				ITriggerHandler castedHandler = (ITriggerHandler) commandHandler;
				castedHandler.handleTrigger(castedEvent.getTrigger());
				
			}
			
		});
		
		eventHandlers.put(StateSwitchEvent.class, new StateEventHandler(){

			@Override
			public void handleStateSwitch(IInputEvent event) {
				StateSwitchEvent castedEvent = (StateSwitchEvent) event;
				commandHandler.setInternalState(IIOHandler.InternalStates.GAME_OVER_STATE);
			}
			
		});
		
		this.commandHandler = commandHandler2;
		this.scriptHandler = scriptHandler;
		
	}



	private IIOHandler commandHandler;
	private IIOHandler scriptHandler;


}
