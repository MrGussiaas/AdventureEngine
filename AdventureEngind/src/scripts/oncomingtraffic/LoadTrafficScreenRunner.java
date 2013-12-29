package scripts.oncomingtraffic;

import java.awt.Point;

import objects.IGameObject;
import objects.gameoverdialog.GameOverDialogue;
import objects.oncomingtraffic.JerkyTruck;
import io.IIOHandler;
import io.IInputEvent;
import scripts.CompositeScript;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.IGameScript;
import scripts.IScriptRunner;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddNewEventToQueueScript;
import scripts.gamescripts.AddObjectToModelScript;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.InitWayPointForGeneralObjectScript;
import scripts.gamescripts.InitWayPointScript;
import scripts.gamescripts.LopHeadOffScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.SetAvatarInternalStateScript;
import scripts.gamescripts.WalkRefreshScript;
import scripts.gamescripts.WalkRefreshScriptGeneralObject;
import ui.IGameModel;

public class LoadTrafficScreenRunner extends ConcreteScriptRunner {
	public LoadTrafficScreenRunner(){
		//super.addScript(new MessageScript("Watch for the jerky truck"));
		//addScript(new MessageScript(null));
		ICompositeScript avatarWalkScript = new RefreshableCompositeScript();
		ICompositeScript truckWalkScript = new RefreshableCompositeScript();
		ICompositeScript avatarTruckSyncScript = new RefreshableCompositeScript();
		avatarTruckSyncScript.addScript(new WalkRefreshScript());
		JerkyTruck jerkyTruck = new JerkyTruck();
		avatarTruckSyncScript.addScript(new WalkRefreshScriptGeneralObject(jerkyTruck));
		avatarWalkScript.addScript(new WalkRefreshScript());
		truckWalkScript.addScript(new WalkRefreshScriptGeneralObject(jerkyTruck));
		addScript(new InitWayPointScript(new Point(500, 350)));
		addScript(avatarWalkScript);
		
		jerkyTruck.setX(-100);
		jerkyTruck.setY(300);
		super.addScript(new AddObjectToModelScript(jerkyTruck));
		addScript(new InitWayPointForGeneralObjectScript(new Point(500, 330), jerkyTruck));
		
		addScript(truckWalkScript);
		addScript(new SetAvatarInternalStateScript(IGameObject.InternalObjectStates.HIT_BY_A_TRUCK_STATE));
		addScript(new LopHeadOffScript());
		addScript(new InitWayPointForGeneralObjectScript(new Point(900, 330), jerkyTruck));
		addScript(avatarTruckSyncScript);

		
		
		addScript(new MessageScript("Well well well it appear as if you have just walked into oncoming traffic and were killed by a jerky truck."));
		addScript(new MessageScript("You always secretly dreamed of death by jerky but this is not at all whay you had in mind"));
		addScript(new AddObjectToModelScript(new GameOverDialogue()));
		addScript(new AddNewEventToQueueScript(IIOHandler.GameStates.GAME_OVER_STATE));
		super.addScript(new EOTScript());
	}
}
