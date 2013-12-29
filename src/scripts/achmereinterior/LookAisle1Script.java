package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class LookAisle1Script extends ConcreteScriptRunner {
	public LookAisle1Script(){
		addScript(new MessageScript("Aisle 1 of Achmere's convenience store and you see nothing of interest."));
		addScript(new EOTScript());
	}
}
