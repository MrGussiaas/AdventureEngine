package scripts.oncomingtraffic;

import java.awt.Point;

import objects.IGameObject;
import objects.backally.AllyCop;
import objects.backally.Boy1;
import objects.backally.Boy2;
import objects.backally.FireCracker;
import screensettings.ScreenSettings;
import scripts.ConcreteScriptRunner;
import scripts.ICompositeScript;
import scripts.RefreshableCompositeScript;
import scripts.gamescripts.AddObjectToModelScript;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.InitWayPointForObjectByClassScript;
import scripts.gamescripts.MessageScript;
import scripts.gamescripts.RemoveObjectFromModelByClassScript;
import scripts.gamescripts.RemoveObjectFromModelScript;
import scripts.gamescripts.SetObjectInternalStateScriptByClass;
import scripts.gamescripts.WalkRefreshScriptGeneralObjectByClass;

public class LoadAlleyRunner extends ConcreteScriptRunner {
	public LoadAlleyRunner(){
		addScript(new SetObjectInternalStateScriptByClass(IGameObject.InternalObjectStates.WALKING_STATE, Boy1.class));
		addScript(new SetObjectInternalStateScriptByClass(IGameObject.InternalObjectStates.WALKING_STATE, Boy2.class));
		addScript(new SetObjectInternalStateScriptByClass(IGameObject.InternalObjectStates.LIT, FireCracker.class));
		addScript(new InitWayPointForObjectByClassScript(Boy1.class, new Point(600, 200)));
		addScript(new InitWayPointForObjectByClassScript(Boy2.class, new Point(600, 200)));
		
		ICompositeScript boysSyncScript = new RefreshableCompositeScript();
		boysSyncScript.addScript(new WalkRefreshScriptGeneralObjectByClass(Boy1.class));
		boysSyncScript.addScript(new WalkRefreshScriptGeneralObjectByClass(Boy2.class));
		addScript(boysSyncScript);
		addScript(new SetObjectInternalStateScriptByClass(IGameObject.InternalObjectStates.EXPLODE, FireCracker.class));
		addScript(new RemoveObjectFromModelByClassScript(FireCracker.class));
		AllyCop allyCop = new AllyCop();
		addScript(new AddObjectToModelScript(allyCop));
		allyCop.setY(ScreenSettings.getInstance().getResHeight() - 50);
		allyCop.setX(ScreenSettings.getInstance().getResWide() / 2);
		addScript(new MessageScript("One of the cops from outside enters the ally. . ."));
		addScript(new MessageScript("He looks around as if to see what could have exploded.\n" +
				"Not seeing anthing at the moment he exits the ally mumbling something about a doughnut"));
		addScript(new RemoveObjectFromModelScript(allyCop));
				
		
		addScript(new EOTScript());
	}
}
