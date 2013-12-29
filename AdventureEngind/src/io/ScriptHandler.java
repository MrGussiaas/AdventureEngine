package io;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import scripts.ConcreteScriptRunner;
import scripts.IScriptRunner;
import scripts.IScriptableObject;
import scripts.ScriptRegistry;
import ui.ConcreteUIController;

public class ScriptHandler extends ConcreteIOHandler {
	private IScriptRunner runner;
	private Map<Class<?>, IScriptRetriever> scriptRetrievers = new HashMap<Class<?>, IScriptRetriever>(10);
	
	public ScriptHandler() {
		super();
		scriptRetrievers.put(LeftClickEvent.class, new IScriptRetriever(){

			@Override
			public IScriptRunner getRunner(IInputEvent event) {
				LeftClickEvent castedEvent = (LeftClickEvent) event;
				return ScriptRegistry.getInstance().createRunner(getInternalState(), (IScriptableObject) castedEvent.getClickedObject());
			}
			
		});
		
		scriptRetrievers.put(ScreenLoadedEvent.class, new IScriptRetriever(){

			@Override
			public IScriptRunner getRunner(IInputEvent event) {
				ScreenLoadedEvent castedEvent = (ScreenLoadedEvent) event;
				return castedEvent.getScreenLoadScript().getActionScript();
			}
			
		});
		

			
		
	}



	private interface IScriptRetriever{
		public IScriptRunner getRunner(IInputEvent event);
	}
	
	
	
	public void processEvent(IInputEvent event) {
		if(runner == null){
			runner = scriptRetrievers.get(event.getClass()).getRunner(event);
			
		}
		
		else{
			runner.processUIEvent(event);
		}
		if(runner.isComplete()){
			super.setInternalState(IIOHandler.InternalStates.DEFAULT_STATE);
			runner = null;
			return;
		}
		runner.execute(super.getController().getModel());
		
		

	}

	
}
