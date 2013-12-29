package data;

import io.ScreenLoadedEvent;

import java.util.HashMap;
import java.util.Map;

import commands.UniversalCommandQueue;

import objects.BackgroundObject;
import objects.BarrierObject;
import objects.IBarrierObject;
import objects.IDrawableObject;
import objects.IGameObject;
import objects.IInterfaceableObject;
import screensettings.ScreenConverterUtils;
import screensettings.ScreenSettings;
import scripts.ScreenLoadScript;
import testgame.AvatarObject;
import trigger.ITrigger;
import ui.ConcreteGameModel;
import ui.IGameModel;

public class ModelConverter {
	private static ModelConverter instance;
	private static IGameObjectProcessor DEFAULT_PROCESSOR = new IGameObjectProcessor(){

		@Override
		public void processGameObject(IGameModel model, IGameObject object) {
			model.addObject(object);
			
		}
		
	};
	private ModelConverter(){
		objectProcessors.put(BarrierObject.class, new IGameObjectProcessor(){

			@Override
			public void processGameObject(IGameModel model, IGameObject object) {
				model.addBarrier((IBarrierObject) object);
				model.addObject(object);
				
			}
			
		});
		
		objectProcessors.put(AvatarObject.class, new IGameObjectProcessor(){

			@Override
			public void processGameObject(IGameModel model, IGameObject object) {
				model.setAvatar(object);
				model.addObject(object);
				
			}
			
		});
		
		objectProcessors.put(BackgroundObject.class, new IGameObjectProcessor(){

			@Override
			public void processGameObject(IGameModel model, IGameObject object) {
				model.setBackgroundObject((BackgroundObject) object);
				
			}
			
		});
		
		objectProcessors.put(ScreenLoadScript.class, new IGameObjectProcessor(){

			@Override
			public void processGameObject(IGameModel model, IGameObject object) {
				model.addObject(object);
				ScreenLoadScript script = (ScreenLoadScript) object;
				UniversalCommandQueue.getInstance().addEvent(new ScreenLoadedEvent(script.getScript()));
				
			}
			
		});
	}
	
	private IGameObjectProcessor getProcessor(Class<?> clazz){
		IGameObjectProcessor answer = objectProcessors.get(clazz);
		if(answer == null){
			answer = DEFAULT_PROCESSOR;
		}
		return answer;
	}
	
	private Map<Class<?>, IGameObjectProcessor> objectProcessors = new HashMap<Class<?>, IGameObjectProcessor>(10);
	
	private interface IGameObjectProcessor{
		public void processGameObject(IGameModel model, IGameObject object);
	}
	
	public static ModelConverter getInstance(){
		if(instance == null){
			instance = new ModelConverter();
		}
		return instance;
	}
	
	public IRoom convertModelToRoom(IGameModel model){
		IRoom answer = new ConcreteRoom();
		
		for(int i = 0, n = model.getObjectCount(); i < n ; i++){
			IGameObject object = model.getObject(i);
			if(!(object instanceof IInterfaceableObject)){
				answer.addObject(model.getObject(i));
			}
		}	
		answer.addObject(model.getBackgroundObject());
		for(int i = 0, n = model.getTriggerCount(); i < n; i++){
			answer.addTrigger(model.getTrigger(i));
		}
		return answer;
	}
	
	public void replaceDungeonRooms(IRoom roomToReplace, IRoom newRoom, IDungeon dungeon){
		int roomIndex = dungeon.getRoomIndex(roomToReplace);
		if(roomIndex == -1){
			return;
		}
		IRoom room = dungeon.getRoom(roomIndex);
		for(int i = 0, n = roomToReplace.getObjectCount(); i < n; i++){
			roomToReplace.removeObject(0);
		}
		for(int i = 0, n = roomToReplace.getTriggerCount(); i < n; i++){
			roomToReplace.removeTrigger(0);
		}
		for(int i = 0, n = newRoom.getObjectCount(); i < n; i++){
			IGameObject object = newRoom.getObject(i);
			if(!(object instanceof AvatarObject)){
				roomToReplace.addObject(object);
			}
		}
		for(int i = 0, n = newRoom.getTriggerCount(); i < n; i++){
			roomToReplace.addTrigger(newRoom.getTrigger(i));
		}
	}
	
	public IGameModel convertRoomToModel(IRoom room){
		IGameModel answer = new ConcreteGameModel();
		for(int i = 0, n = room.getObjectCount(); i < n ; i++){
			IGameObject temp = room.getObject(i);
			IGameObjectProcessor processor = getProcessor(temp.getClass());
			processor.processGameObject(answer, temp);


			
		}
		for(int i = 0, n = room.getTriggerCount(); i < n; i++){
			answer.addTrigger(room.getTrigger(i));
		}
		return answer;
	}
}
