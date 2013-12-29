package trigger.processors;

import java.util.HashMap;
import java.util.Map;

import trigger.ITrigger;
import trigger.ITriggerProcessor;
import trigger.RemoveObjectTrigger;
import trigger.SetActiveInventoryItemTrigger;
import trigger.concreteDescriptors.WalkToTrigger;
import ui.IGameModel;

public class ControllerProcessors {
	private static ControllerProcessors instance;
	private Map<Class<?>, ITriggerProcessor> processors = new HashMap<Class<?>, ITriggerProcessor>(10);
	private ControllerProcessors(){
		processors.put(WalkToTrigger.class, new WalkToProcessor());
		processors.put(RemoveObjectTrigger.class, new RemoveObjectProcessor());
		processors.put(SetActiveInventoryItemTrigger.class, new SetActiveInventoryProcessor());
	}
	
	private ITriggerProcessor defaultProcessor = new ITriggerProcessor(){

		@Override
		public void processTrigger(ITrigger trigger, IGameModel model) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public static ControllerProcessors getInstance(){
		if(instance == null){
			instance = new ControllerProcessors();
		}
		return instance;
	}
	
	public ITriggerProcessor getProcessor(ITrigger trigger){
		ITriggerProcessor answer = processors.get(trigger.getClass());
		if(answer == null){
			return defaultProcessor;
		}
		return answer;
	}
}
