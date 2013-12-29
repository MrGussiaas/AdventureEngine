package commands;

import io.IInputEvent;

import java.util.ArrayList;
import java.util.List;

public class UniversalCommandQueue {
	private static UniversalCommandQueue instance;
	private List<IInputEvent> commandQueue = new ArrayList<IInputEvent>(10);
	
	public static UniversalCommandQueue getInstance(){
		if(instance == null){
			instance = new UniversalCommandQueue();
		}
		return instance;
	}
	
	public int getEventCount(){
		return commandQueue.size();
	}
	
	public void addEvent(IInputEvent event){
		commandQueue.add(event);
	}
	
	public IInputEvent getEvent(int index){
		return commandQueue.get(index);
	}
	
	public void removeEvent(int index){
		commandQueue.remove(index);
	}
	
	private UniversalCommandQueue(){}
	
	
	
}
