package trigger;

import java.util.HashMap;
import java.util.Map;

import trigger.concreteDescriptors.MessageTriggerDescriptor;

public class CommandTriggerDescriptorFactory implements
		ITriggerDescriptorFactory {
	
	private static ITriggerDescriptorFactory instance;
	
	public static ITriggerDescriptorFactory getInstance(){
		if(instance == null){
			instance = new CommandTriggerDescriptorFactory();
		}
		return instance;
	}
	
	private CommandTriggerDescriptorFactory(){
		makers.put(AddMessageToModelTrigger.class, new IDescriptorMaker(){

			@Override
			public ITriggerDescriptor makeTrigger(ITrigger trigger) {
				AddMessageToModelTrigger castedTrigger = (AddMessageToModelTrigger) trigger;
				return new MessageTriggerDescriptor(castedTrigger.getMessage());
			}
			
		});
	}
	
	private interface IDescriptorMaker{
		public ITriggerDescriptor makeTrigger(ITrigger trigger);
	}
	
	private Map<Class<?>, IDescriptorMaker> makers = new HashMap<Class<?>, IDescriptorMaker>(10);
	
	@Override
	public ITriggerDescriptor getTriggerDescriptor(ITrigger trigger) {
		IDescriptorMaker maker = makers.get(trigger.getClass());
		if(maker != null){
			return maker.makeTrigger(trigger);
		}
		return null;
	}

}
