package scripts;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import objects.IGameObject;
import io.IIOHandler;

public class ScriptRegistry {
	
	private static ScriptRegistry instance;
	
	public static ScriptRegistry getInstance(){
		if(instance == null){
			instance = new ScriptRegistry();
		}
		return instance;
	}
	
	private ScriptRegistry(){
		scripts.put(IIOHandler.InternalStates.ACTION_STATE, actionAssembler);
		scripts.put(IIOHandler.InternalStates.LOOK_STATE, lookAssembler);
		scripts.put(IIOHandler.InternalStates.TALK_STATE, talkAssembler);
	}
	
	private static interface IScriptRunnerAssembler{
		public IScriptRunner makeScriptRunner(IScriptableObject object);
	}
	
	private static IScriptRunnerAssembler lookAssembler = new IScriptRunnerAssembler(){
		public IScriptRunner makeScriptRunner(IScriptableObject object) {
			IScriptRunner answer = new ConcreteScriptRunner();
			IScriptRunner temp = object.getLookScript();
			if(temp == null){
				return defaultAssembler.makeScriptRunner(object);
			}
			for(int i = 0, n = temp.getScriptCount(); i < n; i++){
				temp.getScript(i).setFinished(false);
				answer.addScript(temp.getScript(i));
			}
			return answer;
		}

	};
	
	private static IScriptRunnerAssembler talkAssembler = new IScriptRunnerAssembler(){

		@Override
		public IScriptRunner makeScriptRunner(IScriptableObject object) {
			IScriptRunner answer = new ConcreteScriptRunner();
			IScriptRunner temp = object.getTalkScript((IGameObject) object);
			if(temp == null){
				return defaultAssembler.makeScriptRunner(object);
			}
			for(int i = 0, n = temp.getScriptCount(); i < n; i++){
				answer.addScript(temp.getScript(i));
			}
			return answer;
		}
		
	};
	
	private static IScriptRunnerAssembler actionAssembler = new IScriptRunnerAssembler(){

		@Override
		public IScriptRunner makeScriptRunner(IScriptableObject object) {
			IScriptRunner answer = new ConcreteScriptRunner();
			IScriptRunner temp = object.getActionScript();
			if(temp == null){
				return defaultAssembler.makeScriptRunner(object);
			}
			for(int i = 0, n = temp.getScriptCount(); i < n; i++){
				temp.getScript(i).setFinished(false);
				answer.addScript(temp.getScript(i));
			}
			return answer;
		}
		
	};
	
	private static IScriptRunnerAssembler defaultAssembler = new IScriptRunnerAssembler(){

		@Override
		public IScriptRunner makeScriptRunner(IScriptableObject object) {
			return new ConcreteScriptRunner();
		}
		
	};
	
	private Map<IIOHandler.InternalStates, IScriptRunnerAssembler> scripts = new HashMap<IIOHandler.InternalStates, IScriptRunnerAssembler>(10);
	
	public IScriptRunner createRunner(IIOHandler.InternalStates state, IScriptableObject object){
		IScriptRunnerAssembler answer = scripts.get(state);
		if(answer == null){
			return defaultAssembler.makeScriptRunner(object);
		}
		return answer.makeScriptRunner(object);
	}
}
