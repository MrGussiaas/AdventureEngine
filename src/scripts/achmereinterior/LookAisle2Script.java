package scripts.achmereinterior;

import scripts.ConcreteScriptRunner;
import scripts.gamescripts.EOTScript;
import scripts.gamescripts.MessageScript;

public class LookAisle2Script extends ConcreteScriptRunner {
	public LookAisle2Script(){
		addScript(new MessageScript("Aisle 2 of Achmere's convenience store and you see nothing of interest."));
		addScript(new EOTScript());
	}
}
