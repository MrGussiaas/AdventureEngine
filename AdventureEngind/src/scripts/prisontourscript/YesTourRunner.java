package scripts.prisontourscript;

import java.awt.Point;

import objects.IGameObject.InternalObjectStates;
import objects.backally.Boy1;
import objects.optiondialogue.OptionDialogue;
import objects.prisoninterior.TourGuide;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.InitWayPointForGeneralObjectScript;
import scripts.gamescripts.InitWayPointForObjectByClassScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.RemoveObjectFromModelByClassScript;
import scripts.gamescripts.SetObjectInternalStateScriptByClass;
import scripts.gamescripts.TickerScript;
import scripts.gamescripts.WalkRefreshScript;
import scripts.gamescripts.WalkRefreshScriptGeneralObjectByClass;

public class YesTourRunner extends ConcreteScriptRunner {
	public YesTourRunner(){
		ICompositeScript guidSyncScript1 = new RefreshableCompositeScript();
		ICompositeScript guidSyncScript2 = new RefreshableCompositeScript();
		ICompositeScript guidSyncScript3 = new RefreshableCompositeScript();
		ICompositeScript guidSyncScript4 = new RefreshableCompositeScript();
		addScript(new RemoveObjectFromModelByClassScript(OptionDialogue.class));
		addScript(new TickerScript(2));
		addScript(new InitWayPointForObjectByClassScript(TourGuide.class, new Point(620, 180)));
		addScript(new InitWayPointForObjectByClassScript(TourGuide.class, new Point(620, 220)));
		addScript(new InitWayPointForObjectByClassScript(TourGuide.class, new Point(550, 220)));
		addScript(new SetObjectInternalStateScriptByClass(InternalObjectStates.WALKING_STATE, TourGuide.class));
		//WalkRefreshScriptGeneralObjectByClass tourWalk1Script = new WalkRefreshScriptGeneralObjectByClass(TourGuide.class);
		guidSyncScript1.addScript(new WalkRefreshScriptGeneralObjectByClass(TourGuide.class));
		addScript(guidSyncScript1);
		/*addScript(new InitWayPointForObjectByClassScript(TourGuide.class, new Point(620, 220)));
		addScript(new SetObjectInternalStateScriptByClass(InternalObjectStates.WALKING_STATE, TourGuide.class));
		guidSyncScript2.addScript(new WalkRefreshScriptGeneralObjectByClass(TourGuide.class));
		addScript(guidSyncScript2);
		addScript(new InitWayPointForObjectByClassScript(TourGuide.class, new Point(550, 220)));
		addScript(new SetObjectInternalStateScriptByClass(InternalObjectStates.WALKING_STATE, TourGuide.class));
		guidSyncScript3.addScript(new WalkRefreshScriptGeneralObjectByClass(TourGuide.class));
		addScript(guidSyncScript3);*/
		
		addScript(new InitWayPointForObjectByClassScript(TourGuide.class, new Point(309, 159)));
		addScript(new SetObjectInternalStateScriptByClass(InternalObjectStates.WALKING_STATE, TourGuide.class));
		guidSyncScript4.addScript(new WalkRefreshScriptGeneralObjectByClass(TourGuide.class));
		addScript(guidSyncScript4);
		
		addScript(new EOTScript());
	}
}
