package objects.uifactories;

import io.IIOHandler;
import io.IIOHandler.InternalStates;

import java.awt.Cursor;
import java.util.HashMap;
import java.util.Map;

import objects.IGameObject;
import objects.uifactories.cursors.ActionCursorFactory;
import objects.uifactories.cursors.ArrowCursorFactory;
import objects.uifactories.cursors.LookCursorFactory;
import objects.uifactories.cursors.ObjectUseCursorFactory;
import objects.uifactories.cursors.TalkCursorFactory;
import objects.uifactories.cursors.WalkCursorFactory;
import ui.IGameModel;

public class CursorFactoryRegistry {
	private Map<IIOHandler.InternalStates, ICursorFactory> factories = new HashMap<IIOHandler.InternalStates, ICursorFactory>(10);
	
	private static CursorFactoryRegistry instance;
	
	public static CursorFactoryRegistry getInstance(){
		if(instance == null){
			instance = new CursorFactoryRegistry();
		}
		return instance;
	}
	
	private CursorFactoryRegistry(){
		factories.put(InternalStates.WALK_STATE, new WalkCursorFactory());
		factories.put(InternalStates.LOOK_STATE, new LookCursorFactory());
		factories.put(InternalStates.TALK_STATE, new TalkCursorFactory());
		factories.put(InternalStates.ACTION_STATE, new ActionCursorFactory());
		factories.put(InternalStates.HUD_STATE, new ArrowCursorFactory());
		factories.put(InternalStates.OBJECT_USE_STATE, new ObjectUseCursorFactory());
		factories.put(InternalStates.GAME_OVER_STATE, new ArrowCursorFactory());
	}
	
	private ICursorFactory defaultCursor = new ICursorFactory(){

		@Override
		public Cursor makeCursor(IGameModel model, IGameObject objectClicked) {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public ICursorFactory getFactory(IIOHandler.InternalStates state){
		ICursorFactory answer = factories.get(state);
		if(answer == null){
			return defaultCursor;
		}
		return answer;
	}
}
